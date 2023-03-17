package io.github.bishion.web.advice;

import cn.hutool.core.util.ClassUtil;
import cn.hutool.core.util.StrUtil;
import io.github.bishion.common.biz.ReqInfoService;
import io.github.bishion.common.consts.BaseConst;
import io.github.bishion.common.dto.BizException;
import io.github.bishion.common.util.JsonUtil;
import io.github.bishion.web.monitor.RequestMonitorService;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

@Aspect
public class GlobalLogAdvice implements MethodInterceptor {
    private static final Logger log = LoggerFactory.getLogger(GlobalLogAdvice.class);
    private static final String SEPARATOR = System.lineSeparator();

    private static final String MONITOR_MODULE_WEB_API = "WEB_API";

    @Resource
    private RequestMonitorService requestMonitorService;

    @Resource
    private ReqInfoService reqInfoService;

    @Value("${toolkit.log.length:1024}")
    private Integer maxLength;
    
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        // result的值就是被拦截方法的返回值
        Object result = null;
        String errorMsg = null;
        String successFlag = null;
        long startTimeMillis = System.currentTimeMillis();
        try {
            result = invocation.proceed();
            successFlag = BaseConst.SUCCESS;
        } catch (Throwable t) {
            errorMsg = t.toString();
            if (t instanceof BizException) {
                successFlag = BaseConst.FAILURE;
            } else {
                successFlag = BaseConst.ERROR;
            }
            throw t;
        } finally {
            doLog(invocation, successFlag, result, errorMsg, System.currentTimeMillis() - startTimeMillis);
        }
        return result;
    }

    private void doLog(MethodInvocation pjp, String successFlag, Object result, String errorMsg, long cost) {
        StringBuilder sb = new StringBuilder();
        HttpServletRequest request = getRequest();
        if (request != null) {
            sb.append(SEPARATOR).append(" ").append(request.getMethod()).append("-Url:")
                    .append(request.getRequestURI());
        }

        Class<?> targetClazz = pjp.getThis().getClass();
        Method mSig = pjp.getMethod();
        Method declaredMethod = ClassUtil.getDeclaredMethod(targetClazz, mSig.getName(), mSig.getParameterTypes());
        String methodName = String.format("%s.%s", targetClazz.getName(), declaredMethod.getName());
        sb.append(SEPARATOR).append(" Method:").append(methodName)
                .append(SEPARATOR).append(" Current ReqInfo:").append(reqInfoService.currentReqInfo())
                .append(SEPARATOR).append(" Input Param:").append(JsonUtil.toStr(assembleParams(pjp)))
                .append(SEPARATOR).append(" Processed_time:").append(cost).append("ms")
                .append(SEPARATOR).append(" Output Result:").append(StrUtil.subPre(JsonUtil.toStr(result), maxLength));
        if (StrUtil.isNotBlank(errorMsg)) {
            sb.append(SEPARATOR).append(" Error Msg:").append(errorMsg);
        }
        log.info(sb.toString());
        requestMonitorService.logRequest(MONITOR_MODULE_WEB_API, methodName, cost, successFlag, errorMsg);
    }

    private List<Object> assembleParams(MethodInvocation pjp) {
        Object[] args = pjp.getArguments();
        List<Object> argList = new ArrayList<>();
        if (args != null && args.length > 0) {
            for (Object arg : args) {
                if (!(arg instanceof ServletRequest)
                        && !(arg instanceof ServletResponse)
                        && !(arg instanceof MultipartFile)) {
                    argList.add(arg);
                }
            }
        }
        return argList;
    }

    /*private MethodSignature getMethodSignature(MethodInvocation pjp) {
        Signature sig = pjp.getMethod().get;
        MethodSignature mSig = null;
        if (!(sig instanceof MethodSignature)) {
            throw new IllegalArgumentException("该注解只能用于方法");
        }
        mSig = (MethodSignature) sig;
        return mSig;
    }*/

    private HttpServletRequest getRequest() {
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        return sra == null ? null : sra.getRequest();
    }


}
