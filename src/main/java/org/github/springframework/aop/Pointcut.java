package org.github.springframework.aop;

/**
 * 切点抽象
 *
 * @author zhaoyu
 * @date 2024/1/24 18:56
 */
public interface Pointcut {
    ClassFilter getClassFilter();

    MethodMatcher getMethodMatcher();

}
