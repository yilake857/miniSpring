package org.springframework.test.common.event;

import org.github.springframework.context.ApplicationListener;
import org.github.springframework.context.event.ContextRefreshedEvent;

/**
 * @author zhaoyu
 * Created on 2023-12-04
 */
public class ContextRefreshedEventListener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println(this.getClass().getName());
    }
}
