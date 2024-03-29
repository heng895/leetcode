//给定一个整数数组
// prices，其中第 prices[i] 表示第 i 天的股票价格 。 
//
// 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）: 
//
// 
// 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。 
// 
//
// 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
//
// 
//
// 示例 1: 
//
// 
//输入: prices = [1,2,3,0,2]
//输出: 3 
//解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出] 
//
// 示例 2: 
//
// 
//输入: prices = [1]
//输出: 0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= prices.length <= 5000 
// 0 <= prices[i] <= 1000 
// 
//
// Related Topics 数组 动态规划 👍 1714 👎 0


package com.henry.leetcode.editor.cn;

/**
 * @author Henry
 * @date 2024-03-29 12:50:06
 */
//Java：买卖股票的最佳时机含冷冻期
public class T309_BestTimeToBuyAndSellStockWithCooldown {
    public static void main(String[] args) {
        Solution solution = new T309_BestTimeToBuyAndSellStockWithCooldown().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 0状态一：持有股票状态（今天买入股票，或者是之前就买入了股票然后没有操作，一直持有）
         * 不持有股票状态，这里就有两种卖出股票状态
         * 1状态二：保持卖出股票的状态（两天前就卖出了股票，度过一天冷冻期。或者是前一天就是卖出股票状态，一直没操作）
         * 2状态三：今天卖出股票
         * 3状态四：今天为冷冻期状态，但冷冻期状态不可持续，只有一天！
         *
         * @param prices
         * @return
         */
        public int maxProfit(int[] prices) {
            int[] dp = new int[4];
            dp[0] = -prices[0];
            for (int i = 1; i < prices.length; i++) {
                int temp = dp[0];
                dp[0] = Math.max(dp[0], Math.max(dp[3], dp[1]) - prices[i]);
                dp[1] = Math.max(dp[1], dp[3]);
                dp[3] = dp[2];
                dp[2] = temp+prices[i];
            }
            return Math.max(dp[1], Math.max(dp[2], dp[3]));
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
