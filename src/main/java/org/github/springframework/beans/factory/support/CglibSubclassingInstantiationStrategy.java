package org.github.springframework.beans.factory.support;

import org.github.springframework.beans.BeansException;
import org.github.springframework.beans.factory.config.BeanDefinition;

/**
 * @author zhaoyu
 * Created on 2023-11-13
 */
public class CglibSubclassingInstantiationStrategy implements InstantiationStrategy{
    /**
     * 使用CGLIB动态生成子类
     *
     * @param beanDefinition
     * @return
     * @throws BeansException
     */
    @Override
    public Object instantiate(BeanDefinition beanDefinition) throws BeansException {
        Class beanClass = beanDefinition.getBeanClass();
        //TODO 感兴趣的小伙伴可以实现下
        throw new UnsupportedOperationException("CGLIB instantiation strategy is not supported");
    }
}
