package org.springframework.test.ioc;

import org.github.springframework.context.support.ClassPathXmlApplicationContext;
import org.junit.Test;
import org.springframework.test.bean.Car;

import static org.assertj.core.api.Assertions.assertThat;

public class ValueAnnotationTest {

	@Test
	public void testValueAnnotation() throws Exception {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:value-annotation.xml");

		Car car = applicationContext.getBean("car", Car.class);
		assertThat(car.getBrand()).isEqualTo("lamborghini");
	}
}