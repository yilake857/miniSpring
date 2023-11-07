package org.springframework.beans.factory;

import static org.assertj.core.api.Assertions.assertThat;

import org.github.springframework.beans.factory.BeanFactory;
import org.junit.Test;

/**
 * @author zhaoyu
 * Created on 2023-11-07
 */
public class BeanFactoryTest {
    @Test
    public void testGetBean() throws Exception {
        BeanFactory beanFactory = new BeanFactory();
        beanFactory.registerBean("helloService", new HelloService());
        HelloService helloService = (HelloService) beanFactory.getBean("helloService");
        helloService.sayHello();
    }

    public class HelloService {
        public String sayHello() {
            System.out.println("hello");
            return "hello";
        }
    }
}
