//给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 
//
// 子数组 是数组中的一个连续部分。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出：6
//解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：nums = [5,4,-1,7,8]
//输出：23
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// 
//
// 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。 
//
// Related Topics 数组 分治 动态规划 👍 6617 👎 0


package com.henry.leetcode.editor.cn;

/**
 * @author Henry
 * @date 2024-04-05 20:42:44
 */
//Java：最大子数组和
public class T53_MaximumSubarray {
    public static void main(String[] args) {
        Solution solution = new T53_MaximumSubarray().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 当前结果>0，则+nums[i];否则取max(当前结果,nums[i])，最后找出每次结果最大的
         *
         * @param nums
         * @return
         */
        public int maxSubArray(int[] nums) {
            int sum = nums[0];
            int max = sum;
            for (int i = 1; i < nums.length; i++) {
                if (sum > 0) sum += nums[i];
                else sum = Math.max(sum, nums[i]);
                max = Math.max(sum,max);
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
