//给两个整数数组 nums1 和 nums2 ，返回 两个数组中 公共的 、长度最长的子数组的长度 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
//输出：3
//解释：长度最长的公共子数组是 [3,2,1] 。
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [0,0,0,0,0], nums2 = [0,0,0,0,0]
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums1.length, nums2.length <= 1000 
// 0 <= nums1[i], nums2[i] <= 100 
// 
//
// Related Topics 数组 二分查找 动态规划 滑动窗口 哈希函数 滚动哈希 👍 1065 👎 0


package com.henry.leetcode.editor.cn;

import java.util.Arrays;

/**
 * @author Henry
 * @date 2024-04-01 13:08:20
 */
//Java：最长重复子数组
public class T718_MaximumLengthOfRepeatedSubarray {
    public static void main(String[] args) {
        Solution solution = new T718_MaximumLengthOfRepeatedSubarray().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * dp[i][j] = dp[i - 1][j - 1] + 1;  nums[i-1]==nums[j-1]时，dp自增
         *
         * @param nums1
         * @param nums2
         * @return
         */
//        public int findLength(int[] nums1, int[] nums2) {
//            int[][] dp = new int[nums1.length + 1][nums2.length + 1];
//            int res = 0;
//            for (int i = 1; i <= nums1.length; i++) {
//                for (int j = 1; j <= nums2.length; j++) {
//                    if (nums1[i - 1] == nums2[j - 1]) {
//                        dp[i][j] = dp[i - 1][j - 1] + 1;
//                        res = Math.max(res, dp[i][j]);
//                    }
//                }
//            }
//            return res;
//        }
        public int findLength(int[] nums1, int[] nums2) {
            int[] dp = new int[nums2.length + 1];
            int res = 0;
            for (int i = 1; i <= nums1.length; i++) {
                for (int j = nums2.length; j >= 1; j--) {
                    if (nums1[i - 1] == nums2[j - 1]) dp[j] = dp[j - 1] + 1;
                    else dp[j] = 0;
                    res = Math.max(res,dp[j]);
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
