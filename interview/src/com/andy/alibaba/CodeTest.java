package com.andy.alibaba;
/**
 * Test for factorial function.
 * @date Aug 29, 2014--2:44:37 PM
 * @author Andy
 */
public class CodeTest {

	public static void main(String[] args) {
		
		System.out.println("Please input your factor!");
		
		System.out.println("The result is : "+factorial(3));
		
	}
	
	static int factorial(int factor){
		if(factor == 0||factor ==1){
			return 1;
		}
		return factor*factorial(factor-1);
	}
}
