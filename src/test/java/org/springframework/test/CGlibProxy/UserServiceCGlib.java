package org.springframework.test.CGlibProxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author zhaoyu
 * @date 2024/1/26 16:59
 */
public class UserServiceCGlib implements MethodInterceptor {
    private Object target;

    public UserServiceCGlib(Object target) {
        this.target = target;
    }

    public Object getProxyInstance(){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setInterfaces(target.getClass().getInterfaces());
        enhancer.setCallback(this);
        return enhancer.create();
    }


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("增强开始~~~");
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println("增强结束~~~");
        return result;
    }


}
