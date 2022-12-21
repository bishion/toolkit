package io.github.bishion.common;

import io.github.bishion.common.service.BaseReqService;
import io.github.bishion.common.service.DefaultBaseReqService;
import io.github.bishion.common.util.SpringUtil;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

/**
 * @author: guofangbi
 * @date: 2022/6/5-12:02
 * @version: 1.0.0
 */
@Import(SpringUtil.class)
public class CommConfiguration {
    @Bean
    @ConditionalOnMissingBean(BaseReqService.class)
    public BaseReqService baseReqService() {
        return new DefaultBaseReqService();
    }
}
