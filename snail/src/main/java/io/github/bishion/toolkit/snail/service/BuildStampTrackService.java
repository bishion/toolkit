package io.github.bishion.toolkit.snail.service;

import io.github.bishion.common.biz.EnvService;
import io.github.bishion.common.biz.ReqInfoService;
import io.github.bishion.common.dto.BaseReqInfo;
import io.github.bishion.common.util.BaseAssert;
import io.github.bishion.toolkit.snail.annotation.Stamp;
import io.github.bishion.toolkit.snail.consts.SnailError;
import io.github.bishion.toolkit.snail.dto.StampTrack;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Map;

/**
 * @author: guofangbi
 * @version: 1.0.0
 * @since 2022/6/5-12:29
 */
public class BuildStampTrackService {
    @Value("${spring.application.name}")
    private String appName;
    @Resource
    private Map<String, SnailSpelParser> actionParserMap;
    @Resource
    private SnailSpelParser spelDefaultParser;
    @Resource
    private Map<String, ParamParser> paramParserMap;
    @Resource
    public ReqInfoService loginInfoService;

    @Resource
    private EnvService envService;

    public StampTrack.StampTrackBuilder createStampTrackBuilder(Stamp stamp, Object[] params, Date startTime) {
        StampTrack.StampTrackBuilder builder = StampTrack.builder();

        builder.appName(appName).hostIp(envService.hostIp()).hostName(envService.podName());
        builder.module(stamp.module()).actionType(stamp.actionType());

        buildBaseReqInfo(builder);
        buildParam(builder, stamp, params);

        return builder;
    }


    public void buildBaseReqInfo(StampTrack.StampTrackBuilder builder) {
        BaseReqInfo baseReqInfo = loginInfoService.currentReqInfo();
        builder.clientIp(baseReqInfo.getClientIp()).operatorNo(baseReqInfo.getOperatorNo())
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
