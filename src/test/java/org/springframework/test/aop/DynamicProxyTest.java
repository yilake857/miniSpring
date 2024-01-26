package org.springframework.test.aop;

import org.github.springframework.aop.AdvisedSupport;
import org.github.springframework.aop.MethodMatcher;
import org.github.springframework.aop.TargetSource;
import org.github.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.github.springframework.aop.framework.JdkDynamicAopProxy;
import org.junit.Test;
import org.springframework.test.common.WorldServiceInterceptor;
import org.springframework.test.service.WorldService;
import org.springframework.test.service.WorldServiceImpl;

/**
 * @author zhaoyu
 * @date 2024/1/25 17:53
 */
public class DynamicProxyTest {
    @Test
    public void testJdkDynamicProxy() throws Exception{
        WorldService worldService = new WorldServiceImpl();
        AdvisedSupport advisedSupport = new AdvisedSupport();
        TargetSource targetSource = new TargetSource(worldService);
        WorldServiceInterceptor methodInterceptor = new WorldServiceInterceptor();
        MethodMatcher methodMatcher = new AspectJExpressionPointcut("execution(* org.springframework.test.service.WorldService.explode(..))").getMethodMatcher();
        advisedSupport.setTargetSource(targetSource);
        advisedSupport.setMethodInterceptor(methodInterceptor);
        advisedSupport.setMethodMatcher(methodMatcher);

        WorldService proxy = (WorldService) new JdkDynamicAopProxy(advisedSupport).getProxy();
        proxy.explode();
    }
}
