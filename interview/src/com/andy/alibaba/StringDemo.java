package com.andy.alibaba;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 
 * @author Andy
 *
 */
public class StringDemo {

	public static void main(String[] args) {
		
		List list = new ArrayList();
		
		for(int i=0; i<10;i++){
			list.add(i);
		}
		System.out.println(Collections.binarySearch(list, 5));
	}
}
