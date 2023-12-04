package org.springframework.test.ioc.common.event;

import org.github.springframework.context.ApplicationContext;
import org.github.springframework.context.event.ApplicationContextEvent;

/**
 * @author zhaoyu
 * Created on 2023-12-04
 */
public class CustomEvent extends ApplicationContextEvent {
    public CustomEvent(ApplicationContext source) {
        super(source);
    }
}
