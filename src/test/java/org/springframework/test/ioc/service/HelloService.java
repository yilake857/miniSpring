package org.springframework.test.ioc.service;

import org.github.springframework.beans.BeansException;
import org.github.springframework.beans.factory.BeanFactory;
import org.github.springframework.beans.factory.BeanFactoryAware;
import org.github.springframework.context.ApplicationContext;
import org.github.springframework.context.ApplicationContextAware;

/**
 * @author zhaoyu
 * Created on 2023-11-07
 */
public class HelloService implements ApplicationContextAware, BeanFactoryAware {

    private ApplicationContext applicationContext;

    private BeanFactory beanFactory;

    public String sayHello() {
        System.out.println("hello");
        return "hello";
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }

}
