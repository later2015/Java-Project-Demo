package com.lintcode.easy;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 * Created by liqiliang <liqiliang@baibu.la> on 2017/5/3.
 * 删除链表中等于给定值val的所有节点。
 */
public class RemoveElements {
    // Definition for singly-linked list.
//定义本题中的链表数据结构
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * @param head a ListNode
     * @param val  an integer
     * @return a ListNode
     */
    public ListNode removeElements(ListNode head, int val) {
        // Write your code here
        if (head == null)
            return null;
        ListNode root = head, next = head.next;
        while (next != null) {
            if (next.val == val) {
                root.next = next.next;
                next = root.next;
            } else {
                root = root.next;
                next = next.next;
            }
        }
        //如果头节点符合则移除头结点元素
        if (head.val == val) {
            head = head.next;
        }
        return head;
    }
}
