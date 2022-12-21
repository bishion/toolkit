package com.github.bishion.toolkit.snail;

import com.github.bishion.toolkit.snail.aspect.StampAspect;
import com.github.bishion.toolkit.snail.service.*;
import com.github.bishion.toolkit.snail.service.impl.*;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.expression.BeanFactoryResolver;

/**
 * @author: guofangbi
 * @date: 2022/6/5-13:13
 * @version: 1.0.0
 */
public class SnailConfiguration {
    @Bean
    public SnailSpelParser defaultActionParser() {
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
    public SnailSpelParser spelDefaultParser() {
        return new SpelDefaultParser();
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
