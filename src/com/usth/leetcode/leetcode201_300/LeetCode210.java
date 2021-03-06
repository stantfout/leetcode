package com.usth.leetcode.leetcode201_300;
import com.usth.annotation.FinalEnd;
import com.usth.annotation.GoodQuestion;

import	java.util.LinkedList;
import	java.util.Queue;

@FinalEnd
@GoodQuestion("拓扑排序")
public class LeetCode210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) {
            return new int[0];
        }
        int[] inDegrees = new int[numCourses];
        for (int[] p : prerequisites) {
            inDegrees[p[0]]++;
        }
        Queue<Integer> queue = new LinkedList<> ();
        for (int i = 0; i < inDegrees.length; ++i) {
            if (inDegrees[i] == 0) {
                queue.add(i);
            }
        }
        int count = 0;
        int[] res = new int[numCourses];
        while (!queue.isEmpty()) {
            int poll = queue.poll();
            res[count++] = poll;
            for (int[] p : prerequisites) {
                if (p[1] == poll) {
                    inDegrees[p[0]]--;
                    if (inDegrees[p[0]] == 0) {
                        queue.add(p[0]);
                    }
                }
            }

        }
        return count == numCourses ? res : new int[0];
    }
}
