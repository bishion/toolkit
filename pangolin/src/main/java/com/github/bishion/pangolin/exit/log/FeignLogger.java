package com.github.bishion.pangolin.exit.log;

import cn.hutool.core.text.CharSequenceUtil;
import cn.hutool.core.util.StrUtil;
import com.github.bishion.common.consts.BaseConst;
import feign.Request;
import feign.Response;
import feign.Util;
import lombok.extern.slf4j.Slf4j;

import java.nio.charset.Charset;

/**
 * @author: guofangbi
 * @date: 2022/5/29-11:01
 * @version: 1.0.0
 */
@Slf4j
public class FeignLogger extends feign.Logger {

    private static final String HTTP_METHOD = "[{}]";
    private Integer maxLength;

    public FeignLogger(Integer maxLength) {
        this.maxLength = maxLength;
    }

    @Override
    protected void logRequest(String configKey, Level logLevel, Request request) {

    }

    @Override
    protected Response logAndRebufferResponse(String configKey, Level logLevel, Response response, long elapsedTime) {
        StringBuilder sb = new StringBuilder(configKey).append(BaseConst.SEPARATOR);
        try {
            Request request = response.request();
            String requestMsg = CharSequenceUtil.format(HTTP_METHOD, request.httpMethod()) + request.url();
            sb.append("Request: ").append(subStr(requestMsg)).append(BaseConst.SEPARATOR);

            boolean hasReqBody = request.requestTemplate().body() != null;
            String bodyMsg = hasReqBody ? new String(request.requestTemplate().body()) : "";
            sb.append("Param: ").append(bodyMsg).append(BaseConst.SEPARATOR);

            String responseMsg;
            int status = response.status();
            boolean hasResBody = response.body() != null && !(status == 204 || status == 205);
            if (hasResBody) {
                byte[] bodyData = Util.toByteArray(response.body().asInputStream());
                response = response.toBuilder().body(bodyData).build();
                responseMsg = StrUtil.str(bodyData, Charset.defaultCharset());
                sb.append("Resp: ").append(subStr(responseMsg));
            }
            log.info("callRemoteSuccess:{}", sb);
        } catch (Exception e) {
            log.error("callRemoteFailure:{}", sb, e);
        }
        return response;
    }

    @Override
    protected void log(String configKey, String format, Object... args) {
    }

    private String subStr(String s) {
        return (s != null && s.length() > maxLength) ? s.substring(0, maxLength) : s;
    }
}
