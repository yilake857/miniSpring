package org.github.springframework.aop.framework.adapter;

import org.aopalliance.intercept.MethodInvocation;
import org.aopalliance.intercept.MethodInterceptor;
import org.github.springframework.aop.MethodAfterReturningAdvice;


/**
 * @author zhaoyu
 * @date 2024/1/27 21:26
 */
public class MethodAfterReturningAdviceInterceptor implements MethodInterceptor {
    private MethodAfterReturningAdvice advice;

    public MethodAfterReturningAdviceInterceptor(MethodAfterReturningAdvice advice) {
        this.advice = advice;
    }



    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Object rusult = invocation.proceed();
        this.advice.afterReturning(rusult,invocation.getMethod(), invocation.getArguments(), invocation.getThis());
        return rusult;
    }
}
