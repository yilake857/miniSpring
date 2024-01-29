package org.github.springframework.beans.factory.config;

import org.github.springframework.beans.BeansException;

/**
 * @author zhaoyu
 * @date 2024/1/28 15:24
 */
public interface InstantiationAwareBeanPostProcessor extends BeanPostProcessor{
    /**
     * 在bean实例化之前执行
     *
     * @param beanClass
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException;

}
