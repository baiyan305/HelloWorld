package com.company.instance;

import com.company.support.Test;
import com.company.support.TreeNode;

import java.util.*;
import java.util.LinkedList;

/**
 * Created by yanba_000 on 11/5/2015.
 */
public class SymmetricTree implements Test{

    @Override
    public void execute() {
        TreeNode n1 = new TreeNode(1);

        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(2);

        n1.left = n2;
        n1.right = n3;


        TreeNode n4 = new TreeNode(3);
        TreeNode n5 = new TreeNode(4);
        TreeNode n6 = new TreeNode(4);
        TreeNode n7 = new TreeNode(3);

        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;

        TreeNode n8 = new TreeNode(5);
        TreeNode n9 = new TreeNode(6);
        TreeNode n10 = new TreeNode(7);
        TreeNode n11 = new TreeNode(8);

        n4.left = n8;
        n4.right = n9;
        n5.left = n10;
        n5.right = n11;

        TreeNode n12 = new TreeNode(8);
        TreeNode n13 = new TreeNode(7);
        TreeNode n14 = new TreeNode(6);
        TreeNode n15 = new TreeNode(5);

        n6.left = n12;
        n6.right = n13;
        n7.left = n14;
        n7.right = n15;

        System.out.println(isSymmetric(n1));
    }

    public boolean isSymmetric(TreeNode root) {

        if(root.left == null && root.right == null)
            return true;
        if(root.left == null || root.right == null)
            return false;

        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.offer(root.left);
        queue2.offer(root.right);

        while(queue1.peek() != null && queue2.peek() != null){
            TreeNode node1 = queue1.poll();
            TreeNode node2 = queue2.poll();

            if(node1.val != node2.val)
                return false;

            if( (node1.left == null && node2.right != null)
                    || (node1.left != null && node2.right == null)
                    || (node1.right == null && node2.left != null)
                    || (node1.right != null && node2.left == null))
                return false;

            if(node1.left != null){
                queue1.offer(node1.left);
                queue2.offer(node2.right);
            }

            if(node1.right != null){
                queue1.offer(node1.right);
                queue2.offer(node2.left);
            }

        }


        return true;
        /*
        if(root.left == null && root.right == null)
            return true;
        if(root.left == null || root.right == null)
            return false;
        if(root.left.val != root.right.val)
            return false;

        return helper(root.left, root.right);
        */
    }

    private boolean helper(TreeNode t1, TreeNode t2){

        if(t1 == null && t2 == null)
            return true;
        if(t1 == null || t2 == null)
            return false;
        if(t1.val != t2.val)
            return false;

        return helper(t1.left, t2.right) && helper(t1.right, t2.left);
    }

}
