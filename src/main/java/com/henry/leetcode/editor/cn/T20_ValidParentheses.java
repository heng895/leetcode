//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 每个右括号都有一个对应的相同类型的左括号。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由括号 '()[]{}' 组成 
// 
//
// Related Topics 栈 字符串 👍 4453 👎 0


package com.henry.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Henry
 * @date 2024-05-27 19:36:08
 */
//Java：有效的括号
public class T20_ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new T20_ValidParentheses().new Solution();
        String s = "({{{{}}}))";
        solution.isValid(s);
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            Deque<Character> stack = new ArrayDeque<>();
            char[] str = s.toCharArray();
            for (int i = 0; i < str.length; i++) {
                if (str[i] == '(' || str[i] == '{' || str[i] == '[') stack.push(str[i]);
                else {
                    if (stack.isEmpty() || str[i] - stack.peek() != 1 && str[i] - stack.peek() != 2) return false;
                    stack.pop();    //不空，且)}]
                }
            }
            return stack.isEmpty();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
