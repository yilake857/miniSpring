package org.springframework.test.ioc.common;

import org.github.springframework.beans.BeansException;
import org.github.springframework.beans.PropertyValue;
import org.github.springframework.beans.PropertyValues;
import org.github.springframework.beans.factory.ConfigurableListableBeanFactory;
import org.github.springframework.beans.factory.config.BeanDefinition;
import org.github.springframework.beans.factory.config.BeanFactoryPostProcessor;

/**
 * @author zhaoyu
 * Created on 2023-11-20
 */
public class CustomBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("CustomBeanFactoryPostProcessor#postProcessBeanFactory");
        BeanDefinition personBeanDefiniton = beanFactory.getBeanDefinition("person");
        PropertyValues propertyValues = personBeanDefiniton.getPropertyValues();
        //将person的name属性改为ivy
        propertyValues.addPropertyValue(new PropertyValue("name", "ivy"));
    }
}
