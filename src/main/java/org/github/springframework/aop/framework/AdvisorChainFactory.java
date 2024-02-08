package org.github.springframework.aop.framework;

import org.github.springframework.aop.AdvisedSupport;

import java.lang.reflect.Method;
import java.util.List;

/**
 * @author zhaoyu
 * @date 2024/2/8 13:03
 */
public interface AdvisorChainFactory {
    List<Object> getInterceptorsAndDynamicInterceptionAdvice(AdvisedSupport config, Method method, Class<?> targetClass);

}
