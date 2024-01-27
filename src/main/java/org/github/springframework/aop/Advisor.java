package org.github.springframework.aop;

import org.aopalliance.aop.Advice;

/**
 * @author zhaoyu
 * @date 2024/1/27 21:56
 */
public interface Advisor {
    Advice getAdvice();
}
