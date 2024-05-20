//给你一个字符串 s，找到 s 中最长的 回文 子串。 
//
// 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母组成 
// 
//
// Related Topics 双指针 字符串 动态规划 👍 7207 👎 0


package com.henry.leetcode.editor.cn;

import java.util.Arrays;

/**
 * @author Henry
 * @date 2024-05-15 13:30:22
 */
//Java：最长回文子串
public class T5_LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new T5_LongestPalindromicSubstring().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            int n = s.length();
            String res = "";
            boolean[][] dp = new boolean[n][n];
            char[] str = s.toCharArray();
            for (int len = 1; len <= n; len++) {
                for (int i = 0, j = i + len - 1; j < n; i++, j++) {
                    if (len == 1) dp[i][j] = true;
                    else if (len == 2) dp[i][j] = str[i] == str[j];
                    else dp[i][j] = dp[i + 1][j - 1] && str[i] == str[j];
                    if (dp[i][j] && len > res.length()) res = s.substring(i, i + len);
                }
            }
            return res;
        }
//        public String longestPalindrome(String s) {
//            if (s.length() < 2) return s;
//            int[] res = new int[2];
//            for (int i = 0; i < s.length(); i++) {
//                int[] odd = palindrome(s, i, i);
//                int[] even = palindrome(s, i, i + 1);
//                int[] max = odd[1] > even[1] ? odd : even;
//                if (max[1] > res[1]) res = max;
//            }
//            return s.substring(res[0], res[1] + res[0]);
//        }
//
//        private int[] palindrome(String s, int left, int right) {
//            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
//                left--;
//                right++;
//            }
//            return new int[]{left + 1, right - left - 1};
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
