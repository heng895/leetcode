//给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。 
//
// 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。 
//
// 你可以认为每种硬币的数量是无限的。 
//
// 
//
// 示例 1： 
//
// 
//输入：coins = [1, 2, 5], amount = 11
//输出：3 
//解释：11 = 5 + 5 + 1 
//
// 示例 2： 
//
// 
//输入：coins = [2], amount = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：coins = [1], amount = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= coins.length <= 12 
// 1 <= coins[i] <= 2³¹ - 1 
// 0 <= amount <= 10⁴ 
// 
//
// Related Topics 广度优先搜索 数组 动态规划 👍 2740 👎 0


package com.henry.leetcode.editor.cn;

import java.util.Arrays;

/**
 * @author Henry
 * @date 2024-03-20 15:04:29
 */
//Java：零钱兑换
public class T322_CoinChange {
    public static void main(String[] args) {
        Solution solution = new T322_CoinChange().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * dp[j]:amount为j的钱，最少有dp[j]种coins组合
         * @param coins
         * @param amount
         * @return
         */
        public int coinChange(int[] coins, int amount) {
            int[] dp = new int[amount + 1];
            Arrays.fill(dp, Integer.MAX_VALUE - 1);
            dp[0] = 0;
            for (int i = 0; i < coins.length; i++) {
                for (int j = coins[i]; j <= amount; j++) {
                    dp[j] = Math.min(dp[j], 1 + dp[j - coins[i]]);
                }
            }
            return dp[amount] == Integer.MAX_VALUE - 1 ? -1 : dp[amount];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}
