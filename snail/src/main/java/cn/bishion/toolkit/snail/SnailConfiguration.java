package cn.bishion.toolkit.snail;

import cn.bishion.toolkit.snail.aspect.StampAspect;
import cn.bishion.toolkit.snail.service.*;
import cn.bishion.toolkit.snail.service.impl.*;
import org.springframework.context.annotation.Bean;

/**
 * @author: guofangbi
 * @date: 2022/6/5-13:13
 * @version: 1.0.0
 */
public class SnailConfiguration {
    @Bean
    public ActionParser defaultActionParser() {
        return new DefaultActionParser();
    }

    @Bean
    public ParamParser defaultParamParser() {
        return new DefaultParamParser();
    }

    @Bean
    public CloseoutService defaultCloseoutService() {
        return new DefaultCloseoutService();
    }

    @Bean
    public StampTracker logStampTracker() {
        return new LogStampTracker();
    }

    @Bean
    public ActionParser spelActionParser() {
        return new SpelActionParser();
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
