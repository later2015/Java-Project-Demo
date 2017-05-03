package com.lintcode.easy;

/**
 * 经典二分查找问题
 * 在一个排序数组中找一个数，返回该数出现的任意位置，如果不存在，返回-1
 * 样例
 * 给出数组 [1, 2, 2, 4, 5, 5].
 * <p/>
 * 对于 target = 2, 返回 1 或者 2.
 * 对于 target = 5, 返回 4 或者 5.
 * 对于 target = 6, 返回 -1.
 * Created by liqiliang <liqiliang@baibu.la> on 2017/5/3.
 */
public class FindPosition {
    public static void main(String[] args){
        int[] array={1,2,2,4,5,6,7};
        System.out.print(findPosition(array,2));
    }
    /**
     * @param nums:   An integer array sorted in ascending order
     * @param target: An integer
     * @return an integer
     */
    public static int findPosition(int[] nums, int target) {
        // Write your code here
        int start = 0;
        int end = nums.length;
        for (int i = 0; i < nums.length / 2; i++) {
            int temp = (start + end) / 2;
            if (nums[temp] == target) {
                return temp;
            } else if (nums[temp] > target) {
                end = temp;
            } else {
                start = temp;
            }
            if (start > end)
                break;
        }
        return -1;
    }
}
