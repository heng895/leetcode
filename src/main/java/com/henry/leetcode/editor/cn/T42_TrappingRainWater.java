//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
// 
//
// 示例 2： 
//
// 
//输入：height = [4,2,0,3,2,5]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 1 <= n <= 2 * 10⁴ 
// 0 <= height[i] <= 10⁵ 
// 
//
// Related Topics 栈 数组 双指针 动态规划 单调栈 👍 5144 👎 0


package com.henry.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Henry
 * @date 2024-04-30 13:51:19
 */
//Java：接雨水
public class T42_TrappingRainWater {
    public static void main(String[] args) {
        Solution solution = new T42_TrappingRainWater().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 双指针
         * @param height
         * @return
         */
//        public int trap(int[] height) {
//            int n = height.length;
//            int[] leftMax = new int[n];
//            int[] rightMax = new int[n];
//            int sum = 0;
//
//            leftMax[0] = height[0];
//            for (int i = 1; i < n; i++) {
//                leftMax[i] = Math.max(height[i], leftMax[i - 1]);
//            }
//            rightMax[n - 1] = height[n - 1];
//            for (int i = n - 2; i >= 0; i--) {
//                rightMax[i] = Math.max(height[i], rightMax[i + 1]);
//            }
//
//            for (int i = 1; i < n - 1; i++) {
//                int count = Math.min(leftMax[i], rightMax[i]);
//                if (count < 0) continue;
//                sum += count - height[i];
//            }
//            return sum;
//        }

        /**
         * 单调栈
         *
         * @param height
         * @return
         */
        public int trap(int[] height) {
            Deque<Integer> stack = new ArrayDeque<>();
            stack.push(0);
            int sum = 0;
            for (int i = 1; i < height.length; i++) {
                while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                    int mid = stack.pop();
                    if (!stack.isEmpty()) {
                        int h = Math.min(height[stack.peek()], height[i]) - height[mid];
                        int w = i - stack.peek() - 1;
                        sum += h * w;
                    }
                }
                stack.push(i);
            }
            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
