package org.github.springframework.aop.aspectj;

import org.aopalliance.aop.Advice;
import org.github.springframework.aop.Pointcut;
import org.github.springframework.aop.PointcutAdvisor;

/**
 * @author zhaoyu
 * @date 2024/1/27 21:59
 */
public class AspectJExpressionPointcutAdvisor implements PointcutAdvisor {
    private AspectJExpressionPointcut pointcut;

    private Advice advice;

    private String expression;

    public void setExpression(String expression) {
        this.expression = expression;
        pointcut = new AspectJExpressionPointcut(expression);
    }


    @Override
    public Advice getAdvice() {
        return advice;
    }

    @Override
    public Pointcut getPointcut() {
        return pointcut;
    }

    public void setAdvice(Advice advice) {
        this.advice = advice;
    }
}
