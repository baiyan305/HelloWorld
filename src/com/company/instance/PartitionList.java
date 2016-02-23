package com.company.instance;

import com.company.support.Helper;
import com.company.support.ListNode;

/**
 * Created by yanba_000 on 2/5/2016.
 */
public class PartitionList implements com.company.support.Test {

    @Override
    public void execute() {
        int[] nums = {1,4,3,2,5,2};
        ListNode head = Helper.generateLinkedListFromArray(nums);

        head = partition(head, 3);

        System.out.println(head);
    }

    public ListNode partition(ListNode head, int x) {
        ListNode leftHead = null, rightHead = null, leftPointer = null, rightPointer = null;

        while(head != null){
            if(head.val < x){ //go left
                if(leftHead == null){
                    leftHead = head;
                    leftPointer = head;
                }else{
                    leftPointer.next = head;
                    leftPointer = head;
                }
            }else{ //go right
                if(rightHead == null){
                    rightHead = head;
                    rightPointer = head;
                }else{
                    rightPointer.next = head;
                    rightPointer = head;
                }
            }

            head = head.next;
        }

        //right half is not empty
        if(rightHead != null) {
            rightPointer.next = null;
            if(leftHead == null){
                return rightHead;
            }else{
                leftPointer.next = rightHead;
                return leftHead;
            }

        }

        //right half is empty
        if(leftPointer != null)
            leftPointer.next = rightHead;

        return leftHead;
    }

}
