//整数数组 nums 按升序排列，数组中的值 互不相同 。 
//
// 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[
//k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2
//,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。 
//
// 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。 
//
// 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,5,6,7,0,1,2], target = 0
//输出：4
// 
//
// 示例 2： 
//
// 
//输入：nums = [4,5,6,7,0,1,2], target = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：nums = [1], target = 0
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5000 
// -10⁴ <= nums[i] <= 10⁴ 
// nums 中的每个值都 独一无二 
// 题目数据保证 nums 在预先未知的某个下标上进行了旋转 
// -10⁴ <= target <= 10⁴ 
// 
//
// Related Topics 数组 二分查找 👍 2941 👎 0


package com.henry.leetcode.editor.cn;

/**
 * @author Henry
 * @date 2024-06-01 13:54:50
 */
//Java：搜索旋转排序数组
public class T33_SearchInRotatedSortedArray {
    public static void main(String[] args) {
        Solution solution = new T33_SearchInRotatedSortedArray().new Solution();
        // TO TEST
        int[] nums = new int[]{3, 1};
        solution.search(nums, 3);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int search(int[] nums, int target) {
            int max = nums.length - 1;
            int l = 0, r = nums.length - 1;
            if (nums[l] < nums[r]) return binarySearch(nums, target, 0, max);   //仍为单调，二分全数组
            else {        //不单调，找最大值
                while (l < r) {
                    int mid = (l + r) >> 1;
                    if (nums[mid] > nums[mid + 1]) {
                        max = mid;
                        break;
                    }
                    if (nums[mid] > nums[r]) l = mid;
                    else if (nums[mid] < nums[l]) r = mid;
                }
            }
            if (target > nums[0]) return binarySearch(nums, target, 0, max);
            else if (target < nums[0]) return binarySearch(nums, target, max + 1, nums.length - 1);
            else return 0;
        }

        public int binarySearch(int[] nums, int target, int l, int r) {
            while (l <= r) {
                int mid = (l + r) >> 1;
                if (nums[mid] > target) r = mid - 1;
                else if (nums[mid] < target) l = mid + 1;
                else return mid;
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
