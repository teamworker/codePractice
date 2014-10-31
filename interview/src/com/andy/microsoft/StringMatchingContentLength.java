package com.andy.microsoft;
/**
 * 
题目3 : String Matching Content Length
时间限制:10000ms
单点时限:1000ms
内存限制:256MB

描述

We define the matching contents in the strings of strA and strB as common substrings of the two strings. There are two additional restrictions on the common substrings.

The first restriction here is that every common substring's length should not be less than 3.  For example:

strA: abcdefghijklmn
strB: ababceghjklmn

The matching contents in strA and strB are substrings ("abc", "jklmn"). Note that though "e" and "gh" are common substrings of strA and strB, they are not matching content because their lengths are less than 3.

The second restriction is that the start indexes of all common substrings should be monotone increasing. For example:

strA: aaabbbbccc
strB: aaacccbbbb

The matching contents in strA and strB are substrings ("aaa", "bbbb"). Note that though "ccc" is common substring of strA and strB and has length greater than 3, the start indexes of ("aaa", "bbbb", "ccc") in strB are (0, 6, 3), which is not monotone increasing.
输入

Two lines. The first line is strA and the second line is strB. Both strA and strB are of length less than 2100.
输出

The length of matching contents (the sum of the lengths of the common substrings).
样例输入

    abcdefghijklmn
    ababceghjklmn

样例输出

    8


 * @author Andy
 * @version Oct 19, 2014 - 7:22:53 PM
 */
public class StringMatchingContentLength {

}
