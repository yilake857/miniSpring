package org.springframework.test.common;

import org.github.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * @author zhaoyu
 * @date 2024/1/27 21:30
 */
public class WorldServiceAfterReturningAdvice implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object result, Method method, Object[] args, Object target) {
        System.out.println("afterReturningAdvice: do something after the earth explodes");
    }
}
