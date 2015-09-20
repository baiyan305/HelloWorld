package com.company.instance;

import com.company.support.Helper;
import com.company.support.Test;
import com.company.support.ListNode;

/**
 * Created by Yan on 4/22/15.
 */
public class SwapNodesInPair implements Test{

    @Override
    public void execute() {
        int[] arr = {1,2,3,4,5,6,7};
        ListNode head = Helper.generateLinkedListFromArray(arr);

        ListNode newHead = swapPairs(head);

        System.out.println(newHead);
    }

    public ListNode swapPairs(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return head;

        ListNode pointer, newHead, first, second, third;
        first = head;
        second = head.next;
        third = head.next.next;
        first.next = third;
        second.next = first;

        newHead = second;
        pointer = first;

        while(pointer != null){
            if(pointer.next == null || pointer.next.next == null)break;

            first = pointer.next;
            second = first.next;
            third = second.next;

            pointer.next = second;
            second.next = first;
            first.next = third;

            pointer = first;
        }

        return newHead;
    }

}
