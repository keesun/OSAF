package org.opensprout.sandbox.proxy.withfinal;

import org.springframework.stereotype.Component;

@Component
public class FinalHello {
	
	public String hi() {
		return "hi";
	}
	
	public final void finalHi(){
		System.out.println("¾È³ç");
	}
	
}
