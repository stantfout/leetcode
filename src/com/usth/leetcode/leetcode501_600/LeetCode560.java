package com.usth.leetcode.leetcode501_600;

import com.usth.annotation.FinalEnd;
import com.usth.annotation.GoodQuestion;

import java.util.HashMap;
import java.util.Map;

@FinalEnd
@GoodQuestion("Hash+前缀和")
public class LeetCode560 {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            int key = sum - k;
            res += map.getOrDefault(key,0);
            map.put(sum,map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}
