package com.usth.leetcode.leetcode1_100;

import com.usth.annotation.GoodQuestion;
import com.usth.annotation.Undone;

import java.util.*;

@Undone
@GoodQuestion("递归+去重")
public class LeetCode90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer> > lists = new ArrayList<>();
        solve(nums,0, new LinkedList<>(), lists);
        return lists;
    }

    private void solve(int[] nums, int index, Deque<Integer> stack, List<List<Integer>> lists) {
        lists.add(new ArrayList<> (stack));
        for (int i = index; i < nums.length; i++) {
            if (i != index && nums[i] == nums[i - 1]) {
                continue;
            }
            stack.addLast(nums[i]);
            solve(nums, i + 1, stack, lists);
            stack.pollLast();
        }
    }

}
