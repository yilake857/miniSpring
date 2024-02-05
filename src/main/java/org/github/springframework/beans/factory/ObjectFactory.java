package org.github.springframework.beans.factory;

import org.github.springframework.beans.BeansException;

/**
 * @author zhaoyu
 * @date 2024/2/5 21:20
 */
public interface ObjectFactory<T> {
    T getObject() throws BeansException;
}
