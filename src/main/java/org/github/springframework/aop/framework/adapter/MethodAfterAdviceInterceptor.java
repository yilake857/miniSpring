package org.github.springframework.aop.framework.adapter;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.github.springframework.aop.MethodAfterAdvice;

/**
 * @author zhaoyu
 * @date 2024/1/27 17:58
 */
public class MethodAfterAdviceInterceptor implements MethodInterceptor {
    private MethodAfterAdvice advice;

    public MethodAfterAdviceInterceptor(MethodAfterAdvice advice) {
        this.advice = advice;
    }

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        //在执行方法之后，再执行after advice操作
        try{
            return invocation.proceed();
        }finally {
            this.advice.after(invocation.getMethod(), invocation.getArguments(), invocation.getThis());
        }
    }
}
