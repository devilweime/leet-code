package com.example.t25;

/**
 * @program: leet-code
 * @description:
 * @author: devilweime
 * @create: 2020-05-19 22:10
 **/
public class Solution1 {

    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode hair = new ListNode(Integer.MAX_VALUE);
        hair.next = head;
        ListNode prev = hair;
        ListNode start = head;
        ListNode end = null;
        ListNode next = head;

        while (next != null){
            boolean isOver = false;
            for (int i = 0; i < k-1; i++) {
                next = next.next;
                if (next == null){
                    isOver = true ;
                    break;
                }
                end = next;
            }
            if (isOver){
                break;
            }

            if (end == null){
                break;
            }

            next = end.next;
            System.out.println("start-"+start.val +"---->"+"end-"+end.val);
            try {
                Thread.sleep(2*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            reverse(start,end);
            prev.next = end;//先建立连接
            start.next = next;//先建立连接
            prev = start;//再移动外部指针
            start = next;//再移动外部指针
        }
        return hair.next;
    }


    public void reverse(ListNode start,ListNode end){
        ListNode prev = null;
        ListNode cur = start;

        ListNode last = end.next;

        while (cur != null && end != null && cur !=  last){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
    }


    public void print(ListNode head){
        if (head == null){
            System.out.println("null");
            return;
        }

        ListNode cur = head;
        while (cur != null){
            ListNode next = cur.next;
            System.out.println(cur.val);
            cur = next;
        }
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        Solution1 solution = new Solution1();
        ListNode reverse = solution.reverseKGroup(listNode1, 1);
        solution.print(reverse);
    }

}
