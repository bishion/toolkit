package cn.bishion.toolkit.pangolin.exit;

import feign.RequestTemplate;

/**
 * 要求事情信息法官服务
 *
 * @author: guofangbi
 * @date: 2022-05-28 19:43:17
 * @version: 1.0.0
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
