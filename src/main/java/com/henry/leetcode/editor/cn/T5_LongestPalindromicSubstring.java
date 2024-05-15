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
        //        public String longestPalindrome(String s) {
//            int n = s.length();
//            String res = "";
//            char[] str = s.toCharArray();
//            boolean[][] dp = new boolean[n][n];
//            for (int len = 1; len <= n; len++) {
//                for (int i = 0, j = i + len - 1; j < n; i++, j++) {
//                    if (len == 1) dp[i][j] = true;
//                    else if (len == 2) dp[i][j] = str[i] == str[j];
//                    else {
//                        dp[i][j] = dp[i + 1][j - 1] && str[i] == str[j];
//                    }
//                    if (dp[i][j] && len > res.length()) res = s.substring(i, i + len);
//                }
//            }
//            return res;
//        }
        public String longestPalindrome(String s) {
            char[] str = s.toCharArray();
            if (str.length < 2) return s;
            String res = "";
            int[] tmp = new int[2];
            for (int i = 0; i < str.length; i++) {
                int[] odd = Palindrome(str, i, i);
                int[] even = Palindrome(str, i, i + 1);
                int[] max = odd[1] > even[1] ? odd : even;
                if (max[1] > tmp[1]) tmp = max;
            }
            return s.substring(tmp[0], tmp[0] + tmp[1]);
        }

        public int[] Palindrome(char[] str, int left, int right) {
            while (left >= 0 && right < str.length && str[left] == str[right]) {
                left--;
                right++;
            }
            return new int[]{left + 1, right - left - 1};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
