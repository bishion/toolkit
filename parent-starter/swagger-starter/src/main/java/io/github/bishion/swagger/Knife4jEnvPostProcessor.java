package io.github.bishion.swagger;

import io.github.bishion.common.util.EnvUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertiesPropertySource;

import java.util.Properties;

/**
 * @author: guofangbi
 * @since 2022/7/3-7:45
 * @version: 1.0.0
 */
public class Knife4jEnvPostProcessor implements EnvironmentPostProcessor {
    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        Properties properties = new Properties();
        properties.put("knife4j.enable", true);
        properties.put("knife4j.production", EnvUtil.ENV_IS_PRD);

        environment.getPropertySources().addFirst(new PropertiesPropertySource("swaggerConfig", properties));
    }

}
