package com.company.instance;

import com.company.support.Helper;
import com.company.support.Test;
import com.company.support.ListNode;

/**
 * Created by yanba_000 on 2/2/2016.
 */
public class RotateList implements Test{

    @Override
    public void execute() {
        ListNode head = Helper.generateLinkedListFromArray(new int[]{1,2,3,4,5,6,7,8,9});

        ListNode newHead = rotateRight(head, 3);

        while(newHead != null){
            System.out.println(newHead.val);
            newHead = newHead.next;
        }

    }

    public ListNode rotateRight(ListNode head, int k) {
        if(head == null)
            return null;

        int len = 1;
        ListNode tmp = head;
        while(tmp.next != null){
            tmp = tmp.next;
            len++;
        }
        ListNode end = tmp;

        if(k%len == 0)
            return head;

        k = len - k%len;
        tmp = head;
        while(--k>0){
            tmp = tmp.next;
        }

        ListNode newHead = tmp.next;
        tmp.next = null;
        end.next = head;



        return newHead;
    }

}
