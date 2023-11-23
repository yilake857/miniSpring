package org.github.springframework.context;

import org.github.springframework.beans.factory.HierarchicalBeanFactory;
import org.github.springframework.beans.factory.ListableBeanFactory;
import org.github.springframework.core.io.ResourceLoader;

/**
 * 应用上下文
 *
 * @author zhaoyu
 * Created on 2023-11-23
 */
public interface ApplicationContext extends ListableBeanFactory, HierarchicalBeanFactory, ResourceLoader {
}
