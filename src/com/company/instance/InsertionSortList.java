package com.company.instance;

import com.company.support.Helper;
import com.company.support.Test;
import com.company.support.ListNode;

/**
 * Created by yanba_000 on 2/21/2016.
 */
public class InsertionSortList implements Test{

    @Override
    public void execute() {
        ListNode head = insertionSortList(Helper.generateLinkedListFromArray(new int[]{3, 9, 7, 4, 6, 8, 3, 1, 2}));

        System.out.println(head);
    }

    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null)
            return head;

        ListNode cur = head;

        while(cur.next != null){

            if(cur.val > cur.next.val){
                ListNode pack = cur.next;
                cur.next = cur.next.next;
                pack.next = null;

                if(pack.val < head.val){
                    pack.next = head;
                    head = pack;
                }else{
                    ListNode pointer = head;
                    while(true){
                        if(pointer.next.val >= pack.val){
                            pack.next = pointer.next;
                            pointer.next = pack;
                            break;
                        }else{
                            pointer = pointer.next;
                        }
                    }
                }
            }else{
                cur = cur.next;
            }

        }

        return head;
    }

}
