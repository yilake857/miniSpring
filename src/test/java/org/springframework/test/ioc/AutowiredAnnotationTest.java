package org.springframework.test.ioc;

import org.github.springframework.context.support.ClassPathXmlApplicationContext;
import org.junit.Test;
import org.springframework.test.bean.Person;

import static org.assertj.core.api.Assertions.assertThat;

public class AutowiredAnnotationTest {

	@Test
	public void testAutowiredAnnotation() throws Exception {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:autowired-annotation.xml");

		Person person = applicationContext.getBean(Person.class);
		assertThat(person.getCar()).isNotNull();
	}
}