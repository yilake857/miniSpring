package org.github.springframework.context;

/**
 * 事件发布者接口
 *
 * @author zhaoyu
 * Created on 2023-12-04
 */
public interface ApplicationEventPublisher {

    /**
     * 发布事件
     *
     * @param event
     */
    void publishEvent(ApplicationEvent event);
}
