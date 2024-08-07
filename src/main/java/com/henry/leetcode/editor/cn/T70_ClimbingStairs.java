//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 2
//输出：2
//解释：有两种方法可以爬到楼顶。
//1. 1 阶 + 1 阶
//2. 2 阶 
//
// 示例 2： 
//
// 
//输入：n = 3
//输出：3
//解释：有三种方法可以爬到楼顶。
//1. 1 阶 + 1 阶 + 1 阶
//2. 1 阶 + 2 阶
//3. 2 阶 + 1 阶
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 45 
// 
//
// Related Topics 记忆化搜索 数学 动态规划 👍 3464 👎 0


package com.henry.leetcode.editor.cn;

/**
 * @author Henry
 * @date 2024-03-11 16:25:19
 */
//Java：爬楼梯
public class T70_ClimbingStairs {
    public static void main(String[] args) {
        Solution solution = new T70_ClimbingStairs().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * dp[i]:i阶台阶有dp[i]种排列方法(每次1、2步) dp[i] = dp[i-1]+dp[i-2]
         *
         * @param n
         * @return
         */
        public int climbStairs(int n) {
//            if (n <= 2) return n;
//            int a = 1;
//            int b = 2;
//            int sum = 0;
//            for (int i = 3; i <= n; i++) {
//                sum = a + b;
//                a = b;
//                b = sum;
//            }
//            return sum;
            int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[1] = 1;
            for (int i = 2; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            return dp[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
