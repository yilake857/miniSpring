package org.github.springframework.aop;

import java.lang.reflect.Method;

/**
 * @author zhaoyu
 * @date 2024/1/27 21:23
 */
public interface AfterReturningAdvice extends AfterAdvice {
    void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable;

}
