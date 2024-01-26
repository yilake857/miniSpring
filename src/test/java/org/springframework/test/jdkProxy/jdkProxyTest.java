package org.springframework.test.jdkProxy;

import org.junit.Test;

import java.lang.reflect.Proxy;

/**
 * @author zhaoyu
 * @date 2024/1/25 19:27
 */
public class jdkProxyTest {
    @Test
    public void UserproxyTest(){
        UserService userService = new UserServiceImpl();
        UserProxy userProxy = new UserProxy(userService);
        UserService service = (UserService)Proxy.newProxyInstance(userService.getClass().getClassLoader(), userService.getClass().getInterfaces(), userProxy);
        service.addUser();
    }
}
