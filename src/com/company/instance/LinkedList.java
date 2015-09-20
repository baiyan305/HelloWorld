package com.company.instance;

import java.util.Stack;

/**
 * Created by Yan on 1/21/15.
 */
public class LinkedList {

    public LinkedListNode start;
    private int size = 0;

    public void LinkedList(){
        start = null;
        size = 0;
    }

    public void insert(int data){
        LinkedListNode temp;

        if(start == null){
            start = new LinkedListNode(data);
        }else{
            temp = start;

            while(temp.next != null){
                temp = temp.next;
            }

            temp.next = new LinkedListNode(data);
        }

        size++;
    }

    public void delete(int index){
        LinkedListNode temp = start;

        if(index > this.size){
            System.out.println("Out of index!");
        }

        for(int i =0; i<index-2; i++){
            temp = temp.next;
        }

        temp.next = temp.next.next;
    }

    public void search(int data){

    }

    public int kToLast(int k){

        // Check if linkedlist is null
        if(start == null) {
            System.out.println("LinkedList is null!");
            return -1; //error check
        }

        LinkedListNode n1 = start;
        LinkedListNode n2 = start;

        // Move p2 forward k node
        for(int i=0; i<k-1; i++){
            n2 = n2.next;
            if(n2 == null){
                System.out.println("OutOfIndex!");
                return -1;
            }
        }

        // Move p1 and p2 in same speed
        while(n2.next != null){
            n1 = n1.next;
            n2 = n2.next;
        }

        return n1.data;
    }

    public void print(){
        LinkedListNode temp = start;

        while(temp.next != null){
            System.out.print(temp.data + " --> ");
            temp = temp.next;
        }

        System.out.print(temp.data);
    }

    public int size(){
        return size;
    }

    public void partition(int value){
        LinkedListNode firstBiggerNode = start, temp;
        boolean firstBiggerNodeFound = false;

        // check if the list is null
        if(start == null){
            System.out.println("LinkedList is null!");
            return;
        }

        // find the first node whose value is bigger than argument value
        while(!firstBiggerNodeFound && firstBiggerNode != null){
            if(firstBiggerNode.data > value) firstBiggerNodeFound = true;
            else firstBiggerNode = firstBiggerNode.next;
        }

        if(firstBiggerNodeFound == false){
            System.out.println("All nodes are less than value!");
            return;
        }

        // partition the list based on the first bigger node
        // Iterate all the nodes after "firstBiggerNode".
        while(firstBiggerNode.next != null){

            if(firstBiggerNode.next.data < value){
                temp = firstBiggerNode.next;
                firstBiggerNode.next = temp.next;
                temp.next = start;
                start = temp;
            }

            firstBiggerNode = firstBiggerNode.next;
        }

    }

    public boolean isPalindrome(){
        LinkedListNode slow = start, fast = start;

        Stack<Integer> stack = new Stack<Integer>();

        // push first part to stack
        while(fast != null && fast.next != null){
            stack.push(slow.data);
            slow = slow.next;
            fast = fast.next.next;
        }

        // move slow from middle to the start of last part
        if(fast != null){
            slow = slow.next;
        }

        // compare
        while(slow != null){
            int top = stack.pop().intValue();

            if(top != slow.data){
                return false;
            }

            slow = slow.next;
        }

        return true;
    }

    /*
    public void reverseList(LinkedListNode head){
        LinkedListNode before = null;
        LinkedListNode temp = head;



        if(temp != null){
            LinkedListNode next = ;

            cur = next;
            next = temp;
            temp = temp.next;
        }

        this.start = next;
    }
    */

}
