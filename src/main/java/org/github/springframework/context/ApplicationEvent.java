package org.github.springframework.context;

import java.util.EventObject;

/**
 * @author zhaoyu
 * Created on 2023-12-04
 */
public abstract class ApplicationEvent extends EventObject {

    public ApplicationEvent(Object source) {
        super(source);
    }
}
