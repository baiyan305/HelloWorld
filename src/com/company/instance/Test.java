package com.company.instance;

/**
 * Created by Yan on 3/21/15.
 */
public class Test {

    public void execute(){
        LinkedListNode node1 = new LinkedListNode(1);
        LinkedListNode node2 = new LinkedListNode(2);
        node1.next = node2;

        LinkedListNode newHead = reverseKGroup(node1, 3);

        System.out.println(newHead);

        while(newHead != null){
            System.out.println(newHead.data);
            newHead = newHead.next;
        }



    }

    private LinkedListNode reverseKGroupImpl(LinkedListNode start, LinkedListNode end, LinkedListNode prevGroupEnd, LinkedListNode nextGroupStart){
        LinkedListNode prevNode = start;
        LinkedListNode curNode = prevNode.next;
        prevNode.next = nextGroupStart;
        end.next = null;
        LinkedListNode nextNode = curNode.next;

        while(nextNode != null){
            curNode.next = prevNode;
            prevNode = curNode;
            curNode = nextNode;
            nextNode = nextNode.next;
        }
        curNode.next = prevNode;

        if(prevGroupEnd!=null) prevGroupEnd.next = curNode;

        return curNode;
    }

    public LinkedListNode reverseKGroup(LinkedListNode head, int k) {

        int counter = 0;
        LinkedListNode newHead = head;
        LinkedListNode start = null;
        LinkedListNode end = null;
        LinkedListNode progress = head;
        LinkedListNode prevGroupEnd = null;
        LinkedListNode re = null;

        while(progress != null){
            if(counter == 0){
                start = progress;
            }
            progress = progress.next;
            counter++;
            if(counter == k-1 && progress != null){
                end = progress;
                progress = progress.next;
                counter = 0;
                re = reverseKGroupImpl(start, end, prevGroupEnd, progress);
                prevGroupEnd = start;

                if(start == head) newHead = re;
            }

        }

        return newHead;
        /*
        LinkedListNode endNode = head;
        while(k>1){
            endNode = endNode.next;
            k--;
        }

        LinkedListNode prevNode = head;
        LinkedListNode curNode = prevNode.next;
        prevNode.next = endNode.next;
        endNode.next = null;
        LinkedListNode nextNode = curNode.next;


        while(nextNode != null){
            curNode.next = prevNode;
            prevNode = curNode;
            curNode = nextNode;
            nextNode = nextNode.next;
        }
        curNode.next = prevNode;
        return curNode;
        */
    }

}
