package org.springframework.test.ioc;


import org.github.springframework.beans.PropertyValue;
import org.github.springframework.beans.PropertyValues;
import org.github.springframework.beans.factory.config.BeanDefinition;
import org.github.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.junit.Test;
import org.springframework.test.ioc.bean.Person;
import static org.assertj.core.api.Assertions.assertThat;
public class PopulateBeanWithPropertyValuesTest {

	@Test
	public void testPopulateBeanWithPropertyValues() throws Exception {
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
		PropertyValues propertyValues = new PropertyValues();
		propertyValues.addPropertyValue(new PropertyValue("name", "derek"));
		propertyValues.addPropertyValue(new PropertyValue("age", 18));
		BeanDefinition beanDefinition = new BeanDefinition(Person.class, propertyValues);
		beanFactory.registerBeanDefinition("person", beanDefinition);

		Person person = (Person) beanFactory.getBean("person");
		System.out.println(person);
		assertThat(person.getName()).isEqualTo("derek");
		assertThat(person.getAge()).isEqualTo(18);
	}
}