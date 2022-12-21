package com.github.bishion.pangolin;

import com.github.bishion.pangolin.entrance.ReqInfoInterceptor;
import com.github.bishion.pangolin.exit.DefaultFillReqInfoJudgeService;
import com.github.bishion.pangolin.exit.FillReqInfo4FeignClientInterceptor;
import com.github.bishion.pangolin.exit.FillReqInfoJudgeService;
import com.github.bishion.pangolin.exit.log.FeignLogger;
import feign.Logger;
import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: guofangbi
 * @date: 2022/5/28-14:55
 * @version: 1.0.0
 */

public class PangolinConfiguration implements WebMvcConfigurer {
    @Value("${toolkit.pangolin.feign.logLength:1024}")
    private Integer maxLength;

    @Value("${toolkit.pangolin.exclude-path:/*,/webjars/*,/*/api-docs}")
    private List<String> excludePathPatterns;

    @Bean
    @ConditionalOnProperty(name = "${toolkit.pangolin.feign.enabled}", havingValue = "true", matchIfMissing = true)
    public RequestInterceptor requestInterceptor() {
        return new FillReqInfo4FeignClientInterceptor();
    }

    @Bean
    public ReqInfoInterceptor reqInfoInterceptor() {
        return new ReqInfoInterceptor();
    }

    @Bean
    @ConditionalOnMissingBean(FillReqInfoJudgeService.class)
    public FillReqInfoJudgeService fillReqInfoJudgeService() {
        return new DefaultFillReqInfoJudgeService();
    }

    @Resource
    private ReqInfoInterceptor reqInfoInterceptor;


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(reqInfoInterceptor).excludePathPatterns(excludePathPatterns);
    }

    @Bean
    @ConditionalOnProperty(name = "toolkit.pangolin.feign.logEnabled", havingValue = "true", matchIfMissing = true)
    public Logger logger() {
        return new FeignLogger(maxLength);
    }

    @Bean
    @ConditionalOnProperty(name = "za.mt.feign.aroundLog.enable", havingValue = "true", matchIfMissing = true)
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
