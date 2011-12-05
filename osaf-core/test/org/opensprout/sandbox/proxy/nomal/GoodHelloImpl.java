package org.opensprout.sandbox.proxy.nomal;

import org.opensprout.sandbox.proxy.Hello;
import org.springframework.stereotype.Component;

@Component
public class GoodHelloImpl implements Hello {
	
	public String hi(){
		return "";
	}

}
