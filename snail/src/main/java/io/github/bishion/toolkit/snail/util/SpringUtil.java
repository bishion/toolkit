package io.github.bishion.toolkit.snail.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author: guofangbi
 * @since: 2022/6/5-12:05
 * @version: 1.0.0
 */
public class SpringUtil implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringUtil.applicationContext = applicationContext;

    }

    public static <T> T getBean(String beanName, Class<T> clazz) {
        return (T) applicationContext.getBean(beanName);
    }

    public static Object getBean(String beanName) {
        return applicationContext.getBean(beanName);
    }

    public static <T> T getBean(Class<T> clazz) {
        return applicationContext.getBean(clazz);
    }

    public static <T> Map<String, T> getBeanMap(Class<T> clazz) {
        return applicationContext.getBeansOfType(clazz);
    }

    public static <T> List<T> getBeanList(Class<T> clazz) {
        return new ArrayList<>(getBeanMap(clazz).values());
    }
}
