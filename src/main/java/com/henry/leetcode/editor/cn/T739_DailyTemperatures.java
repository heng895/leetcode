//给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指对于第 i 天，下一个更高温度出现
//在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。 
//
// 
//
// 示例 1: 
//
// 
//输入: temperatures = [73,74,75,71,69,72,76,73]
//输出: [1,1,4,2,1,1,0,0]
// 
//
// 示例 2: 
//
// 
//输入: temperatures = [30,40,50,60]
//输出: [1,1,1,0]
// 
//
// 示例 3: 
//
// 
//输入: temperatures = [30,60,90]
//输出: [1,1,0] 
//
// 
//
// 提示： 
//
// 
// 1 <= temperatures.length <= 10⁵ 
// 30 <= temperatures[i] <= 100 
// 
//
// Related Topics 栈 数组 单调栈 👍 1749 👎 0


package com.henry.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Henry
 * @date 2024-04-18 14:50:53
 */
//Java：每日温度
public class T739_DailyTemperatures {
    public static void main(String[] args) {
        Solution solution = new T739_DailyTemperatures().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 单调栈：寻找任一个元素的右边或者左边第一个比自己大或者小的元素的位置
         * @param temperatures
         * @return
         */
        public int[] dailyTemperatures(int[] temperatures) {
            int[] res = new int[temperatures.length];
            Deque<Integer> stack = new ArrayDeque<>();
            stack.addFirst(0);
            for (int i = 0; i < temperatures.length - 1; i++) {
                while (!stack.isEmpty() && temperatures[i + 1] > temperatures[stack.peek()]) {
                    res[stack.peek()] = i + 1 - stack.removeFirst();
                }
                stack.addFirst(i + 1);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
