//给定一个循环数组 nums （ nums[nums.length - 1] 的下一个元素是 nums[0] ），返回 nums 中每个元素的 下一个更大元素
// 。 
//
// 数字 x 的 下一个更大的元素 是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1 
//。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,2,1]
//输出: [2,-1,2]
//解释: 第一个 1 的下一个更大的数是 2；
//数字 2 找不到下一个更大的数； 
//第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
// 
//
// 示例 2: 
//
// 
//输入: nums = [1,2,3,4,3]
//输出: [2,3,4,-1,4]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 10⁴ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
//
// Related Topics 栈 数组 单调栈 👍 931 👎 0


package com.henry.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Henry
 * @date 2024-04-22 14:54:42
 */
//Java：下一个更大元素 II
public class T503_NextGreaterElementIi {
    public static void main(String[] args) {
        Solution solution = new T503_NextGreaterElementIi().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] nextGreaterElements(int[] nums) {
            Deque<Integer> stack = new ArrayDeque<>();
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length * 2 - 1; i++) {
                while (!stack.isEmpty() && nums[stack.peek()] < nums[i % nums.length]) {
                    map.put(stack.peek(), nums[i % nums.length]);
                    stack.poll();
                }
                stack.push(i % nums.length);
            }
            int[] res = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                res[i] = map.getOrDefault(i, -1);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
