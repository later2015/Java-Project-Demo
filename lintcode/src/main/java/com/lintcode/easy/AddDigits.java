package com.lintcode.easy;

/**
 * 给出一个非负整数 num，反复的将所有位上的数字相加，直到得到一个一位的整数。
 * 给出 num = 38。

 相加的过程如下：3 + 8 = 11，1 + 1 = 2。因为 2 只剩下一个数字，所以返回 2。
 * Created by liqiliang <liqiliang@baibu.la> on 2017/5/9.
 */
public class AddDigits {
    /**
     * @param num a non-negative integer
     * @return one digit
     */
    public static int addDigits(int num) {
        // Write your code here
        int result=0;
        if (num<10)
            return num;
        while (num>=10){
            result+=num%10;
            num=num/10;
        }
        return addDigits(result+num);
    }

    public static void main(String[] args){
        System.out.println(addDigits(11389));
    }
}
