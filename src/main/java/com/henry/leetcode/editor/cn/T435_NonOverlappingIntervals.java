//给定一个区间的集合 intervals ，其中 intervals[i] = [starti, endi] 。返回 需要移除区间的最小数量，使剩余区间互不重
//叠 。 
//
// 
//
// 示例 1: 
//
// 
//输入: intervals = [[1,2],[2,3],[3,4],[1,3]]
//输出: 1
//解释: 移除 [1,3] 后，剩下的区间没有重叠。
// 
//
// 示例 2: 
//
// 
//输入: intervals = [ [1,2], [1,2], [1,2] ]
//输出: 2
//解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
// 
//
// 示例 3: 
//
// 
//输入: intervals = [ [1,2], [2,3] ]
//输出: 0
//解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= intervals.length <= 10⁵ 
// intervals[i].length == 2 
// -5 * 10⁴ <= starti < endi <= 5 * 10⁴ 
// 
//
// Related Topics 贪心 数组 动态规划 排序 👍 1116 👎 0


package com.henry.leetcode.editor.cn;

import java.util.Arrays;

/**
 * @author Henry
 * @date 2024-03-06 15:28:12
 */
//Java：无重叠区间
public class T435_NonOverlappingIntervals {
    public static void main(String[] args) {
        Solution solution = new T435_NonOverlappingIntervals().new Solution();
        // TO TEST
        int[][] intervals = {{1, 100}, {11, 22}, {1, 11}, {2, 12}};
        System.out.println(solution.eraseOverlapIntervals(intervals));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int eraseOverlapIntervals(int[][] intervals) {
            int res = 0;
            Arrays.sort(intervals, (a, b) -> a[0]-b[0]);
            int right = intervals[0][1];
            for (int i = 1; i < intervals.length; i++) {
                if (right > intervals[i][0]) {
                    res++;
                    right = Math.min(right, intervals[i][1]);
                } else {
                    right = intervals[i][1];
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
