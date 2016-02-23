package com.company.instance;

import com.company.support.Helper;
import com.company.support.ListNode;
import com.company.support.Test;

/**
 * Created by yanba_000 on 2/21/2016.
 */
public class SortList implements Test {

    @Override
    public void execute() {
        ListNode head = sortList(Helper.generateLinkedListFromArray(new int[]{3,9,7,4,6,8,3,1,2}));

        System.out.println(head);
    }

    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }

    private ListNode mergeSort(ListNode head){
        if(head.next == null){
            return head;
        }

        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        fast = slow.next;
        slow.next = null;

        ListNode head1 = mergeSort(head);
        ListNode head2 = mergeSort(fast);

        ListNode ret = merge(head1, head2);

        return ret;
    }

    //merge two sorted list. time complexity is O(n). space complexity is constant.
    private ListNode merge(ListNode head1, ListNode head2){
        ListNode head = null;

        //initialize head
        if(head1.val <= head2.val){
            head = head1;
            head1 = head1.next;
        }else{
            head = head2;
            head2 = head2.next;
        }
        ListNode pointer = head;

        //merge
        while(head1 != null && head2 != null){
            if(head1.val <= head2.val){
                pointer.next = head1;
                head1 = head1.next;
            }else if(head1.val > head2.val){
                pointer.next = head2;
                head2 = head2.next;
            }
            pointer = pointer.next;
        }

        while(head1 != null){
            pointer.next = head1;
            head1 = head1.next;
            pointer = pointer.next;
        }

        while(head2 != null){
            pointer.next = head2;
            head2 = head2.next;
            pointer = pointer.next;
        }

        return head;
    }

}
