package com.andy.huawei;

import java.util.Scanner;

class Person {

	private int id;

	private Person prev;

	private Person next;

	public Person getPrev() {
		return prev;
	}

	public void setPrev(Person prev) {
		this.prev = prev;
	}

	public Person getNext() {
		return next;
	}

	public void setNext(Person next) {
		this.next = next;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	/*
	 * 报数方法
	 */
	public void baoShu(Person person) {

	}

}

public class Ques2 {

	static int k = 0; // 标号，报数到三

	static int life = 3; // 多少个生存的人

	static Person[] person = new Person[life];

	private static Scanner scanner;

	public static void main(String[] args) {

		scanner = new Scanner(System.in);
		life = scanner.nextInt();

		for (int i = 0; i < life; i++) // 初始化人数
		{
			Person per = new Person();
			per.setId(i + 1);

			person[i] = per;

		}

		while (life > 1) // 报数
		{
			for (int i = 0; i < life; i++) {
				if (life == 2) // 人数不够标号强制通过，可以继续玩
				{
					k = 2;
				}

				if (k == 2) // 报数到三死一个
				{
					for (int j = i; j < life - 1; j++) {
						person[j] = person[j + 1];
					}

					life--; // 生存的人减少一个

					k = 0; // 重新报数
				}

				k++;
			}
		}

		for (int i = 0; i < life; i++) // 打印活着的人
		{
			System.out.println(person[i].getId());
		}
	}
}
