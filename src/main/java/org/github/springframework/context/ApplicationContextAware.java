package org.github.springframework.context;

import org.github.springframework.beans.BeansException;
import org.github.springframework.beans.factory.Aware;

/**
 * 实现该接口，能感知所属ApplicationContext
 *
 * @author zhaoyu
 * Created on 2023-11-27
 */
public interface ApplicationContextAware extends Aware {
    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;

}
