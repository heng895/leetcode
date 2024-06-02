//给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。 
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// nums 是一个非递减数组 
// -10⁹ <= target <= 10⁹ 
// 
//
// Related Topics 数组 二分查找 👍 2706 👎 0


package com.henry.leetcode.editor.cn;

/**
 * @author Henry
 * @date 2024-06-02 13:30:50
 */
//Java：在排序数组中查找元素的第一个和最后一个位置
public class T34_FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        Solution solution = new T34_FindFirstAndLastPositionOfElementInSortedArray().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int l = 0, r = nums.length - 1;
            while (l <= r) {
                int mid = (l + r) >> 1;
                if (nums[mid] > target) r = mid - 1;
                else if (nums[mid] < target) l = mid + 1;
                else return equalMargin(nums, mid);
            }
            return new int[]{-1, -1};
        }

        public int[] equalMargin(int[] nums, int mid) {
            int l = mid, r = mid;
            while (l >= 0 && nums[l] == nums[mid]) l--;
            while (r < nums.length && nums[r] == nums[mid]) r++;
            return new int[]{l + 1, r - 1};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
