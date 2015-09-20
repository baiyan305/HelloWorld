package com.company.instance;

import com.company.support.Test;
import com.company.support.TreeLinkNode;

/**
 * Created by Yan on 4/3/15.
 */
public class PopulatingNextRightPointersInEachNode implements Test{

    @Override
    public void execute() {
        TreeLinkNode root = new TreeLinkNode(1);

        TreeLinkNode node1 = new TreeLinkNode(2);
        TreeLinkNode node2 = new TreeLinkNode(3);

        root.left = node1;
        root.right = node2;

        TreeLinkNode node3 = new TreeLinkNode(4);
        TreeLinkNode node4 = new TreeLinkNode(5);

        node1.left = node3;
        node1.right = node4;

        TreeLinkNode node5 = new TreeLinkNode(6);
        TreeLinkNode node6 = new TreeLinkNode(7);

        node2.left = node5;
        node2.right = node6;

        connect(root);

        System.out.println("12");
    }


    private void connect(TreeLinkNode root) {

        //leaf node, return.
        if(root.left == null) return;

        //connect left to right
        root.left.next = root.right;

        //connect right to left of adjacent node
        if(root.next != null){
            root.right.next = root.next.left;
        }

        connect(root.left);
        connect(root.right);
    }

}
