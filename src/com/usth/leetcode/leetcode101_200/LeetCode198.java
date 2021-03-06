package com.usth.leetcode.leetcode101_200;

import com.usth.annotation.FinalEnd;
import com.usth.annotation.GoodQuestion;

@FinalEnd
@GoodQuestion("基础DP")
public class LeetCode198 {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }
        int first = nums[0];
        int second = Math.max(first,nums[1]);
        for (int i = 2; i < n; i++) {
           int max = Math.max(second, first + nums[i]);
           first = second;
           second = max;
        }
        return second;
    }
}
