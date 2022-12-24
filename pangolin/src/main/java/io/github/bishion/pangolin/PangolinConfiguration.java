package io.github.bishion.pangolin;

import feign.RequestInterceptor;
import io.github.bishion.common.dto.BaseReqInfo;
import io.github.bishion.pangolin.entrance.ReqInfoInterceptor;
import io.github.bishion.pangolin.exit.FillReqInfoJudgeService;
import io.github.bishion.pangolin.exit.log.FeignLogger;
import io.github.bishion.pangolin.util.ReqInfoHolder;
import io.github.bishion.pangolin.util.ReqInfoUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * @author: guofangbi
 * @version: 1.0.0
 * @since 2022/5/28-14:55
 */

public class PangolinConfiguration implements WebMvcConfigurer {
    private static final Logger log = LoggerFactory.getLogger(PangolinConfiguration.class);
    @Value("${spring.application.name}")
    private String appName;
    @Value("${toolkit.pangolin.feign.logLength:1024}")
    private Integer maxLength;

    @Value("${toolkit.pangolin.exclude-path:/*,/webjars/*,/*/api-docs}")
    private List<String> excludePathPatterns;

    @Bean
    @ConditionalOnProperty(name = "${toolkit.pangolin.feign.enabled}", havingValue = "true", matchIfMissing = true)
    public RequestInterceptor requestInterceptor(FillReqInfoJudgeService fillReqInfoJudgeService) {
        return template -> {
            if (!fillReqInfoJudgeService.secureToSetReqInfo(template)) {
                return;
            }

            BaseReqInfo reqInfo = ReqInfoHolder.getReqInfo();
            if (Objects.isNull(reqInfo)) {
                log.error("请求信息缺失.{}", template.feignTarget().url());
            }
            template.headers(ReqInfoUtil.convert2MapList(reqInfo));
        };
    }

    @Bean
    public ReqInfoInterceptor reqInfoInterceptor() {
        return new ReqInfoInterceptor();
    }

    @Bean
    @ConditionalOnMissingBean(FillReqInfoJudgeService.class)
    public FillReqInfoJudgeService fillReqInfoJudgeService() {
        return template -> true;
    }

    @Resource
    private ReqInfoInterceptor reqInfoInterceptor;


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(reqInfoInterceptor).excludePathPatterns(excludePathPatterns);
    }

    @Bean
    @ConditionalOnProperty(name = "toolkit.pangolin.feign.logEnabled", havingValue = "true", matchIfMissing = true)
    public feign.Logger logger() {
        return new FeignLogger(maxLength);
    }

    @Bean
    @ConditionalOnProperty(name = "za.mt.feign.aroundLog.enable", havingValue = "true", matchIfMissing = true)
    public feign.Logger.Level feignLoggerLevel() {
        return feign.Logger.Level.FULL;
    }
}
