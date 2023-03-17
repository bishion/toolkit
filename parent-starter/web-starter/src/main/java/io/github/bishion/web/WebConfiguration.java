package io.github.bishion.web;

import io.github.bishion.web.advice.GlobalExceptionAdvice;
import io.github.bishion.web.advice.GlobalLogAdvice;
import io.github.bishion.web.advice.GlobalResponseAdvice;
import io.github.bishion.web.health.HealthController;
import io.github.bishion.web.monitor.RequestMonitorService;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import({GlobalExceptionAdvice.class, GlobalLogAdvice.class, GlobalResponseAdvice.class,
        HealthController.class})
@Configuration
public class WebConfiguration {
    @Bean
    @ConditionalOnMissingBean(RequestMonitorService.class)
    public RequestMonitorService requestMonitorService() {
        // 默认不打印请求日志监控
        return (v1, v2, v3, v4, v5) -> {
        };
    }

    @Value(("${toolkit.log.logAdviceExpression:@annotation(org.springframework.web.bind.annotation.RestController}"))
    private String logAdviceExpression;


    @Bean
    public DefaultPointcutAdvisor globalLogAdvice() {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression(logAdviceExpression);

        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor();
        advisor.setPointcut(pointcut);
        advisor.setAdvice(new GlobalLogAdvice());

        return advisor;
    }
}
