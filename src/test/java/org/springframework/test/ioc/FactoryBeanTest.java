package org.springframework.test.ioc;

import static org.assertj.core.api.Assertions.assertThat;

import org.github.springframework.context.support.ClassPathXmlApplicationContext;
import org.junit.Test;
import org.springframework.test.ioc.bean.Car;

/**
 * @author zhaoyu
 * Created on 2023-12-04
 */
public class FactoryBeanTest {

    @Test
    public void testFactoryBean(){
        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("factory-bean.xml");
        Car car = applicationContext.getBean("car", Car.class);
        assertThat(car.getBrand()).isEqualTo("porsche");

    }
}
