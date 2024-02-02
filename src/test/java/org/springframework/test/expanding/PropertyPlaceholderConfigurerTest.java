package org.springframework.test.expanding;

import org.github.springframework.context.support.ClassPathXmlApplicationContext;
import org.junit.Test;
import org.springframework.test.bean.Car;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author zhaoyu
 * @date 2024/2/2 21:48
 */
public class PropertyPlaceholderConfigurerTest {
    @Test
    public void test() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:property-placeholder-configurer.xml");

        Car car = applicationContext.getBean("car", Car.class);
        assertThat(car.getBrand()).isEqualTo("lamborghini");
    }
}
