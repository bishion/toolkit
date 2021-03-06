package cn.bishion.toolkit.snail.service;

import cn.bishion.toolkit.common.dto.BaseReqInfo;
import cn.bishion.toolkit.common.service.BaseReqService;
import cn.bishion.toolkit.common.util.BaseAssert;
import cn.bishion.toolkit.common.util.EnvUtil;
import cn.bishion.toolkit.snail.annotation.Stamp;
import cn.bishion.toolkit.snail.consts.SnailError;
import cn.bishion.toolkit.snail.dto.StampTrack;
import cn.bishion.toolkit.snail.service.impl.SpelDefaultParser;
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
    private Map<String, SnailSpelParser> actionParserMap;
    @Resource
    private SpelDefaultParser spelDefaultParser;
    @Resource
    private Map<String, ParamParser> paramParserMap;
    @Resource
    public BaseReqService baseReqService;

    public StampTrack.StampTrackBuilder createStampTrackBuilder(Stamp stamp, Object[] params) {
        StampTrack.StampTrackBuilder builder = StampTrack.builder();

        builder.appName(appName).hostIp(EnvUtil.HOST_IP).hostName(EnvUtil.LOCAL_HOSTNAME);
        builder.module(stamp.module()).actionType(stamp.actionType());

        buildBaseReqInfo(builder);
        buildParam(builder, stamp, params);

        return builder;
    }


    public void buildBaseReqInfo(StampTrack.StampTrackBuilder builder) {
        BaseReqInfo baseReqInfo = baseReqService.getBaseReqInfo();
        builder.clientIp(baseReqInfo.getClientIp()).operator(baseReqInfo.getOperator())
                .operatorName(baseReqInfo.getOperatorName());
    }

    public void buildParam(StampTrack.StampTrackBuilder builder,
                           Stamp stamp, Object[] params) {
        ParamParser paramParser = paramParserMap.get(stamp.paramParser());
        BaseAssert.nonNull(paramParser, SnailError.ACTION_PARSER_NAME_WRONG, stamp.actionParser());

        builder.param(paramParser.parse(params));
    }

    public void buildReqAndResp(StampTrack.StampTrackBuilder builder,
                                Stamp stamp, Object[] params, Object resp) {

        SnailSpelParser snailSpelParser = actionParserMap.get(stamp.actionParser());
        BaseAssert.nonNull(snailSpelParser, SnailError.ACTION_PARSER_NAME_WRONG, stamp.actionParser());
        String action = snailSpelParser.parse(stamp.action(), params, resp);
        builder.action(action);

        ParamParser paramParser = paramParserMap.get(stamp.paramParser());
        BaseAssert.nonNull(paramParser, SnailError.ACTION_PARSER_NAME_WRONG, stamp.actionParser());

        builder.bizNo(spelDefaultParser.parse(stamp.bizNo(), params, resp));
    }

}
