package org.opensprout.sandbox;

import org.junit.Test;
import org.mvel.MVEL;

public class MVELTest {
	@Test
	public void mvel() {
		E e = new E();
		e.setName("Toby");
		F f = new F();
		f.setName("Mich");
		
		e.setF(f);
		System.out.println(MVEL.eval("f.name", e));
	}
}

class E {
	String name;
	F f;

	public F getF() {
		return f;
	}

	public void setF(F f) {
		this.f = f;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}

class F {
	String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
