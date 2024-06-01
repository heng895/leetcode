//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
//
// Related Topics 哈希表 字符串 回溯 👍 2823 👎 0


package com.henry.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Henry
 * @date 2024-05-24 15:05:41
 */
//Java：电话号码的字母组合
public class T17_LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        Solution solution = new T17_LetterCombinationsOfAPhoneNumber().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> letterCombinations(String digits) {
            List<String> res = new ArrayList<>();
            StringBuilder path = new StringBuilder();
            if (digits.isEmpty()) return res;
            String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
            backtracking(res, path, digits, numString);
            return res;
        }

        public void backtracking(List<String> res, StringBuilder path, String digits, String[] numString) {
            if (digits.length() == path.length()) {
                res.add(path.toString());
                return;
            }
            String str = numString[digits.charAt(path.length()) - '0'];
            for (int i = 0; i < str.length(); i++) {
                path.append(str.charAt(i));
                backtracking(res, path, digits, numString);
                path.deleteCharAt(path.length() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
