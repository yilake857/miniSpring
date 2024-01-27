package org.springframework.test.common;

import org.github.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @author zhaoyu
 * @date 2024/1/27 17:27
 */
public class WorldServiceBeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("BeforeAdvice: do something before the earth explodes");
    }
}
