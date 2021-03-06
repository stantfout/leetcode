package com.usth.leetcode.leetcode201_300;

import com.usth.annotation.FinalEnd;
import com.usth.annotation.GoodQuestion;

@FinalEnd
@GoodQuestion("二分查找/快慢指针")
public class LeetCode287 {
    public int findDuplicate(int[] nums) {
        int n = nums.length - 1;
        int left = 1;
        int right = n;
        int mid;
        while (left < right) {
            mid = (left + right) >> 1;
            if (judge(nums,mid)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }

    private boolean judge(int[] arr, int value) {
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= value) {
                ans++;
            }
        }
        return ans <= value;
    }

}
