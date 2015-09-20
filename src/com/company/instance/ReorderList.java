package com.company.instance;

import com.company.support.Helper;
import com.company.support.Test;
import com.company.support.ListNode;

/**
 * Created by Yan on 4/1/15.
 */
public class ReorderList implements Test{

    @Override
    public void execute() {
        int[] arr = {1,2,3,4,5,6};
        ListNode node = Helper.generateLinkedListFromArray(arr);
        reorderList(node);
    }

    private void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) return;

        int len = 0;
        ListNode headBackUp = head;

        //get length of list
        while(head != null){
            head = head.next;
            len++;
        }

        //where to reorder
        head = headBackUp;
        for(int i=0; i<len/2; i++){
            head = head.next;
        }
        ListNode reverse = head.next;
        head.next = null;
        head = reverse(reverse);

        ListNode slowOfOriginList = headBackUp;
        ListNode fastOfOriginList = headBackUp.next;
        ListNode slowOfReverseList = head;
        ListNode fastOfReverseList = head.next;

        while(fastOfReverseList != null){
            slowOfOriginList.next = slowOfReverseList;
            slowOfReverseList.next = fastOfOriginList;

            slowOfOriginList = fastOfOriginList;
            fastOfOriginList = fastOfOriginList.next;
            slowOfReverseList = fastOfReverseList;
            fastOfReverseList = fastOfReverseList.next;
        }

        slowOfOriginList.next = slowOfReverseList;
        slowOfReverseList.next = fastOfOriginList;

        head = headBackUp;

        System.out.println(head);
    }

    private ListNode reverse(ListNode node){
        if(node.next == null) return node;

        ListNode prevNode = null, curNode = node, nextNode = node.next;

        while(nextNode != null){
            curNode.next = prevNode;
            prevNode = curNode;
            curNode = nextNode;
            nextNode = nextNode.next;
        }

        curNode.next = prevNode;

        return curNode;
    }

}
