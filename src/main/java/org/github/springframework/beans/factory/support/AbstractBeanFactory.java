package org.github.springframework.beans.factory.support;

import java.util.ArrayList;
import java.util.List;

import org.github.springframework.beans.BeansException;
import org.github.springframework.beans.factory.BeanFactory;
import org.github.springframework.beans.factory.config.BeanDefinition;
import org.github.springframework.beans.factory.config.BeanPostProcessor;
import org.github.springframework.beans.factory.config.ConfigurableBeanFactory;

/**
 * @author zhaoyu
 * Created on 2023-11-07
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements ConfigurableBeanFactory {

    private final List<BeanPostProcessor> beanPostProcessors = new ArrayList<>();


    @Override
    public Object getBean(String name) throws BeansException {
        Object bean = getSingleton(name);
        if (bean != null) {
            return bean;
        }

        BeanDefinition beanDefinition = getBeanDefinition(name);
        return createBean(name, beanDefinition);
    }

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException;

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    @Override
    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) {
        //有则覆盖
        this.beanPostProcessors.remove(beanPostProcessor);
        this.beanPostProcessors.add(beanPostProcessor);
    }

    public List<BeanPostProcessor> getBeanPostProcessors() {
        return this.beanPostProcessors;
    }
}
