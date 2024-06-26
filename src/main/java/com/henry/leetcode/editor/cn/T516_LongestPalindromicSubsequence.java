//给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。 
//
// 子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "bbbab"
//输出：4
//解释：一个可能的最长回文子序列为 "bbbb" 。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出：2
//解释：一个可能的最长回文子序列为 "bb" 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由小写英文字母组成 
// 
//
// Related Topics 字符串 动态规划 👍 1197 👎 0


package com.henry.leetcode.editor.cn;

/**
 * @author Henry
 * @date 2024-04-16 16:51:13
 */
//Java：最长回文子序列
public class T516_LongestPalindromicSubsequence {
    public static void main(String[] args) {
        Solution solution = new T516_LongestPalindromicSubsequence().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * dp[i][j] 表示 s[i..j] 的最长回文子序列的长度
         * dp[i][j] = dp[i+1][j-1] + 2, if s[i] == s[j]
         * dp[i][j] = max(dp[i+1][j], dp[i][j-1]), if s[i] != s[j]
         */
        public int longestPalindromeSubseq(String s) {
            int n = s.length();
            int[][] dp = new int[n][n];
            for (int i = n - 1; i >= 0; i--) {
                dp[i][i] = 1;
                for (int j = i + 1; j < n; j++) {
                    if(s.charAt(i)==s.charAt(j)) dp[i][j] = dp[i+1][j-1]+2;
                    else dp[i][j] = Math.max(dp[i+1][j],dp[i][j-1]);
                }
            }
            return dp[0][n-1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
