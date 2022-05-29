package cn.bishion.toolkit.pangolin.exit;

import cn.bishion.toolkit.pangolin.consts.PangolinConst;
import cn.bishion.toolkit.pangolin.entrance.dto.BaseReqInfo;
import cn.bishion.toolkit.pangolin.entrance.dto.ReqInfoHolder;
import cn.hutool.crypto.SecureUtil;
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
            template.header(PangolinConst.HEAD_SOURCE, reqInfo.getSource());
            template.header(PangolinConst.HEAD_TOKEN, reqInfo.getToken());
        }
    }
}
