//给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。 
//
// 
//
// 
// 
// 示例 1： 
// 
// 
//
// 
//输入：s = "(()"
//输出：2
//解释：最长有效括号子串是 "()"
// 
//
// 示例 2： 
//
// 
//输入：s = ")()())"
//输出：4
//解释：最长有效括号子串是 "()()"
// 
//
// 示例 3： 
//
// 
//输入：s = ""
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 3 * 10⁴ 
// s[i] 为 '(' 或 ')' 
// 
//
// Related Topics 栈 字符串 动态规划 👍 2510 👎 0


package com.henry.leetcode.editor.cn;

/**
 * @author Henry
 * @date 2024-05-31 14:01:27
 */
//Java：最长有效括号
public class T32_LongestValidParentheses {
    public static void main(String[] args) {
        Solution solution = new T32_LongestValidParentheses().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestValidParentheses(String s) {
            int[] dp = new int[s.length()];
            char[] str = s.toCharArray();
            int max = 0;
            for (int i = 1; i < str.length; i++) {
                if (str[i] == ')') {
                    if (str[i - 1] == '(') {
                        if (i < 2) dp[i] = 2;
                        else dp[i] = dp[i - 2] + 2;
                    } else if (i - dp[i - 1] - 1 >= 0 && str[i - dp[i - 1] - 1] == '(') {
                        if (i - dp[i - 1] - 2 < 0) dp[i] = dp[i - 1] + 2;
                        else dp[i] = dp[i - 1] + dp[i - dp[i - 1] - 2] + 2;
                    }
                }
                max = Math.max(max, dp[i]);
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
