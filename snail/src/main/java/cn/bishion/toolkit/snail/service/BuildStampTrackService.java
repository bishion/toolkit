package cn.bishion.toolkit.snail.service;

import cn.bishion.toolkit.common.dto.BaseReqInfo;
import cn.bishion.toolkit.common.service.BaseReqService;
import cn.bishion.toolkit.common.util.BaseAssert;
import cn.bishion.toolkit.common.util.EnvUtil;
import cn.bishion.toolkit.snail.annotation.Stamp;
import cn.bishion.toolkit.snail.consts.SnailError;
import cn.bishion.toolkit.snail.dto.StampTrack;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author: guofangbi
 * @date: 2022/6/5-12:29
 * @version: 1.0.0
 */
public class BuildStampTrackService {
    @Value("${spring.application.name}")
    private String appName;

    @Resource
    private Map<String, ActionParser> actionParserMap;
    @Resource
    private Map<String, ParamParser> paramParserMap;
    @Resource
    public BaseReqService baseReqService;

    public StampTrack.StampTrackBuilder createStampTrackBuilder(Stamp stamp, Object[] params) {
        StampTrack.StampTrackBuilder builder = StampTrack.builder();

        builder.appName(appName).hostIp(EnvUtil.HOST_IP).hostName(EnvUtil.LOCAL_HOSTNAME)
                .actionType(stamp.actionType());
        buildBaseReqInfo(builder);

        buildAnnoInfo(builder, stamp, params);

        return builder;
    }

    public void buildBaseReqInfo(StampTrack.StampTrackBuilder builder) {
        BaseReqInfo baseReqInfo = baseReqService.getBaseReqInfo();
        builder.clientIp(baseReqInfo.getClientIp()).operator(baseReqInfo.getOperator())
                .operatorName(baseReqInfo.getOperatorName());
    }

    public void buildAnnoInfo(StampTrack.StampTrackBuilder builder,
                              Stamp stamp, Object[] params) {
        builder.module(stamp.module()).actionType(stamp.actionType());
        ActionParser actionParser = actionParserMap.get(stamp.actionParser());
        BaseAssert.nonNull(actionParser, SnailError.ACTION_PARSER_NAME_WRONG, stamp.actionParser());
        String action = actionParser.parse(stamp.action(), params);
        builder.action(action);

        ParamParser paramParser = paramParserMap.get(stamp.paramParser());
        BaseAssert.nonNull(paramParser, SnailError.ACTION_PARSER_NAME_WRONG, stamp.actionParser());

        builder.param(paramParser.parse(params));
    }


}
