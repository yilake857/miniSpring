package org.github.springframework.context.support;

import org.github.springframework.beans.BeansException;
import org.github.springframework.beans.factory.config.BeanPostProcessor;
import org.github.springframework.context.ApplicationContext;
import org.github.springframework.context.ApplicationContextAware;

/**
 * @author zhaoyu
 * Created on 2023-11-27
 */
public class ApplicationContextAwareProcessor implements BeanPostProcessor {

    private final ApplicationContext applicationContext;


    public ApplicationContextAwareProcessor(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof ApplicationContextAware) {
            ((ApplicationContextAware) bean).setApplicationContext(applicationContext);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
