//给定一个二叉树，我们在树的节点上安装摄像头。 
//
// 节点上的每个摄影头都可以监视其父对象、自身及其直接子对象。 
//
// 计算监控树的所有节点所需的最小摄像头数量。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：[0,0,null,0,0]
//输出：1
//解释：如图所示，一台摄像头足以监控所有节点。
// 
//
// 示例 2： 
//
// 
//
// 输入：[0,0,null,0,null,0,null,null,0]
//输出：2
//解释：需要至少两个摄像头来监视树的所有节点。 上图显示了摄像头放置的有效位置之一。
// 
//
// 提示： 
//
// 
// 给定树的节点数的范围是 [1, 1000]。 
// 每个节点的值都是 0。 
// 
//
// Related Topics 树 深度优先搜索 动态规划 二叉树 👍 707 👎 0


package com.henry.leetcode.editor.cn;

import javax.swing.tree.TreeNode;

/**
 * @author Henry
 * @date 2024-03-08 16:18:42
 */
//Java：监控二叉树
public class T968_BinaryTreeCameras {
    public static void main(String[] args) {
        Solution solution = new T968_BinaryTreeCameras().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        int res = 0;

        public int minCameraCover(TreeNode root) {
            if (traversal(root) == 0) res++;
            return res;
        }

        /**
         * 0: 该节点无覆盖
         * 1: 该节点有摄像头
         * 2: 该节点有覆盖
         *
         * @param cur
         * @return
         */
        public int traversal(TreeNode cur) {
            if (cur == null) return 2;
            int left = traversal(cur.left);
            int right = traversal(cur.right);
            if (left == 2 && right == 2) return 0;   //22
            else if (left == 0 || right == 0) {      //01 02 00 10 20
                res++;
                return 1;
            } else return 2;
    }
//leetcode submit region end(Prohibit modification and deletion)

}
