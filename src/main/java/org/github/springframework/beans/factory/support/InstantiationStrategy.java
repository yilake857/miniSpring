package org.github.springframework.beans.factory.support;

import org.github.springframework.beans.BeansException;
import org.github.springframework.beans.factory.config.BeanDefinition;

/**
 * Bean的实例化策略
 * @author zhaoyu
 * Created on 2023-11-13
 */
public interface InstantiationStrategy {
    Object instantiate(BeanDefinition beanDefinition) throws BeansException;
}
