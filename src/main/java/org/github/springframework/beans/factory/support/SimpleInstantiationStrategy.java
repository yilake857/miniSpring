package org.github.springframework.beans.factory.support;

import java.lang.reflect.Constructor;

import org.github.springframework.beans.BeansException;
import org.github.springframework.beans.factory.config.BeanDefinition;

/**
 * @author zhaoyu
 * Created on 2023-11-13
 */
public class SimpleInstantiationStrategy implements InstantiationStrategy{
    //TODO 是否可以传入有参构造函数实例化对象

    /**
     * 简单的bean实例化策略，根据bean的无参构造函数实例化对象
     *
     * @param beanDefinition
     * @return
     * @throws BeansException
     */
    @Override
    public Object instantiate(BeanDefinition beanDefinition) throws BeansException {
        Class beanClass = beanDefinition.getBeanClass();
        try {
            Constructor constructor = beanClass.getDeclaredConstructor();
            return constructor.newInstance();
        } catch (Exception e) {
            throw new BeansException("Failed to instantiate [" + beanClass.getName() + "]", e);
        }
    }
}
