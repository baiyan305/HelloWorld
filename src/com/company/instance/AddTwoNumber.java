package com.company.instance;

import com.company.support.*;

/**
 * Created by Yan on 3/22/15.
 */
public class AddTwoNumber implements com.company.support.Test{

    @Override
    public void execute(){
        ListNode l11 = new ListNode(5);
        /*
        ListNode l12 = new ListNode(2);
        l11.next = l12;
        ListNode l13 = new ListNode(3);
        l12.next = l13;
        ListNode l14 = new ListNode(4);
        l13.next = l14;
        */
        ListNode l21 = new ListNode(5);
        /*
        ListNode l22 = new ListNode(2);
        l21.next = l22;
        ListNode l23 = new ListNode(3);
        l22.next = l23;
        */

        ListNode head = addTwoNumbers(l11, l21);

        while(head != null){
            System.out.print(head.val + "->");
            head = head.next;
        }

        System.out.println("Done");
    }

    private ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head, cur;
        boolean plusOne = false;

        //Initialize
        int sum = l1.val + l2.val;
        l1 = l1.next;
        l2 = l2.next;
        if(sum<10) head = new ListNode(sum);
        else{
            head = new ListNode(sum%10);
            plusOne = true;
        }
        cur = head;

        //iterative
        while(l1!=null || l2!=null){
            int val1=0, val2=0;

            if(l1 != null){
                val1 = l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                val2 = l2.val;
                l2 = l2.next;
            }

            if(plusOne) sum = val1 + val2 +1;
            else sum = val1+val2;

            if(sum<10){
                cur.next = new ListNode(sum);
                plusOne = false;
            }else{
                cur.next = new ListNode(sum%10);
                plusOne = true;
            }

            cur = cur.next;
        }

        if(plusOne){
            cur.next = new ListNode(1);
        }

        return head;
    }

}
