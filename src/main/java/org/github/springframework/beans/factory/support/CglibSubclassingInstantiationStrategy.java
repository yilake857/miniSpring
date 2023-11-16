package org.github.springframework.beans.factory.support;

import org.github.springframework.beans.BeansException;
import org.github.springframework.beans.factory.config.BeanDefinition;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

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
        //TODO 感兴趣的小伙伴可以实现下
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(beanDefinition.getBeanClass());
        enhancer.setCallback((MethodInterceptor) (obj, method, argsTemp, proxy) -> proxy.invokeSuper(obj,argsTemp));
        return enhancer.create();
    }
}
