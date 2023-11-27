package org.springframework.test.ioc;

import org.github.springframework.context.support.ClassPathXmlApplicationContext;
import org.junit.Test;

/**
 * @author zhaoyu
 * Created on 2023-11-27
 */
public class InitAndDestoryMethodTest {
    @Test
    public void testInitAndDestroyMethod() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:init-and-destroy-method.xml");
        applicationContext.registerShutdownHook();  //或者手动关闭 applicationContext.close();
    }
}
