package com.gponder.algorithm.leetcode;


/**
 *
 *
 * @author
 * @date 2024/12/23 17:41
 * @version V1.0
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode l3 = addTwoNumbers.addTwoNumbers(l1, l2);
        while (l3.next != null) {
            System.out.println(l3.val);
            l3 = l3.next;
        }
        System.out.println(l3.val);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = null;
        ListNode current = l3;
        int upper = 0;
        int l1v, l2v;
        do {
            if (l1 == null) {
                l1v = 0;
            } else {
                l1v = l1.val;
                l1 = l1.next;
            }
            if (l2 == null) {
                l2v = 0;
            } else {
                l2v = l2.val;
                l2 = l2.next;
            }
            int l3v = l1v + l2v + upper;
            if (l3v > 9) {
                upper = 1;
                l3v = l3v - 10;
            } else {
                upper = 0;
            }
            if (current == null) {
                l3 = new ListNode(l3v);
                current = l3;
            } else {
                current.next = new ListNode(l3v);
                current = current.next;
            }
        }
        while (l1 != null || l2 != null || upper != 0);
        return l3;
    }


    public static class ListNode {
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
}
