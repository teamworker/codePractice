package com.andy.baidu;

/**
 * Practing for the testing interview
 * 
 * @author Andy Zhang
 * @time Sep 24, 2014 _ 11:03:17 AM
 */
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(countWays(3));

		int[] map = new int[10];
		/*
		 * 测试有问题
		 */
		System.out.println(countWaysDP(3, map));

		int a = 2, b = 3;
		swap(a, b);
		swapBit(a, b);

		System.out.println(isLeapYear(2008));
		System.out.println(isLeapYear(1997));
		
		System.out.println(maxBinary(17));
		System.out.println(isPowerof2(4));
		System.out.println(isPowerof2(7));
		System.out.println(isPowerof2(-4));
		System.out.println(isPowerof2(1/2));
		
		System.out.println(isPower2(4));
		System.out.println(isPower2(7));
		System.out.println(isPower2(17));
		
		System.out.println("------------------------");
		
		System.out.println(maxPowerof2(17));
		System.out.println(maxPowerof2(32));
	}

	/**
	 * 上楼梯的题目 Page 222
	 * 
	 * @author Andy Zhang
	 * @time Sep 24, 2014 _ 11:25:11 AM
	 * @param n
	 * @param map
	 * @return
	 */
	/*
	 * 方法一：递归
	 */
	public static int countWays(int n) {
		if (n < 0) {
			return 0;
		} else if (n == 0) {
			return 1;
		} else {
			return countWays(n - 1) + countWays(n - 2) + countWays(n - 3);
		}
	}

	/*
	 * 方法二：动态规划
	 */
	public static int countWaysDP(int n, int[] map) {
		if (n < 0) {
			return 0;
		} else if (n == 0) {
			return 1;
		} else if (map[n] > -1) {
			return map[n];
		} else {
			map[n] = countWaysDP(n - 1, map) + countWaysDP(n - 2, map)
					+ countWaysDP(n - 3, map);
			return map[n];
		}
	}

	/**
	 * 编写一个函数，不用临时变量，直接交换两个数
	 * 
	 * @author Andy Zhang
	 * @time Sep 24, 2014 _ 12:01:09 PM
	 * @param a
	 * @param b
	 */
	public static void swap(int a, int b) {
		a = a - b;
		b = a + b;
		a = b - a;

		System.out.println("a : " + a + " b: " + b);
	}

	/*
	 * 使用的数据类型更多，不仅限于整数
	 */
	public static void swapBit(int a, int b) {
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;

		System.out.println("a : " + a + " b: " + b);
	}

	/*
	 * 判断闰年
	 */
	public static boolean isLeapYear(int year) {
		if (year % 400 == 0 || year % 4 == 0 && year % 100 != 0)
			return true;
		return false;
	}
	
	/*
	 * 计算一个不大于给订数的最大二进制数
	 */
	public static int maxBinary(int num){
		String binary = Integer.toBinaryString(num);
//		num = Integer.parseInt(binary.substring(1));
		System.out.println(binary);
		return num;
	}
	
	/*
	 * &操作符 判断一个数是否为２的整数次幂
	 */
	public static boolean isPowerof2(int num){
		return (num&(num-1))==0? true:false;
	}
	
	public static int isPower2(int num){
		return num&(num-1);
	}
	/*
	 * 计算不小于给定数的最小的2整数次方幂
	 */
	public static int maxPowerof2(int num){
		return (num&(num-1))==0?num:num&(num-1);
	}
	
	
}
