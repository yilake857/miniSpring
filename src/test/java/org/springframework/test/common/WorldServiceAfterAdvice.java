package org.springframework.test.common;

import org.github.springframework.aop.MethodAfterAdvice;

import java.lang.reflect.Method;

/**
 * @author zhaoyu
 * @date 2024/1/27 18:03
 */
public class WorldServiceAfterAdvice implements MethodAfterAdvice {


    @Override
    public void after(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("AfterAdvice: do something after the earth explodes");

    }
}
