package org.springframework.test.CGlibProxy;

import org.junit.Test;
import org.springframework.test.jdkProxy.UserServiceImpl;

/**
 * @author zhaoyu
 * @date 2024/1/26 17:06
 */
public class CGlibTest {
    @Test
    public void Test(){
        UserServiceCGlib userServiceCGlib = new UserServiceCGlib(new UserServiceImpl());
        UserServiceImpl userService  = (UserServiceImpl)userServiceCGlib.getProxyInstance();
        userService.addUser();
    }
}
