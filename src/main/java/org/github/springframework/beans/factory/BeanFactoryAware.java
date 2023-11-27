package org.github.springframework.beans.factory;

import org.github.springframework.beans.BeansException;

/**
 * 实现该接口，能感知所属BeanFactory
 *
 * @author zhaoyu
 * Created on 2023-11-27
 */
public interface BeanFactoryAware extends Aware{
    void setBeanFactory(BeanFactory beanFactory) throws BeansException;

}
