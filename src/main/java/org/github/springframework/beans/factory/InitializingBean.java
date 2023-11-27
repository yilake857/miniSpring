package org.github.springframework.beans.factory;

/**
 * @author zhaoyu
 * Created on 2023-11-27
 */
public interface InitializingBean {
    void afterPropertiesSet() throws Exception;

}
