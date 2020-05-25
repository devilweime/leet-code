package com.example.t206;

/**
 * @program: leet-code
 * @description:
 * @author: devilweime
 * @create: 2020-05-20 22:21
 **/
public class Solution2 {


    public ListNode reverseList(ListNode head) {

        if (head.next == null){
            return head;
        }
        ListNode cur = reverseList(head.next);
        head.next.next = head; //head.next == cur
        head.next = null;//这里需要理解传递
        return cur;
    }

}
