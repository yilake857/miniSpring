package org.springframework.test.ioc;

import static org.assertj.core.api.Assertions.assertThat;

import org.github.springframework.beans.PropertyValue;
import org.github.springframework.beans.PropertyValues;
import org.github.springframework.beans.factory.config.BeanDefinition;
import org.github.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.junit.Test;

/**
 * @author zhaoyu
 * Created on 2023-11-07
 */
public class BeanDefinitionAndBeanDefinitionRegistryTest {
    @Test
    public void testGetBean() throws Exception {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("foo", "hello"));
        propertyValues.addPropertyValue(new PropertyValue("bar", "world"));
        BeanDefinition beanDefinition = new BeanDefinition(HelloService.class, propertyValues);
        beanFactory.registerBeanDefinition("helloService", beanDefinition);

        HelloService helloService = (HelloService) beanFactory.getBean("helloService");
        System.out.println(helloService.toString());
        assertThat(helloService.getFoo()).isEqualTo("hello");
        assertThat(helloService.getBar()).isEqualTo("world");
    }


}
