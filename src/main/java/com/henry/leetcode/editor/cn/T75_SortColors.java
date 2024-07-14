//给定一个包含红色、白色和蓝色、共 n 个元素的数组
// nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。 
//
// 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。 
//
// 
// 
//
// 必须在不使用库内置的 sort 函数的情况下解决这个问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,0,2,1,1,0]
//输出：[0,0,1,1,2,2]
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,0,1]
//输出：[0,1,2]
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 300 
// nums[i] 为 0、1 或 2 
// 
//
// 
//
// 进阶： 
//
// 
// 你能想出一个仅使用常数空间的一趟扫描算法吗？ 
// 
//
// Related Topics 数组 双指针 排序 👍 1792 👎 0


package com.henry.leetcode.editor.cn;

import java.util.Arrays;

/**
 * @author Henry
 * @date 2024-07-14 13:29:09
 */
//Java：颜色分类
public class T75_SortColors {
    public static void main(String[] args) {
        Solution solution = new T75_SortColors().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * low<=mid<=high
         * low指向0的右边界，mid指向1的右边界，high指向2的左边界
         * 当nums[mid]为0时与nums[low]交换，low++,mid++
         * 当nums[mid]为1时，mid++
         * 当nums[mid]为2时，与nums[high]交换，high--
         * 整个过程保证low的左侧只有0，mid左侧只有0和1，high的右侧只有2
         * @param nums
         */
        public void sortColors(int[] nums) {
            int low = 0, mid = 0, high = nums.length - 1;
            while (mid <= high) {
                switch (nums[mid]){
                    case 0:
                        swap(nums,low++,mid++);
                        break;
                    case 1:
                        mid++;
                        break;
                    case 2:
                        swap(nums,mid,high--);
                        break;
                }
            }
        }

        public void swap(int[] nums, int a, int b) {
            int temp = nums[a];
            nums[a] = nums[b];
            nums[b] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
