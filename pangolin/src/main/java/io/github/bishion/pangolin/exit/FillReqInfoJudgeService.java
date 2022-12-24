package io.github.bishion.pangolin.exit;

import feign.RequestTemplate;

/**
 * 是否填充默认的请求头
 *
 * @author: guofangbi
 * @version: 1.0.0
 * @since 2022-05-28 19:43:17
 */
public interface FillReqInfoJudgeService {
    /**
     * 安全设置要求信息
     * 判断设置请求头信息是否安全，主要解决不能把登录信息透传给第三方的问题
     *
     * @param requestTemplate 请求模板
     * @return boolean
     */
    boolean secureToSetReqInfo(RequestTemplate requestTemplate);
}
