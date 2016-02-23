package com.company.instance;

import com.company.support.Helper;
import com.company.support.ListNode;
import com.company.support.Test;

/**
 * Created by yanba_000 on 11/7/2015.
 */
public class ReverseLinkedList implements Test{

    @Override
    public void execute() {
        int[] arr = {1,2,3,4,5,6,7};

        ListNode head = Helper.generateLinkedListFromArray(arr);

        ListNode newhead = reverseList(head);

        System.out.println(newhead);
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev=null, next=head.next;

        while(next != null){
            head.next = prev;
            prev = head;
            head = next;
            next = next.next;
        }

        head.next = prev;

        return head;
    }

}
