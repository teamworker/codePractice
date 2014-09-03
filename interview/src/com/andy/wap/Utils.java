package com.andy.wap;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * �����࣬���ڶ�ȡ��ݵ�
 * 
 * @date May 24, 2014--3:43:41 PM
 * @author Andy
 */
public class Utils {

	// static Map map = new HashMap<>();

	static char map[][];
	static int height;
	static int width;
	static File testCase = new File("test/testCase.txt");
	static Scanner scanner;

	/*
	 * ��ʱ��������ͷɾ��
	 */
	static int counter = 0;

	/*
	 * ��ȡ����ͼ�ķ���
	 */
	public static char[][] readMap() {
		// TODO read map into some data structure
		try {
			scanner = new Scanner(testCase);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while (scanner.hasNext()) {

			width = scanner.nextInt();
			height = scanner.nextInt();

			map = new char[height][width];
			/*
			 * ��ͼ
			 */
			for (int i = 0; i < height; i++) {
				map[i] = scanner.next().toCharArray();
			}
			/*
			 * ����ɾ��
			 */
			System.out.println("ͼ ��" + counter++);
			for (int i = 0; i < height; i++) {
				for (int j = 0; j < width; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}

		}

		scanner.close();
		return map;
	}
}
