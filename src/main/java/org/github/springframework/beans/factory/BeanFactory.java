package org.github.springframework.beans.factory;

import java.util.HashMap;
import java.util.Map;

import org.github.springframework.beans.BeansException;

/**
 * bean容器
 * @author zhaoyu
 * Created on 2023-11-07
 */
public interface BeanFactory {
    /**
     * 获取bean
     *
     * @param name
     * @return
     * @throws BeansException bean不存在时
     */
    Object getBean(String name) throws BeansException;


}
