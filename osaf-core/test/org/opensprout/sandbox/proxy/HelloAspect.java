package org.opensprout.sandbox.proxy;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class HelloAspect {

	@Pointcut("execution(public * org.opensprout.sandbox.proxy.nomal.GoodHelloImpl.hi(..))")
	public void hiPointcut(){}
	
	@Before("hiPointcut()")
	public void beforeHiAdvice(){
		// do nothing but, this will be applied to pointcut.
	}
	
}
