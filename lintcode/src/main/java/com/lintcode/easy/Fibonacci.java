package com.lintcode.easy;

/**
 * Created by liqiliang <liqiliang@baibu.la> on 2017/4/26.
 * 查找斐波纳契数列中第 N 个数。
 * <p/>
 * 所谓的斐波纳契数列是指：
 * <p/>
 * 前2个数是 0 和 1 。
 * 第 i 个数是第 i-1 个数和第i-2 个数的和。
 * 斐波纳契数列的前10个数字是：
 * <p/>
 * 0, 1, 1, 2, 3, 5, 8, 13, 21, 34 ...
 */
public class Fibonacci {
    /**
     * @param n: an integer
     * @return an integer f(n)
     * 递归模式，效率最低
     */
    public int fibonacci(int n) {
        // write your code here
        if (n == 1)
            return 0;
        if (n == 2)
            return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    /**
    * 数组模式，效率更高
    *
    * @param 
    * @return 
    * @author liqiliang <liqiliang@baibu.la>
    * @since 2017/4/26 - 17:05
    */
    public int fibonacciNew(int n) {
        int result = 0;
        int[] f = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                f[i] = 0;
            } else if (i == 1) {
                f[i] = 1;
            } else {
                f[i] = f[i - 1] + f[i - 2];
            }
            //result += f[i];
        }
        return f[n-1];
    }
}
