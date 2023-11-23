package org.github.springframework.context;

import org.github.springframework.beans.BeansException;

/**
 * @author zhaoyu
 * Created on 2023-11-23
 */
public interface ConfigurableApplicationContext extends ApplicationContext{
    /**
     * 刷新容器
     *
     * @throws BeansException
     */
    void refresh() throws BeansException;
}
