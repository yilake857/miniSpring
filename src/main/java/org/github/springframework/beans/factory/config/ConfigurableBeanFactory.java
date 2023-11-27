package org.github.springframework.beans.factory.config;

import org.github.springframework.beans.factory.BeanFactory;
import org.github.springframework.beans.factory.HierarchicalBeanFactory;

/**
 * @author zhaoyu
 * Created on 2023-11-20
 */
public interface ConfigurableBeanFactory  extends HierarchicalBeanFactory, SingletonBeanRegistry{
    /**
     * @param beanPostProcessor
     */
    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);


    /**
     * 销毁单例bean
     */
    void destroySingletons();
}
