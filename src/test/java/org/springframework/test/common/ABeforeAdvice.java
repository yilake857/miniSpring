package org.springframework.test.common;

import org.github.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class ABeforeAdvice implements MethodBeforeAdvice {
	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {

	}
}