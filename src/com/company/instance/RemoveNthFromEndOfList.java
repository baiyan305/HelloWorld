package com.company.instance;

import com.company.support.Test;
import com.company.support.ListNode;
import com.company.support.Helper;

/**
 * Created by Yan on 4/21/15.
 */
public class RemoveNthFromEndOfList implements Test{

    @Override
    public void execute() {
        //int[] arr = {1,2,3,4,5,6,7,8,9};
        int[] arr = {1};
        ListNode head = Helper.generateLinkedListFromArray(arr);

        ListNode node = removeNthFromEnd(head,1);

        System.out.println(node);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null) return head;

        ListNode slow = head, fast = head;

        for(int i=0; i<n; i++){
            fast = fast.next;
        }

        if(fast == null) return head.next;

        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return head;
    }

}
