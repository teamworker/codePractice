package com.andy.vmware;

import java.util.Arrays;  
   
/** 
 * Best Time to Buy and Sell Stock III 
 *  
 *  Say you have an array for which the ith element is the price of a given stock on day i. 
 
Design an algorithm to find the maximum profit. You may complete at most two transactions. 
 
Note: 
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again). 
 * 
 */ 
public class BestTimeToBuyAndSellStock {  
   
    public static void main(String[] args) {  
//      int[] prices = {3,3,5,0,0,3,1,4};  
        int[] prices = {2,1,2,0,1};  
        System.out.println(maxProfit(prices));  
    }  
       
    // 基本思想是分成两个时间段，然后对于某一天，计算之前的最大值和之后的最大值  
    public static int maxProfit(int[] prices) {  
        if(prices.length == 0){  
            return 0;  
        }  
           
        int max = 0;  
        // dp数组保存左边和右边的利润最大值  
        int[] left = new int[prices.length];        // 计算[0,i]区间的最大值  
        int[] right = new int[prices.length];   // 计算[i,len-1]区间的最大值  
           
        process(prices, left, right);  
           
        // O(n)找到最大值  
        for(int i=0; i<prices.length; i++){  
            max = Math.max(max, left[i]+right[i]);  
        }  
           
        return max;  
    }  
       
    public static void process(int[] prices, int[] left, int[] right){  
        left[0] = 0;  
        int min = prices[0];  
           
        // 左边递推公式  
        for(int i=1; i<left.length; i++){  
            left[i] = left[i - 1] > prices[i] - min ? left[i - 1] : prices[i] - min;    
            min = prices[i] < min ? prices[i] : min;   
        }  
           
        right[right.length-1] = 0;  
        int max = prices[right.length-1];  
        // 右边递推公式  
        for(int i=right.length-2; i>=0; i--){  
            right[i] = right[i + 1] > max - prices[i] ? right[i + 1] : max - prices[i];    
            max = prices[i] > max ? prices[i] : max;    
        }  
           
//      System.out.println(Arrays.toString(left));  
//      System.out.println(Arrays.toString(right));  
    }  
   
}

