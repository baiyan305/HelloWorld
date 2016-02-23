package com.company.instance;

import com.company.support.Helper;
import com.company.support.Test;
import com.company.support.ListNode;

/**
 * Created by yanba_000 on 11/3/2015.
 */
public class RemoveNodeFromLinkedList implements Test {

    @Override
    public void execute() {
        int[] arr = {1,2,3,4,1,5,6,7,8,9,1};
        ListNode head = Helper.generateLinkedListFromArray(arr);

        head = removeElements(head, 1);

        while(head != null){
            System.out.print(head.val + "-->");
            head = head.next;
        }
    }

    private ListNode removeElements(ListNode head, int val) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode cursor = dummy;

        while(cursor.next != null){
            if(cursor.next.val == val)
                cursor.next = cursor.next.next;
            else
                cursor = cursor.next;
        }

        return dummy.next;
        /*
        ListNode prev = null;
        ListNode cursor = head;

        while(cursor != null){
            if(cursor.val == val){
                if(prev == null && cursor.next == null)
                    return null;
                if(prev == null) {
                    head = cursor.next;
                    cursor.next = null;
                    cursor = head;
                }else{
                    cursor = cursor.next;
                    prev.next.next = null;
                    prev.next = cursor;
                }
            }else{
                prev = cursor;
                cursor = cursor.next;
            }
        }

        return head;
        */

    }

}
