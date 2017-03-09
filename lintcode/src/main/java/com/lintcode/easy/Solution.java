package com.lintcode.easy;

class Solution {
    /**
     * @return: The same instance of this class every time
     * 返回同样的单例
     */
    public static Solution solution;

    public static Solution getInstance() {
        // write your code here
        if (solution != null) {
            return solution;

        } else {
            return new Solution();

        }
    }
}