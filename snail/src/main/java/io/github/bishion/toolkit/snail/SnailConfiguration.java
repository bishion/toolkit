package io.github.bishion.toolkit.snail;

import cn.hutool.core.util.ArrayUtil;
import io.github.bishion.common.consts.BaseConst;
import io.github.bishion.toolkit.snail.aspect.StampAspect;
import io.github.bishion.toolkit.snail.service.*;
import io.github.bishion.toolkit.snail.service.impl.LogStampTracker;
import io.github.bishion.toolkit.snail.service.impl.SpelParseService;
import io.github.bishion.toolkit.snail.service.impl.StampTrackService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.expression.BeanFactoryResolver;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: guofangbi
 * @version: 1.0.0
 * @since 2022/6/5-13:13
 */
public class SnailConfiguration {
    @Bean
    public SnailSpelParser defaultActionParser() {
        return (action, params, resp) -> action;
    }

    @Bean
    public ParamParser defaultParamParser() {
        return params -> Arrays.deepToString(params);
    }

    @Bean
    public CloseoutService defaultCloseoutService() {
        return stampTrack -> {
            // 默认收尾啥都不做
        };
    }

    @Bean
    public StampTracker logStampTracker() {
        return new LogStampTracker();
    }

    @Bean
    public SnailSpelParser spelDefaultParser(SpelParseService spelParseService) {
        return (spel, params, resp) -> {
            Map<String, Object> param = new HashMap<>(BaseConst.INT_1);
            if (ArrayUtil.length(params) == BaseConst.INT_1) {
                param.put(SnailSpelParser.PARAM_REQ, params[BaseConst.INT_0]);
            } else {
                param.put(SnailSpelParser.PARAM_REQ, params);
            }
            param.put(SnailSpelParser.PARAM_RESP, resp);
            return spelParseService.parseSpel(spel, param);
        };

    }

    @Bean
    public SpelParseService spelParserService(BeanFactory beanFactory) {
        return new SpelParseService(new BeanFactoryResolver(beanFactory));
    }

    @Bean
    public StampTrackService stampTrackService() {
        return new StampTrackService();
    }

    @Bean
    public StampAspect stampAspect() {
        return new StampAspect();
    }

    @Bean
    public BuildStampTrackService buildStampTrackService() {
        return new BuildStampTrackService();
    }
}
