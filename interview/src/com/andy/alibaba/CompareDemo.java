package com.andy.alibaba;

import java.util.TreeSet;

/**
 * TreeSet里面放对象，如果同时放入了父类和子类的实例对象，那比较时使用的是父类的compareTo方法，还是使用的子类的compareTo方法，
 * 还是抛异常！
 * 
 * （应该是没有针对问题的确切的答案，当前的add方法放入的是哪个对象，就调用哪个对象的compareTo方法，至于这个compareTo方法怎么做，
 * 就看当前这个对象的类中是如何编写这个方法的）
 * 
 * @author Andy
 * 
 */

class Parent implements Comparable {

	private int age = 0;

	public Parent(int age) {

		this.age = age;

	}

	public int compareTo(Object o) {

		System.out.println("method of parent");

		Parent o1 = (Parent) o;

		return age > o1.age ? 1 : age < o1.age ? -1 : 0;

	}

}

class Child extends Parent {

	public Child() {

		super(3);

	}

	public int compareTo(Object o) {

		System.out.println("method of child");

		return 1;

	}

}

class CompareDemo {

	/**
	 * 
	 * @param args
	 */

	public static void main(String[] args) {

		TreeSet set = new TreeSet();

		set.add(new Parent(3));

		set.add(new Child());

		set.add(new Parent(4));

		System.out.println(set.size());

	}

}