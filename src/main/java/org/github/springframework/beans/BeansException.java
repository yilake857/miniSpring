package org.github.springframework.beans;

/**
 * @author zhaoyu
 * Created on 2023-11-07
 */
public class BeansException extends RuntimeException {
    public BeansException(String msg) {
        super(msg);
    }

    public BeansException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
