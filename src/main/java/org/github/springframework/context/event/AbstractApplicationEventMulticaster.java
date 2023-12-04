package org.github.springframework.context.event;

import java.util.HashSet;
import java.util.Set;

import org.github.springframework.beans.BeansException;
import org.github.springframework.beans.factory.BeanFactory;
import org.github.springframework.beans.factory.BeanFactoryAware;
import org.github.springframework.context.ApplicationEvent;
import org.github.springframework.context.ApplicationListener;

/**
 * @author zhaoyu
 * Created on 2023-12-04
 */
public abstract class AbstractApplicationEventMulticaster implements ApplicationEventMulticaster, BeanFactoryAware {
    public final Set<ApplicationListener<ApplicationEvent>> applicationListeners = new HashSet<>();

    private BeanFactory beanFactory;

    @Override
    public void addApplicationListener(ApplicationListener<?> listener) {
        applicationListeners.add((ApplicationListener<ApplicationEvent>) listener);
    }

    @Override
    public void removeApplicationListener(ApplicationListener<?> listener) {
        applicationListeners.remove(listener);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }
}
