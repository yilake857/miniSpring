package org.springframework.test.ioc;

import org.github.springframework.beans.factory.config.BeanDefinition;
import org.github.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.junit.Test;
import org.springframework.test.service.HelloService;

public class BeanDefinitionAndBeanDefinitionRegistryTest {

	@Test
	public void testBeanFactory() throws Exception {
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
		BeanDefinition beanDefinition = new BeanDefinition(HelloService.class);
		beanFactory.registerBeanDefinition("helloService", beanDefinition);

		HelloService helloService = (HelloService) beanFactory.getBean("helloService");
		helloService.sayHello();
	}
}