package cn.bishion.toolkit.common;

import cn.bishion.toolkit.common.service.BaseReqService;
import cn.bishion.toolkit.common.service.DefaultBaseReqService;
import cn.bishion.toolkit.common.util.SpringUtil;
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
