package org.github.springframework.context;

import java.util.EventListener;

/**
 * @author zhaoyu
 * Created on 2023-12-04
 */
public interface ApplicationListener<E extends ApplicationEvent> extends EventListener {
    void onApplicationEvent(E event);

}
