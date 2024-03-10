//当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。 
//
// 给定一个整数 n ，返回 小于或等于 n 的最大数字，且数字呈 单调递增 。 
//
// 
//
// 示例 1: 
//
// 
//输入: n = 10
//输出: 9
// 
//
// 示例 2: 
//
// 
//输入: n = 1234
//输出: 1234
// 
//
// 示例 3: 
//
// 
//输入: n = 332
//输出: 299
// 
//
// 
//
// 提示: 
//
// 
// 0 <= n <= 10⁹ 
// 
//
// Related Topics 贪心 数学 👍 453 👎 0


package com.henry.leetcode.editor.cn;

import java.util.Arrays;

/**
 * @author Henry
 * @date 2024-03-08 15:05:21
 */
//Java：单调递增的数字
public class T738_MonotoneIncreasingDigits {
    public static void main(String[] args) {
        Solution solution = new T738_MonotoneIncreasingDigits().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int monotoneIncreasingDigits(int n) {
            char[] str = String.valueOf(n).toCharArray();
            int nine = str.length;
            for(int i=str.length-1;i>0;i--){
                if(str[i]<str[i-1]){
                    str[i-1]--;
                    nine = i;
                }
            }
            Arrays.fill(str,nine,str.length,'9');
            return Integer.parseInt(new String(str));
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
