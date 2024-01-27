package org.github.springframework.aop;
import java.lang.reflect.Method;
/**
 * @author zhaoyu
 * @date 2024/1/27 17:21
 */
public interface MethodBeforeAdvice extends BeforeAdvice{
    void before(Method method, Object[] args, Object target) throws Throwable;

}
