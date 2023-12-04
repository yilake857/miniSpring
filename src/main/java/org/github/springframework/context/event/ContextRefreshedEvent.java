package org.github.springframework.context.event;

/**
 * @author zhaoyu
 * Created on 2023-12-04
 */
public class ContextRefreshedEvent extends ApplicationContextEvent{

    public ContextRefreshedEvent(Object source) {
        super(source);
    }
}
