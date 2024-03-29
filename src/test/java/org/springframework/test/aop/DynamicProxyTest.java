package org.springframework.test.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.github.springframework.aop.AdvisedSupport;
import org.github.springframework.aop.ClassFilter;
import org.github.springframework.aop.MethodMatcher;
import org.github.springframework.aop.TargetSource;
import org.github.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.github.springframework.aop.aspectj.AspectJExpressionPointcutAdvisor;
import org.github.springframework.aop.framework.CglibAopProxy;
import org.github.springframework.aop.framework.JdkDynamicAopProxy;
import org.github.springframework.aop.framework.ProxyFactory;
import org.github.springframework.aop.framework.adapter.AfterReturningAdviceInterceptor;
import org.github.springframework.aop.framework.adapter.MethodAfterAdviceInterceptor;
import org.github.springframework.aop.framework.adapter.MethodBeforeAdviceInterceptor;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.common.WorldServiceAfterAdvice;
import org.springframework.test.common.WorldServiceAfterReturningAdvice;
import org.springframework.test.common.WorldServiceBeforeAdvice;
import org.springframework.test.common.WorldServiceInterceptor;
import org.springframework.test.service.WorldService;
import org.springframework.test.service.WorldServiceImpl;

/**
 * @author zhaoyu
 * @date 2024/1/25 17:53
 */
public class DynamicProxyTest {
    private AdvisedSupport advisedSupport;

    @Before
    public void setup(){
        WorldServiceImpl worldService = new WorldServiceImpl();

        TargetSource targetSource = new TargetSource(worldService);
        advisedSupport = new AdvisedSupport();
        WorldServiceInterceptor worldServiceInterceptor = new WorldServiceInterceptor();
        MethodMatcher methodMatcher = new AspectJExpressionPointcut("execution(* org.springframework.test.service.WorldService.explode(..))").getMethodMatcher();
        advisedSupport.setMethodInterceptor(worldServiceInterceptor);
        advisedSupport.setMethodMatcher(methodMatcher);
        advisedSupport.setTargetSource(targetSource);
    }

    @Test
    public void testJdkDynamicProxy() throws Exception{
        WorldService proxy = (WorldService)new JdkDynamicAopProxy(advisedSupport).getProxy();
        proxy.explode();
    }

    @Test
    public void testCglibDynamicProxy() throws Exception{
        /**
         *特别说明
         * --add-opens java.base/java.lang=ALL-UNNAMED
         */
        WorldService proxy = (WorldService)new CglibAopProxy(advisedSupport).getProxy();
        proxy.explode();
    }

    @Test
    public void testProxyFactory() throws Exception {
        // 使用JDK动态代理
        advisedSupport.setProxyTargetClass(false);
        WorldService proxy = (WorldService) new ProxyFactory(advisedSupport).getProxy();
        proxy.explode();

        // 使用CGLIB动态代理
        advisedSupport.setProxyTargetClass(true);
        proxy = (WorldService) new ProxyFactory(advisedSupport).getProxy();
        proxy.explode();
    }

    @Test
    public void testBeforeAdvice() throws Exception {
        //设置BeforeAdvice
        WorldServiceBeforeAdvice beforeAdvice = new WorldServiceBeforeAdvice();
        MethodBeforeAdviceInterceptor methodInterceptor = new MethodBeforeAdviceInterceptor(beforeAdvice);
        advisedSupport.setMethodInterceptor(methodInterceptor);

        WorldService proxy = (WorldService) new ProxyFactory(advisedSupport).getProxy();
        proxy.explode();
    }

    @Test
    public void testAfterAdvice() throws Exception {
        //设置AfterAdvice
        WorldServiceAfterAdvice afterAdvice = new WorldServiceAfterAdvice();
        MethodAfterAdviceInterceptor methodInterceptor = new MethodAfterAdviceInterceptor(afterAdvice);
        advisedSupport.setMethodInterceptor(methodInterceptor);

        WorldService proxy = (WorldService) new ProxyFactory(advisedSupport).getProxy();
        proxy.explode();
    }
    @Test
    public void testAfterReturningAdvice() throws Exception {
        //设置AfterAdvice
        WorldServiceAfterReturningAdvice afterAdvice = new WorldServiceAfterReturningAdvice();
        AfterReturningAdviceInterceptor methodInterceptor = new AfterReturningAdviceInterceptor(afterAdvice);
        advisedSupport.setMethodInterceptor(methodInterceptor);

        WorldService proxy = (WorldService) new ProxyFactory(advisedSupport).getProxy();
        proxy.explode();
    }

    @Test
    public void testAdvisor() throws Exception{
        WorldService worldService = new WorldServiceImpl();

        String expression = "execution(* org.springframework.test.service.WorldService.explode(..))";
        AspectJExpressionPointcutAdvisor advisor = new AspectJExpressionPointcutAdvisor();
        advisor.setExpression(expression);
        MethodAfterAdviceInterceptor adviceInterceptor = new MethodAfterAdviceInterceptor(new WorldServiceAfterAdvice());
        advisor.setAdvice(adviceInterceptor);


        ClassFilter classFilter = advisor.getPointcut().getClassFilter();
        if (classFilter.matches(worldService.getClass())){
            AdvisedSupport advisedSupport = new AdvisedSupport();

            TargetSource targetSource = new TargetSource(worldService);
            advisedSupport.setTargetSource(targetSource);
            advisedSupport.setMethodInterceptor((MethodInterceptor) advisor.getAdvice());
            advisedSupport.setMethodMatcher(advisor.getPointcut().getMethodMatcher());
//			advisedSupport.setProxyTargetClass(true);   //JDK or CGLIB

            WorldService proxy = (WorldService) new ProxyFactory(advisedSupport).getProxy();
            proxy.explode();
        }
    }


}
