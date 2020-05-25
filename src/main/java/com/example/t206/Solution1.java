package com.example.t206;

/**
 * @program: leet-code
 * @description:
 * @author: devilweime
 * @create: 2020-05-20 22:21
 **/
public class Solution1 {


    public ListNode reverseList(ListNode head) {

        ListNode prev = null;
        ListNode cur = head;
        while (cur.next != null){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

}
