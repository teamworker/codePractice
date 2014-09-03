package com.andy.morgan;

/**
 * 准备材料中的第十节 result: true false false false ----------------------- true
 * 
 * @author Andy
 * 
 */
public class StringDemo {
	public static void main(String[] args) {
		String str = new String("abc");
		String str1 = "abc";
		String str2 = new String("abc");
		String str3 = "abc";
		String str4 = "a" + "bc";

		System.out.println(str1 == str3);
		System.out.println(str == str1);// 这个不太理解啊
		System.out.println(str == str2);
		System.out.println(str1 == str2);
		System.out.println(str1 == str4);
		System.out.println("-----------------------");

		System.out.println(str.intern() == str1);
	}
}
