package com.company.instance;

import com.company.support.Helper;
import com.company.support.Test;
import com.company.support.ListNode;

/**
 * Created by yanba_000 on 11/15/2015.
 */
public class RemoveDuplicateFromSortedList implements Test{

    @Override
    public void execute() {
        int[] nums = {1,2,3,3,3,3,3,4,4,5,5,5,5,6,7};

        ListNode head = Helper.generateLinkedListFromArray(nums);

        head = deleteDuplicates(head);

        while(head != null){
            System.out.print(head.val+"->");
            head = head.next;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null)
            return null;

        ListNode cursor = head;

        while(cursor.next != null){
            if(cursor.val == cursor.next.val)
                cursor.next = cursor.next.next;
            else
                cursor = cursor.next;
        }

        return head;
    }

}
