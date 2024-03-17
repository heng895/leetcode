//给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,5,11,5]
//输出：true
//解释：数组可以分割成 [1, 5, 5] 和 [11] 。 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,5]
//输出：false
//解释：数组不能分割成两个元素和相等的子集。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// 1 <= nums[i] <= 100 
// 
//
// Related Topics 数组 动态规划 👍 2031 👎 0


package com.henry.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Map;

/**
 * @author Henry
 * @date 2024-03-17 14:06:06
 */
//Java：分割等和子集
public class T416_PartitionEqualSubsetSum {
    public static void main(String[] args) {
        Solution solution = new T416_PartitionEqualSubsetSum().new Solution();
        // TO TEST
        int[] nums = {1,5,11,5};
        solution.canPartition(nums);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canPartition(int[] nums) {
            int sum = Arrays.stream(nums).sum();
            if (sum % 2 == 1) return false;
            int target = sum / 2;
            int dp[] = new int[target + 1];
            for (int i = 0; i < nums.length; i++) {
                for (int j = target; j >= nums[i]; j--) {
                    dp[j] = Math.max(dp[j], nums[i] + dp[j - nums[i]]);
                }
                if (dp[target] == target) return true;
            }
            return dp[target] == target;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
