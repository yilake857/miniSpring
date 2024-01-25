package org.github.springframework.aop;

import java.lang.reflect.Method;

/**
 * @author zhaoyu
 * @date 2024/1/24 18:56
 */
public interface MethodMatcher {

    boolean matches(Method method, Class<?> targetClass);
}
