package com.andy.microsoft;
/**
 * 
题目2 : Performance Log
时间限制:8000ms
单点时限:1000ms
内存限制:256MB

描述

You are given a txt file, which is performance logs of a single-threaded program.

Each line has three columns as follow:

[Function Name] [TimeStamp] [Action]

[FunctionName] is a string of length between 1~255

[TimeStamp] format is hh:mm:ss

Valid values for "Action" column are START or END, marking the start or end of a function call.

Each function will only be called once.

Output the depth-first traversal result of the call graph with the total time of each function call. However, sometimes the performance log isn't correct and at that time you just need to output "Incorrect performance log".
输入

The input only contains 1 case, first line is a positive number N representing the number of logs(1 <= N <= 20000), then there are N lines in next, each line is the log info containing [Function Name] [TimeStamp] [Action], [Function Name] is a string, you can assume the [Function Name] is distinct and the length between 1~255.
输出

Output the depth-first traversal result of the call graph with the total time of each function call for the correct performance, or output "Incorrect performance log".
提示

A call graph is a directed graph that represents calling relationships between subroutines in a computer program.

Call graph for the sample input is shown as below:

[callgraph.png]

Another sample test case.
Sample Input	Sample Output
8
FuncA 00:00:01 START
FuncB 00:00:02 START
FuncC 00:00:03 START
FuncA 00:00:04 END
FuncB 00:00:05 END
FuncD 00:00:06 START
FuncD 00:00:07 END
FuncC 00:00:08 END	Incorrect performance log









样例输入

    8
    FuncA 00:00:01 START
    FuncB 00:00:02 START
    FuncC 00:00:03 START
    FuncC 00:00:04 END
    FuncB 00:00:05 END
    FuncD 00:00:06 START
    FuncD 00:00:07 END
    FuncA 00:00:08 END

样例输出

    FuncA 00:00:07
    FuncB 00:00:03
    FuncC 00:00:01
    FuncD 00:00:01


 * @author Andy
 * @version Oct 19, 2014 - 7:21:34 PM
 */
public class PerformanceLog {

}
