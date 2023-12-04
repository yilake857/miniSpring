package org.github.springframework.context.event;

import org.github.springframework.context.ApplicationContext;
import org.github.springframework.context.ApplicationEvent;

/**
 * @author zhaoyu
 * Created on 2023-12-04
 */
public abstract class ApplicationContextEvent extends ApplicationEvent {

    public ApplicationContextEvent(Object source) {
        super(source);
    }

    public final ApplicationContext getApplicationContext() {
        return (ApplicationContext) getSource();
    }
}
