package io.github.bishion.pangolin.entrance;

import cn.hutool.core.text.CharSequenceUtil;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.json.JSONUtil;
import io.github.bishion.common.consts.BaseConst;
import io.github.bishion.common.consts.BaseError;
import io.github.bishion.common.dto.BaseReqInfo;
import io.github.bishion.common.dto.BaseResult;
import io.github.bishion.common.dto.ReqInfoHolder;
import io.github.bishion.pangolin.consts.PangolinConst;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录信息拦截器
 *
 * @author: guofangbi
 * @date: 2022-05-28 09:30:30
 * @version: 1.0.0
 */
@Slf4j
public class ReqInfoInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, @NonNull HttpServletResponse response, @Nullable Object handler) throws IOException {
        String operator = request.getHeader(PangolinConst.HEAD_OPT);
        String fromApp = request.getHeader(PangolinConst.HEAD_FROM_APP);
        String source = request.getHeader(PangolinConst.HEAD_SOURCE);
        String fromKey = request.getHeader(PangolinConst.HEAD_FROM_KEY);
        String channel = request.getHeader(PangolinConst.HEAD_CHANNEL);
        String token = request.getHeader(PangolinConst.HEAD_TOKEN);
        String openId = request.getHeader(PangolinConst.HEAD_OPEN_ID);
        String operatorName = request.getHeader(PangolinConst.HEAD_OPT_NAME);
        String noLoginFlag = request.getHeader(PangolinConst.HEAD_NO_LOGIN);
        String clientIp = request.getHeader(PangolinConst.HEAD_CLIENT_IP);

        if (CharSequenceUtil.hasBlank(fromApp, source, fromKey, channel)) {
            log.warn("通用请求信息缺失. {},{},{},{},{}", fromApp, source, fromKey, channel, operator);

//            return buildFailResult(response, PangolinError.REQ_PARAM_VALID);
        }

        // 这里可以校验key
        if (!CharSequenceUtil.equals(SecureUtil.md5(fromApp + operator), fromKey)) {
            log.warn("通用请求安全校验失败. from:{},opt:{},key:{}", fromApp, operator, fromKey);
//            return buildFailResult(response, PangolinError.REQ_KEY_VALID);
        }
        BaseReqInfo baseReqInfo = BaseReqInfo.builder().channel(channel).fromApp(fromApp).
                operator(operator).operatorName(operatorName).sourceApp(source).openId(openId).token(token)
                .noLogin(CharSequenceUtil.equals(BaseConst.YES, noLoginFlag))
                .noLoginFlag(noLoginFlag).clientIp(clientIp)
                .build();
        ReqInfoHolder.setReqInfo(baseReqInfo);

        return true;
    }

    private boolean buildFailResult(HttpServletResponse response, BaseError error) throws IOException {
        response.setCharacterEncoding(CharsetUtil.UTF_8);
        response.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        response.getWriter().println(JSONUtil.toJsonStr(BaseResult.fail(error)));
        return false;
    }

    @Override
    public void afterCompletion(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull Object handler, @Nullable Exception ex) {
        ReqInfoHolder.removeOptInfo();
    }
}
