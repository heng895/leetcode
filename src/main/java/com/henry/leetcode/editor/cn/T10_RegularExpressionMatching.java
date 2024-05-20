//给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。 
//
// 
// '.' 匹配任意单个字符 
// '*' 匹配零个或多个前面的那一个元素 
// 
//
// 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。 
//
// 示例 1： 
//
// 
//输入：s = "aa", p = "a"
//输出：false
//解释："a" 无法匹配 "aa" 整个字符串。
// 
//
// 示例 2: 
//
// 
//输入：s = "aa", p = "a*"
//输出：true
//解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
// 
//
// 示例 3： 
//
// 
//输入：s = "ab", p = ".*"
//输出：true
//解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 20 
// 1 <= p.length <= 20 
// s 只包含从 a-z 的小写字母。 
// p 只包含从 a-z 的小写字母，以及字符 . 和 *。 
// 保证每次出现字符 * 时，前面都匹配到有效的字符 
// 
//
// Related Topics 递归 字符串 动态规划 👍 3893 👎 0


package com.henry.leetcode.editor.cn;


/**
 * @author Henry
 * @date 2024-05-08 20:15:54
 */
//Java：正则表达式匹配
public class T10_RegularExpressionMatching {
    public static void main(String[] args) {
        Solution solution = new T10_RegularExpressionMatching().new Solution();
        String s = "aab";
        String p = "c*a*b";
        System.out.println(solution.isMatch(s, p));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * a*作为一个整体，可以为0个a，1个a，多个a
         * dp[i][j]:表示s[0..i]与p[0..j]是否匹配
         * @param s
         * @param p
         * @return
         */
        public boolean isMatch(String s, String p) {
            int m = s.length();
            int n = p.length();
            boolean[][] dp = new boolean[m + 1][n + 1];
            dp[0][0] = true;
            for (int i = 2; i <= n; i += 2) {
                if (p.charAt(i - 1) == '*') dp[0][i] = dp[0][i - 2];
            }
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    char chs = s.charAt(i - 1);
                    char chp = p.charAt(j - 1);
                    if (chp == '.' || chp == chs) dp[i][j] = dp[i - 1][j - 1];
                    if (chp == '*') {
                        char pre = p.charAt(j - 2);
                        //a*匹配空
                        dp[i][j] = dp[i][j - 2];
                        //a*匹配一个或多个字符
                        if (pre == '.' || pre == chs) dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                }
            }
            return dp[m][n];
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
