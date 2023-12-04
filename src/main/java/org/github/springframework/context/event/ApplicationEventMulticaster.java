package org.github.springframework.context.event;

import org.github.springframework.context.ApplicationEvent;
import org.github.springframework.context.ApplicationListener;

/**
 * @author zhaoyu
 * Created on 2023-12-04
 */
public interface ApplicationEventMulticaster {

    void addApplicationListener(ApplicationListener<?> listener);

    void removeApplicationListener(ApplicationListener<?> listener);

    void multicastEvent(ApplicationEvent event);
}
