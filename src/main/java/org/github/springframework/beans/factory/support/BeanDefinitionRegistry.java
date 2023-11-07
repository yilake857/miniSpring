package org.github.springframework.beans.factory.support;

import org.github.springframework.beans.factory.config.BeanDefinition;

/**
 * BeanDefinition注册表接口
 * @author zhaoyu
 * Created on 2023-11-07
 */
public interface BeanDefinitionRegistry {
    /**
     * 向注册表中注BeanDefinition
     *
     * @param beanName
     * @param beanDefinition
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
