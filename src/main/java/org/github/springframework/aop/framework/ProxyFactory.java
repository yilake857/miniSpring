package org.github.springframework.aop.framework;

import org.github.springframework.aop.AdvisedSupport;

/**
 * @author zhaoyu
 * @date 2024/1/26 21:37
 */
public class ProxyFactory extends AdvisedSupport{

    public ProxyFactory() {
    }

    private AdvisedSupport advisedSupport;

    public ProxyFactory(AdvisedSupport advisedSupport) {
        this.advisedSupport = advisedSupport;
    }

    public Object getProxy(){
        return createAopProxy().getProxy();
    }

    private AopProxy createAopProxy(){
        if (this.isProxyTargetClass()||this.getTargetSource().getTargetClass().length==0) {
            return new CglibAopProxy(this);
        }
        return new JdkDynamicAopProxy(this);
    }
}
