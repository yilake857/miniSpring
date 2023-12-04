package org.github.springframework.context.event;

import org.github.springframework.context.ApplicationEvent;

/**
 * @author zhaoyu
 * Created on 2023-12-04
 */
public class ContextClosedEvent extends ApplicationContextEvent {

    public ContextClosedEvent(Object source) {
        super(source);
    }
}
