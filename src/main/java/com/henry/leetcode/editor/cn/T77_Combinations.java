//给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。 
//
// 你可以按 任何顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4, k = 2
//输出：
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
//
// 示例 2： 
//
// 
//输入：n = 1, k = 1
//输出：[[1]] 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 1 <= k <= n 
// 
//
// Related Topics 回溯 👍 1627 👎 0


package com.henry.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Henry
 * @date 2024-05-25 13:06:17
 */
//Java：组合
public class T77_Combinations {
    public static void main(String[] args) {
        Solution solution = new T77_Combinations().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        public List<List<Integer>> combine(int n, int k) {

            backtracking(n, k, 1);
            return res;
        }

        public void backtracking(int n, int k, int start) {
            if (k == path.size()) {
                res.add(new ArrayList<>(path));
                return;
            }
            for (int i = start; i <= n - (k - path.size()) + 1; i++) {
                path.add(i);
                backtracking(n, k, i + 1);
                path.remove(path.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
