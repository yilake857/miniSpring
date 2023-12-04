package org.github.springframework.beans.factory;

/**
 * @author zhaoyu
 * Created on 2023-11-28
 */
public interface FactoryBean<T>{
    T getObject() throws Exception;

    boolean isSingleton();
}
