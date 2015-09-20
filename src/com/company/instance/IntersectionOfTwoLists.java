package com.company.instance;

import com.company.support.Test;
import com.company.support.ListNode;

/**
 * Created by Yan on 4/21/15.
 */
public class IntersectionOfTwoLists implements Test{

    @Override
    public void execute() {

    }

    private ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;

        int lenA = getLen(headA);
        int lenB = getLen(headB);
        int offset = Math.abs(lenA-lenB);

        ListNode copyOfA = headA;
        ListNode copyOfB = headB;

        for(int i=0; i<offset; i++){
            if(lenA>lenB) copyOfA = copyOfA.next;
            else copyOfB = copyOfB.next;
        }

        while(copyOfA != null){
            if(copyOfA == copyOfB) {
                return copyOfA;
            }
            else{
                copyOfA = copyOfA.next;
                copyOfB = copyOfB.next;
            }
        }

        return copyOfA;
    }

    private int getLen(ListNode head){
        ListNode temp = head;
        int len = 0;

        while(temp != null){
            len++;
            temp = temp.next;
        }

        return len;
    }

}
