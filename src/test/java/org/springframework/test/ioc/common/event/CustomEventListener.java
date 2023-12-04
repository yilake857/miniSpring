package org.springframework.test.ioc.common.event;

import org.github.springframework.context.ApplicationListener;

/**
 * @author zhaoyu
 * Created on 2023-12-04
 */
public class CustomEventListener implements ApplicationListener<CustomEvent> {

    @Override
    public void onApplicationEvent(CustomEvent event) {
        System.out.println(this.getClass().getName());
    }
}
