package org.github.springframework.aop.framework.adapter;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.github.springframework.aop.BeforeAdvice;
import org.github.springframework.aop.MethodBeforeAdvice;

/**
 * @author zhaoyu
 * @date 2024/1/27 17:22
 */
public class MethodBeforeAdviceInterceptor implements MethodInterceptor , BeforeAdvice {
    private MethodBeforeAdvice advice;

    public MethodBeforeAdviceInterceptor(MethodBeforeAdvice advice) {
        this.advice = advice;
    }

    public MethodBeforeAdviceInterceptor() {
    }

    public void setAdvice(MethodBeforeAdvice advice) {
        this.advice = advice;
    }

    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {
        //在执行被代理方法之前，先执行before advice操作
        this.advice.before(mi.getMethod(), mi.getArguments(), mi.getThis());
        return mi.proceed();
    }


}
