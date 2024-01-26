package org.springframework.test.aop;

import org.github.springframework.aop.AdvisedSupport;
import org.github.springframework.aop.MethodMatcher;
import org.github.springframework.aop.TargetSource;
import org.github.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.github.springframework.aop.framework.CglibAopProxy;
import org.github.springframework.aop.framework.JdkDynamicAopProxy;
import org.github.springframework.aop.framework.ProxyFactory;
import org.junit.Before;
import org.junit.Test;
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
}
