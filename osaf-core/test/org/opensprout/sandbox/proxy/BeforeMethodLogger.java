package org.opensprout.sandbox.proxy;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class BeforeMethodLogger implements MethodBeforeAdvice {

	public void before(Method method, Object[] args, Object target)
			throws Throwable {
		System.out.println(method.getName() + " ½ÇÇà");
	}

}
