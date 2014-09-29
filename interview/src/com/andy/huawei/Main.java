package com.andy.huawei;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner=new Scanner(System.in);
		int input = scanner.nextInt();
		System.out.println(NumToString(input));
	}

	public static char[] NumToString(int num) {
		
		String input = String.valueOf(num);
		int len = input.length();
		char[] result = new char[len];
		for (int i = 0; i < input.length(); i++) {
			result[i] = (char) (input.charAt(i) - '1' + 'a');
		}
		return result;
	}

}
