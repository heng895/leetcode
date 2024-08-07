//给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,3,1,1,4]
//输出：true
//解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1,0,4]
//输出：false
//解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁴ 
// 0 <= nums[i] <= 10⁵ 
// 
//
// Related Topics 贪心 数组 动态规划 👍 2779 👎 0


package com.henry.leetcode.editor.cn;

/**
 * @author Henry
 * @date 2024-06-13 15:21:25
 */
//Java：跳跃游戏
public class T55_JumpGame {
    public static void main(String[] args) {
        Solution solution = new T55_JumpGame().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 设置一个变量len，记录当前能到达的最远位置len=max(len, i+nums[i])
         *
         * @param nums
         * @return
         */
        public boolean canJump(int[] nums) {
            int len = nums[0];
            for (int i = 1; i < nums.length; i++) {
                if (len < i) return false;
                len = Math.max(len, i + nums[i]);
                if (len > nums.length - 1) break;
            }
            return true;
//            int n = nums.length;
//            boolean[] dp = new boolean[n];
//            for (int i = n - 1; i >= 0; i--) {
//                if (nums[i] >= n - 1 - i) {
//                    dp[i] = true;
//                    continue;
//                }
//                for (int j = 0; j <= nums[i] && i + j < n; j++) {
//                    if (dp[i + j] == true) {
//                        dp[i] = true;
//                        break;
//                    }
//                }
//            }
//            return dp[0];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
