package org.github.springframework.beans.factory.config;

/**
 * 单例注册表
 * @author zhaoyu
 * Created on 2023-11-07
 */
public interface SingletonBeanRegistry {
    Object getSingleton(String beanName);
}
