package org.springframework.test.aop;

import org.github.springframework.aop.TargetSource;
import org.github.springframework.aop.aspectj.AspectJExpressionPointcutAdvisor;
import org.github.springframework.aop.framework.ProxyFactory;
import org.github.springframework.aop.framework.adapter.AfterReturningAdviceInterceptor;
import org.github.springframework.aop.framework.adapter.MethodBeforeAdviceInterceptor;
import org.junit.Test;
import org.springframework.test.common.WorldServiceAfterReturnAdvice;
import org.springframework.test.common.WorldServiceBeforeAdvice;
import org.springframework.test.service.WorldService;
import org.springframework.test.service.WorldServiceImpl;

public class ProxyFactoryTest {
    @Test
    public void testAdvisor() throws Exception {
        WorldService worldService = new WorldServiceImpl();

        //Advisor是Pointcut和Advice的组合
        String expression = "execution(* org.springframework.test.service.WorldService.explode(..))";
        AspectJExpressionPointcutAdvisor advisor = new AspectJExpressionPointcutAdvisor();
        advisor.setExpression(expression);
        MethodBeforeAdviceInterceptor methodInterceptor = new MethodBeforeAdviceInterceptor(new WorldServiceBeforeAdvice());
        advisor.setAdvice(methodInterceptor);
        AspectJExpressionPointcutAdvisor advisor1=new AspectJExpressionPointcutAdvisor();
        advisor1.setExpression(expression);
        AfterReturningAdviceInterceptor afterReturningAdviceInterceptor=new AfterReturningAdviceInterceptor(new WorldServiceAfterReturnAdvice());
        advisor1.setAdvice(afterReturningAdviceInterceptor);
            ProxyFactory factory = new ProxyFactory();
            TargetSource targetSource = new TargetSource(worldService);
            factory.setTargetSource(targetSource);
            factory.setProxyTargetClass(true);
            factory.addAdvisor(advisor);
            factory.addAdvisor(advisor1);
            WorldService proxy = (WorldService) factory.getProxy();
            proxy.explode();
    }
}