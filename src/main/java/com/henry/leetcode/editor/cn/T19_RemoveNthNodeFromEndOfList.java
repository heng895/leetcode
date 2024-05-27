//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1], n = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2], n = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中结点的数目为 sz 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
//
// 
//
// 进阶：你能尝试使用一趟扫描实现吗？ 
//
// Related Topics 链表 双指针 👍 2864 👎 0


package com.henry.leetcode.editor.cn;

/**
 * @author Henry
 * @date 2024-05-25 11:12:11
 */
//Java：删除链表的倒数第 N 个结点
public class T19_RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        Solution solution = new T19_RemoveNthNodeFromEndOfList().new Solution();
        // TO TEST
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode rear = head;
            ListNode cur = head;
            while (n-- > 0) {
                rear = rear.next;
            }
            if (rear == null) return head.next;
            while (rear.next != null) {
                cur = cur.next;
                rear = rear.next;
            }
            cur.next = cur.next.next;
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
