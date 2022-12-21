package com.github.bishion.pangolin.exit;

import cn.hutool.crypto.SecureUtil;
import com.github.bishion.common.dto.BaseReqInfo;
import com.github.bishion.common.dto.ReqInfoHolder;
import com.github.bishion.pangolin.consts.PangolinConst;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.Resource;

/**
 * @author: guofangbi
 * @date: 2022/5/28-15:34
 * @version: 1.0.0
 */
public class FillReqInfo4FeignClientInterceptor implements RequestInterceptor {
    @Value("${spring.application.name}")
    private String appName;

    @Resource
    private FillReqInfoJudgeService reqInfoJudgeService;

    @Override
    public void apply(RequestTemplate template) {
        if (reqInfoJudgeService.secureToSetReqInfo(template)) {
            BaseReqInfo reqInfo = ReqInfoHolder.getReqInfo();
            template.header(PangolinConst.HEAD_FROM_APP, reqInfo.getFromApp());
            template.header(PangolinConst.HEAD_CHANNEL, reqInfo.getChannel());
            template.header(PangolinConst.HEAD_FROM_KEY,
                    SecureUtil.md5(appName + reqInfo.getOperator()));
            template.header(PangolinConst.HEAD_OPEN_ID, reqInfo.getOpenId());
            template.header(PangolinConst.HEAD_OPT, reqInfo.getOperator());
            template.header(PangolinConst.HEAD_SOURCE, reqInfo.getSourceApp());
            template.header(PangolinConst.HEAD_TOKEN, reqInfo.getToken());
            template.header(PangolinConst.HEAD_CLIENT_IP, reqInfo.getClientIp());
        }
    }
}
