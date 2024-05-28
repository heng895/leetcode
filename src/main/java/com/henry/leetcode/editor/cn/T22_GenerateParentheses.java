//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
//
// Related Topics 字符串 动态规划 回溯 👍 3589 👎 0


package com.henry.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Henry
 * @date 2024-05-28 13:20:00
 */
//Java：括号生成
public class T22_GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new T22_GenerateParentheses().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> res = new ArrayList<>();
            dfs(res, n, n, "");
            return res;
        }

        public void dfs(List<String> res, int left, int right, String path) {
            if (left == 0 && right == 0) {
                res.add(path);
                return;
            }
            if (left > 0) dfs(res, left - 1, right, path + '(');
            if (right > left) dfs(res, left, right - 1, path + ')');
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}
