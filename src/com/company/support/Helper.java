package com.company.support;

/**
 * Created by Yan on 4/1/15.
 */
public class Helper {

    public static ListNode generateLinkedListFromArray(int[] arr){
        ListNode head = new ListNode(arr[0]);

        ListNode temp = head;

        for(int i=1; i<arr.length ;i++){
            ListNode node = new ListNode(arr[i]);
            temp.next = node;
            temp = temp.next;
        }

        return head;
    }

}
