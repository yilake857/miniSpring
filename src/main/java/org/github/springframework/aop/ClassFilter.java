package org.github.springframework.aop;

/**
 * @author zhaoyu
 * @date 2024/1/24 18:54
 */
public interface ClassFilter {
    boolean matches(Class<?> clazz);
}
