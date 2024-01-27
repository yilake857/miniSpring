package org.github.springframework.aop;

import org.aopalliance.intercept.MethodInterceptor;

import java.lang.reflect.Method;

/**
 * @author zhaoyu
 * @date 2024/1/27 17:53
 */
public interface MethodAfterAdvice extends AfterAdvice  {
    void after(Method method, Object[] args, Object target) throws Throwable;

}
