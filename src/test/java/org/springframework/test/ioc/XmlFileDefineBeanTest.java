package org.springframework.test.ioc;

import static org.assertj.core.api.Assertions.assertThat;

import org.github.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.github.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.junit.Test;
import org.springframework.test.bean.Car;
import org.springframework.test.bean.Person;

/**
 * @author zhaoyu
 * Created on 2023-11-19
 */
public class XmlFileDefineBeanTest {

	@Test
	public void testXmlFile() throws Exception {
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
		beanDefinitionReader.loadBeanDefinitions("classpath:spring.xml");

		Person person = (Person) beanFactory.getBean("person");
		System.out.println(person);
		assertThat(person.getName()).isEqualTo("derek");
		assertThat(person.getCar().getBrand()).isEqualTo("porsche");

		Car car = (Car) beanFactory.getBean("car");
		System.out.println(car);
		assertThat(car.getBrand()).isEqualTo("porsche");
	}
}
