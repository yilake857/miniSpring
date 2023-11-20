package org.github.springframework.beans.factory.config;

import org.github.springframework.beans.factory.BeanFactory;

/**
 * @author zhaoyu
 * Created on 2023-11-20
 */
public interface ConfigurableBeanFactory  extends BeanFactory, SingletonBeanRegistry{
    /**
     * @param beanPostProcessor
     */
    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);
}
