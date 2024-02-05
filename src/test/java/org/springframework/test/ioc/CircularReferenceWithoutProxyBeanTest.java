package org.springframework.test.ioc;

import org.github.springframework.context.support.ClassPathXmlApplicationContext;
import org.junit.Test;
import org.springframework.test.bean.A;
import org.springframework.test.bean.B;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * @author zhaoyu
 * @date 2024/2/5 19:13
 */
public class CircularReferenceWithoutProxyBeanTest {
    @Test
    public void testCircularReference() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:circular-reference-without-proxy-bean.xml");
        A a = applicationContext.getBean("a", A.class);
        B b = applicationContext.getBean("b", B.class);
        assertThat(a.getB() == b).isTrue();
    }
}
