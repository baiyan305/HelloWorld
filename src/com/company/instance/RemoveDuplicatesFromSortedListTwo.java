package com.company.instance;

import com.company.support.Helper;
import com.company.support.ListNode;

/**
 * Created by yanba_000 on 2/4/2016.
 */
public class RemoveDuplicatesFromSortedListTwo implements com.company.support.Test {

    @Override
    public void execute() {
        int[] nums = {1,1,1,2,2,3};
        //ListNode head = deleteDuplicates(Helper.generateLinkedListFromArray(nums));
        ListNode head = deleteDuplicates(null);

        System.out.println(head);
    }

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null)
            return null;

        ListNode fakeHead = new ListNode(head.val+1);
        fakeHead.next = head;

        ListNode prev = fakeHead, cur = fakeHead.next, ret = null, cursor = null;

        while(cur != null){
            if( ((cur.next == null && cur.val != prev.val)) || (cur.val != prev.val && cur.val != cur.next.val) ){ //node to be remained
                if(ret == null){
                    ret = cur;
                    cursor = ret;
                }else{
                    cursor.next = cur;
                    cursor = cur;
                }

                prev = cur;
                cur = cur.next;
            }else{ // node to be removed
                ListNode tmp = cur;
                cur = cur.next;
                tmp.next = null;
                prev.next = null;
                prev = tmp;
            }
        }


        fakeHead.next = null;

        return ret;
    }


}
