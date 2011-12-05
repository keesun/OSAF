package org.opensprout.sandbox.generic;

public class Box<T> {
	
	public static<T> Box<T> make(){
		return new Box<T>();
	}
	
	public void print(T t){
		System.out.println(t);
	}
}
