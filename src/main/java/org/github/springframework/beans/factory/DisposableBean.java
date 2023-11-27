package org.github.springframework.beans.factory;

/**
 * @author zhaoyu
 * Created on 2023-11-27
 */
public interface DisposableBean {
    void destroy() throws Exception;
}
