package com.example.t25;

/**
 * @program: leet-code
 * @description:
 * @author: devilweime
 * @create: 2020-05-19 22:10
 **/
public class Solution {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode prev = head;
        int i = 1;
        while (true) {
            if (i > k) {
                return head;
            }
            ListNode tmp = prev;
            ListNode next = prev.next;
            prev.val=next.val;
            next.val=tmp.val;
            prev = next;//把前面看整体，prev向前移
            i++;
        }
    }

}
