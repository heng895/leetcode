//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返
//回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出：[[1,6],[8,10],[15,18]]
//解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[1,4],[4,5]]
//输出：[[1,5]]
//解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 10⁴ 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 10⁴ 
// 
//
// Related Topics 数组 排序 👍 2253 👎 0


package com.henry.leetcode.editor.cn;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Henry
 * @date 2024-03-07 12:00:46
 */
//Java：合并区间
public class T56_MergeIntervals {
    public static void main(String[] args) {
        Solution solution = new T56_MergeIntervals().new Solution();
        // TO TEST
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        solution.merge(intervals);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] merge(int[][] intervals) {
            if (intervals.length == 1) return intervals;
            Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
            int[] pair = intervals[0];
            List<int[]> res = new ArrayList<>();
            for (int i = 1; i < intervals.length; i++) {
                if (intervals[i][0] > pair[1]) {
                    res.add(pair);
                    pair = intervals[i];
                } else pair[1] = Math.max(pair[1], intervals[i][1]);
            }
            res.add(pair);
            return res.toArray(new int[res.size()][]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
