package org.github.springframework.context.annotation;

import cn.hutool.core.util.ClassUtil;
import org.github.springframework.beans.factory.config.BeanDefinition;
import org.github.springframework.stereotype.Component;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author zhaoyu
 * @date 2024/2/3 17:53
 */
public class ClassPathScanningCandidateComponentProvider {

    public Set<BeanDefinition> findCandidateComponents(String basePackage){
        Set<BeanDefinition> candidates = new LinkedHashSet<BeanDefinition>();
        // 扫描有org.springframework.stereotype.Component注解的类
        Set<Class<?>> classes = ClassUtil.scanPackageByAnnotation(basePackage, Component.class);
        for (Class<?> clazz : classes) {
            BeanDefinition beanDefinition = new BeanDefinition(clazz);
            candidates.add(beanDefinition);
        }
        return candidates;
    }
}
