package com.andy.indeed;

import java.util.*;

public class Main2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String ss1 = scanner.next();
		String ss2 = scanner.next();
		String ss3 = scanner.next();

		int j = 0;
		int h = 0;
		int len = ss3.length();
		for (int i = 0; i < len; i++) {
			char temp = ss3.charAt(i);
			if (ss1.contains(temp + "") && j < (len / 2)) {
				ss1 = ss1.substring(0, i) + ss1.substring(i + 1);
				ss3 = ss3.substring(0, i) + ss3.substring(i + 1);
				i--;
				j++;

			} else if (ss2.contains(temp + "") && h < (len / 2)) {
				ss2 = ss2.substring(0, i) + ss2.substring(i + 1);
				ss3 = ss3.substring(0, i) + ss3.substring(i + 1);
				i--;
				h++;
			}

		}
		if (ss3.length() == 0) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}

	}

}
