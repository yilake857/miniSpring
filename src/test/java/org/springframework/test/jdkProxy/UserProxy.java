package org.springframework.test.jdkProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author zhaoyu
 * @date 2024/1/25 19:25
 */
public class UserProxy implements InvocationHandler {
    private Object tarject;

    public UserProxy(Object tarject) {
        this.tarject = tarject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("记录日志！");

        Object invoke = method.invoke(tarject, args);

        return invoke;
    }
}
