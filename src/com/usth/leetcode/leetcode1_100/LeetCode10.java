package com.usth.leetcode.leetcode1_100;

import com.usth.annotation.FinalEnd;
import com.usth.annotation.GoodQuestion;

@FinalEnd
@GoodQuestion("动态规划/状态机")
public class LeetCode10 {
    public boolean isMatch(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;
        for (int j = 1; j <= m; j++) {
            for (int i = 0; i <= n; i++) {
                if (pattern.charAt(j - 1) == '*') {
                    if (i == 0) {
                        dp[i][j] = dp[i][j - 2];
                    } else {
                        dp[i][j] = dp[i][j - 2] || (dp[i - 1][j] && (text.charAt(i - 1) == pattern.charAt(j - 2) || pattern.charAt(j - 2) == '.'));
                    }
                } else {
                    if (i != 0) {
                        dp[i][j] = dp[i - 1][j - 1] &&
                                (text.charAt(i - 1) == pattern.charAt(j - 1) || pattern.charAt(j - 1) == '.');
                    }
                }
            }
        }
        return dp[n][m];
    }
}
