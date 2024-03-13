//给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化。 
//
// 返回 你可以获得的最大乘积 。 
//
// 
//
// 示例 1: 
//
// 
//输入: n = 2
//输出: 1
//解释: 2 = 1 + 1, 1 × 1 = 1。 
//
// 示例 2: 
//
// 
//输入: n = 10
//输出: 36
//解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。 
//
// 
//
// 提示: 
//
// 
// 2 <= n <= 58 
// 
//
// Related Topics 数学 动态规划 👍 1355 👎 0


package com.henry.leetcode.editor.cn;

/**
 * @author Henry
 * @date 2024-03-13 14:18:51
 */
//Java：整数拆分
public class T343_IntegerBreak {
    public static void main(String[] args) {
        Solution solution = new T343_IntegerBreak().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 对每一个dp[i]，遍历j寻找拆分j与i-j的最大乘积，i-j可能也要拆分，如果dp[i-j]>i-j则说明需要拆分
         * @param n
         * @return
         */
        public int integerBreak(int n) {
            int[] dp = new int[n + 1];
            dp[2] = 1;
            for (int i = 3; i < n + 1; i++) {
                for (int j = 1; j <= i - j; j++) {
                    dp[i] = Math.max(dp[i], j * Math.max(i - j, dp[i - j]));
                }
            }
            return dp[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
