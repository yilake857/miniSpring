package org.springframework.beans.factory;

import static org.assertj.core.api.Assertions.assertThat;

import org.github.springframework.beans.factory.config.BeanDefinition;
import org.github.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.junit.Test;

/**
 * @author zhaoyu
 * Created on 2023-11-07
 */
public class BeanFactoryTest {
    @Test
    public void testGetBean() throws Exception {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        BeanDefinition beanDefinition = new BeanDefinition(HelloService.class);
        beanFactory.registerBeanDefinition("helloService", beanDefinition);

        HelloService helloService = (HelloService) beanFactory.getBean("helloService");
        helloService.sayHello();
    }


}
