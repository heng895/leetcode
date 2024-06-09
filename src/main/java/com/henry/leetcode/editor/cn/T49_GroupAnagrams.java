//给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。 
//
// 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。 
//
// 
//
// 示例 1: 
//
// 
//输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出: [["bat"],["nat","tan"],["ate","eat","tea"]] 
//
// 示例 2: 
//
// 
//输入: strs = [""]
//输出: [[""]]
// 
//
// 示例 3: 
//
// 
//输入: strs = ["a"]
//输出: [["a"]] 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 10⁴ 
// 0 <= strs[i].length <= 100 
// strs[i] 仅包含小写字母 
// 
//
// Related Topics 数组 哈希表 字符串 排序 👍 1909 👎 0


package com.henry.leetcode.editor.cn;

import java.util.*;

/**
 * @author Henry
 * @date 2024-06-06 15:47:49
 */
//Java：字母异位词分组
public class T49_GroupAnagrams {
    public static void main(String[] args) {
        Solution solution = new T49_GroupAnagrams().new Solution();
        String[] strings = {"eat", "tea", "tan", "ate", "nat", "bat"};
        solution.groupAnagrams(strings);
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 每个str排序去map查找，找到则加入，否则新建
         *
         * @param strs
         * @return
         */
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> map = new HashMap<>();
            for (String str : strs) {
                char[] s = str.toCharArray();
                Arrays.sort(s);
                String sortedstr = new String(s);
                if (!map.containsKey(sortedstr)) map.put(sortedstr, new ArrayList<>());
                map.get(sortedstr).add(str);
            }
            return new ArrayList<>(map.values());
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
