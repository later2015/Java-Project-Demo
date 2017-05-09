package com.lintcode.easy;

/**
 * 链表求和
 * 你有两个用链表代表的整数，其中每个节点包含一个数字。数字存储按照在原来整数中相反的顺序，使得第一个数字位于链表的开头。写出一个函数将两个整数相加，用链表形式返回和。
 * 给出两个链表 3->1->5->null 和 5->9->2->null，返回 8->0->8->null
 * Created by liqiliang <liqiliang@baibu.la> on 2017/5/9.
 */
public class AddLists {
    //定义本题中的链表数据结构
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * @param l1: the first list
     * @param l2: the second list
     * @return: the sum list of l1 and l2
     */
    public ListNode addLists(ListNode l1, ListNode l2) {
        // write your code here
        ListNode result;
        int val = 0;
        if (l1 == null && l2 == null) {
            return null;
        } else if (l1 == null) {
            if (l2.val < 10)
                return l2;
            else {
                result = new ListNode(val % 10);
                result.next = addLists(null, l2.next);
            }
        } else if (l2 == null) {
            if (l1.val < 10)
                return l1;
            else {
                result = new ListNode(val % 10);
                result.next = addLists(null, l1.next);
            }
        } else
            val = l1.val + l2.val;

        if (val < 10) {
            result = new ListNode(val);
            if (l1.next == null && l2.next == null)
                return result;
            else if (l1.next == null)
                result.next = addLists(null, l2.next);
            else if (l2.next == null)
                result.next = addLists(l1.next, null);
            else
                result.next = addLists(l1.next, l2.next);
            return result;
        } else {
            result = new ListNode(val % 10);
            if (l1.next == null && l2.next == null) {
                result.next = new ListNode(1);
                result.next.next = null;
                return result;
            } else if (l1.next == null) {
                l2.next.val = l2.next.val + 1;
                result.next = addLists(null, l2.next);
            } else if (l2.next == null) {
                l1.next.val = l1.next.val + 1;
                result.next = addLists(l1.next, null);
            } else {
                l1.next.val = l1.next.val + 1;
                result.next = addLists(l1.next, l2.next);
            }
            return result;
        }


    }
}
