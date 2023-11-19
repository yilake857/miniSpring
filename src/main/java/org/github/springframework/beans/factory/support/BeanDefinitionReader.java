package org.github.springframework.beans.factory.support;

import org.github.springframework.beans.BeansException;
import org.github.springframework.core.io.Resource;
import org.github.springframework.core.io.ResourceLoader;

/**
 * 读取bean定义信息即BeanDefinition的接口
 *
 * @author zhaoyu
 * Created on 2023-11-19
 */
public interface BeanDefinitionReader {
    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();

    void loadBeanDefinitions(Resource resource) throws BeansException;

    void loadBeanDefinitions(String location) throws BeansException;

    void loadBeanDefinitions(String[] locations) throws BeansException;
}
