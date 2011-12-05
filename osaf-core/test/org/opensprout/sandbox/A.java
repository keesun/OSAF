package org.opensprout.sandbox;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

public class A {
	public void a() {
		Criteria c = null;
		c.add(Restrictions.eq("abcd", "a"));
	}
}
