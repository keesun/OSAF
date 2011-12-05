package org.opensprout.sandbox.proxy;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class FinalHelloAspect {

	@Before("execution(* org.opensprout.sandbox.proxy.withfinal.FinalHello.*(..))")
	public void withFinalAdvice() {
		System.out.println("before advice from FinalHelloAspect");
	}

}
