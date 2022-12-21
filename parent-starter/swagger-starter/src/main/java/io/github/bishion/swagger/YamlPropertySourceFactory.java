package io.github.bishion.swagger;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertySourceFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * @author: guofangbi
 * @since 2022/7/2-19:27
 * @version: 1.0.0
 */
public class YamlPropertySourceFactory implements PropertySourceFactory {
    @Override
    public PropertySource<?> createPropertySource(String s, EncodedResource encodedResource) throws IOException {
        Properties properties = loadYaml2Properties(encodedResource);
        String sourceName = s != null ? s : encodedResource.getResource().getFilename();
        return new PropertiesPropertySource(sourceName, properties);
    }

    private Properties loadYaml2Properties(EncodedResource encodedResource) throws FileNotFoundException {
        try {
            YamlPropertiesFactoryBean factoryBean = new YamlPropertiesFactoryBean();

            factoryBean.setResources(encodedResource.getResource());
            factoryBean.afterPropertiesSet();
            return factoryBean.getObject();
        } catch (IllegalStateException e) {
            Throwable throwable = e.getCause();
            if (throwable instanceof FileNotFoundException) {
                throw ((FileNotFoundException) throwable);
            }
            throw e;
        }
    }
}
