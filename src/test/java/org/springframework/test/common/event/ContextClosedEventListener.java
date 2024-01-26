package org.springframework.test.common.event;

import org.github.springframework.context.ApplicationListener;
import org.github.springframework.context.event.ContextClosedEvent;

/**
 * @author zhaoyu
 * Created on 2023-12-04
 */
public class ContextClosedEventListener implements ApplicationListener<ContextClosedEvent> {
    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        System.out.println(this.getClass().getName());
    }
}
