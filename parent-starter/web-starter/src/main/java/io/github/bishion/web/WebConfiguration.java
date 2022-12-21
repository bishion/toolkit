package io.github.bishion.web;

import io.github.bishion.web.advice.GlobalExceptionAdvice;
import io.github.bishion.web.advice.GlobalLogAdvice;
import io.github.bishion.web.advice.GlobalResponseAdvice;
import io.github.bishion.web.health.HealthController;
import io.github.bishion.web.monitor.RequestMonitorService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Import({GlobalExceptionAdvice.class, GlobalLogAdvice.class, GlobalResponseAdvice.class,
        HealthController.class})
@Configuration
public class WebConfiguration implements WebMvcConfigurer {
    @Bean
    @ConditionalOnMissingBean(RequestMonitorService.class)
    public RequestMonitorService requestMonitorService() {
        // 默认不打印请求日志监控
        return (v1, v2, v3, v4, v5) -> {
        };
    }
}
