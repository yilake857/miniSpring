package org.github.springframework.aop;

import java.lang.reflect.Method;

/**
 * @author zhaoyu
 * @date 2024/1/27 21:23
 */
public interface MethodAfterReturningAdvice extends AfterReturningAdvice {
    Object afterReturning(Object result,Method method, Object[] args, Object target);
}
