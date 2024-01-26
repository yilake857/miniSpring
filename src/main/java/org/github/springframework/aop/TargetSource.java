package org.github.springframework.aop;

/**
 * 被代理的目标对象
 *
 * @author zhaoyu
 * @date 2024/1/25 17:31
 */
public class TargetSource {
    private final Object target;

    public TargetSource(Object target) {
        this.target = target;
    }

    public Class<?>[] getTargetClass() {
        return this.target.getClass().getInterfaces();
    }

    public Object getTarget() {
        return this.target;
    }
}
