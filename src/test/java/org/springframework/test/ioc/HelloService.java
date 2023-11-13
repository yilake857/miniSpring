package org.springframework.test.ioc;

/**
 * @author zhaoyu
 * Created on 2023-11-07
 */
public class HelloService {

    public String sayHello() {
        System.out.println("hello");
        return "hello";
    }
}
