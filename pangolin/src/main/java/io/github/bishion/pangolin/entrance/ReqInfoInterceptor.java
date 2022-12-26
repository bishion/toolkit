package io.github.bishion.pangolin.entrance;

import io.github.bishion.common.dto.BaseReqInfo;
import io.github.bishion.common.util.ReqInfoHolder;
import io.github.bishion.pangolin.util.ReqInfoUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 * 登录信息拦截器
 *
 * @author: guofangbi
 * @version: 1.0.0
 * @since 2022-05-28 09:30:30
 */
public class ReqInfoInterceptor implements HandlerInterceptor {
    private static final Logger log = LoggerFactory.getLogger(ReqInfoInterceptor.class);

    @Override
    public boolean preHandle(@Nullable HttpServletRequest request, @Nullable HttpServletResponse response, @Nullable Object handler) {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        if (Objects.isNull(request)) {
            log.error("请求信息为空. {}", ((HandlerMethod) handler).getMethod().toGenericString());
            return false;
        }
        BaseReqInfo reqInfo = ReqInfoUtil.getReqInfoByRequest(request);
        log.info("通用请求信息:{}", reqInfo);
        ReqInfoHolder.setReqInfo(reqInfo);
        return true;
    }

    @Override
    public void afterCompletion(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull Object handler, @Nullable Exception ex) {
        ReqInfoHolder.remove();
    }
}
