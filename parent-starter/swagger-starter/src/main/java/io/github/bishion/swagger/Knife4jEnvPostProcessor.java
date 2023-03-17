package io.github.bishion.swagger;

import io.github.bishion.common.consts.BaseConst;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertiesPropertySource;

import java.util.Properties;

/**
 * @author: guofangbi
 * @version: 1.0.0
 * @since 2022/7/3-7:45
 */
@Order
public class Knife4jEnvPostProcessor implements EnvironmentPostProcessor {

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        Properties properties = new Properties();

        boolean swaggerEnabled = BaseConst.YES.equals(environment.getProperty("swagger.enabled"));

        properties.put("knife4j.enable", true);
        properties.put("knife4j.production", !swaggerEnabled);

        environment.getPropertySources().addFirst(new PropertiesPropertySource("swaggerConfig", properties));
    }

}
