package com.andy.indeed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1 {

	public static void main(String[] args) {

		BufferedReader stdin = new BufferedReader(new InputStreamReader(
				System.in));

		String line;
		try {
			line = stdin.readLine();
			StringTokenizer st = new StringTokenizer(line);
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int sum = 0;
			for (int i = 0; i <= a; i++) {
				line = stdin.readLine();
				int next = Integer.parseInt(line);
				sum += next;
				if (sum >= b) {
					System.out.println(i + 1);
					return;
				}

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
