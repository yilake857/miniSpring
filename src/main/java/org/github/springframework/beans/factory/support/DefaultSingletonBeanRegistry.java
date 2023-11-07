package org.github.springframework.beans.factory.support;

import java.util.HashMap;
import java.util.Map;

import org.github.springframework.beans.factory.config.SingletonBeanRegistry;

/**
 * @author zhaoyu
 * Created on 2023-11-07
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {
    private Map<String, Object> singletonObjects = new HashMap<>();

    @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }

    protected void addSingleton(String beanName, Object singletonObject) {
        singletonObjects.put(beanName, singletonObject);
    }
}
