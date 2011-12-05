/**
 * Copyright (c) 2008 OpenSprout Team.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 */
package org.opensprout.osaf.util;

import static org.junit.Assert.*;

import org.junit.Test;
import org.opensprout.osaf.exception.ReflectionException;
import org.opensprout.osaf.util.ReflectionUtils;

/**
 * @author Whiteship
 */
public class SimpleReflectionUtilsTest {

	public static class Foo {
		protected int i;
	}

	public static class SubFoo extends Foo {

	}

	public static class PrivateClass {
		private Foo foo = new SubFoo();
		private int bar;

		public Foo getFoo() {
			return foo;
		}

		public void setFoo(Foo foo) {
			this.foo = foo;
		}

		public int getBar() {
			return bar;
		}

		public void setBar(int bar) {
			this.bar = bar;
		}

	}

	@Test
	public void getField() {
		assertEquals("bar", ReflectionUtils.getField(PrivateClass.class,
				"bar").getName());
		assertEquals("foo", ReflectionUtils.getField(PrivateClass.class,
				"foo").getName());
		assertEquals("i", ReflectionUtils.getField(SubFoo.class,
				"i", true).getName());
	}

	@Test
	public void getValue() {
		PrivateClass pc = new PrivateClass();
		assertEquals(0, ReflectionUtils.getValue(PrivateClass.class, pc,
				"bar"));
		pc.setBar(1);
		assertEquals(1, ReflectionUtils.getValue(PrivateClass.class, pc,
				"bar"));
		SubFoo subFoo = new SubFoo();
		assertEquals(0, ReflectionUtils.getValue(Foo.class, subFoo, "i", true));
	}

	@Test
	public void getType() {
		assertEquals(Foo.class, ReflectionUtils.getType(
				PrivateClass.class, "foo"));
		assertEquals(Integer.TYPE, ReflectionUtils.getType(
				PrivateClass.class, "bar"));
	}

	@Test
	public void getSubType() {
		PrivateClass pc = new PrivateClass();
		assertEquals(SubFoo.class, ReflectionUtils.getSubType(
				PrivateClass.class, pc, "foo"));
		assertEquals(Integer.class, ReflectionUtils.getSubType(
				PrivateClass.class, pc, "bar"));
	}
	
	@Test(expected=ReflectionException.class)
	public void getFieldError(){
		ReflectionUtils.getField(PrivateClass.class, "whiteship");
	}

	@Test(expected=ReflectionException.class)
	public void getValueError(){
		PrivateClass pc = new PrivateClass();
		ReflectionUtils.getValue(PrivateClass.class, pc, "whiteship");
	}

}
