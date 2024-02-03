package org.github.springframework.context.support;

import org.github.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.github.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @author zhaoyu
 * Created on 2023-11-23
 */
public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext{

    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) {
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory, this);
        String[] configLocations = getConfigLocations();
        if (configLocations != null) {
            beanDefinitionReader.loadBeanDefinitions(configLocations);
        }
    }

    protected abstract String[] getConfigLocations();

}
