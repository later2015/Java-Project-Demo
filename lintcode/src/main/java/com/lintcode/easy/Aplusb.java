package com.lintcode.easy;

/**
 * 给出两个整数a和b, 求他们的和, 但不能使用 + 等数学运算符。
 * <p/>
 * Created by liqiliang <liqiliang@baibu.la> on 2017/5/3.
 */
public class Aplusb {
    /*
 * param a: The first integer
 * param b: The second integer
 * return: The sum of a and b
 */
    public int aplusb(int a, int b) {
        // write your code here, try to do it without arithmetic operators.
        if (a == b)
            return 2 * a;
        return (a * a - b * b) / (a - b);
    }
}
