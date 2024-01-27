package org.github.springframework.aop;

/**
 * @author zhaoyu
 * @date 2024/1/27 21:57
 */
public interface PointcutAdvisor extends Advisor{
    Pointcut getPointcut();

}
