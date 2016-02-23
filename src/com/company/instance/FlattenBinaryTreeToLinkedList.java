package com.company.instance;

import com.company.support.TreeNode;

import java.util.Stack;

/**
 * Created by yanba_000 on 2/9/2016.
 */
public class FlattenBinaryTreeToLinkedList implements com.company.support.Test {

    @Override
    public void execute() {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(7);
        TreeNode node7 = new TreeNode(8);

        /*
        root.left = node1;
        root.right = node4;

        node1.left = node2;
        node1.right = node3;

        node4.right=node5;
        */

        flatten(root);

        System.out.println(root);
    }

    public void flatten(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();

        while(root.left != null || root.right != null || !stack.isEmpty()){

            if(root.right != null){
                stack.push(root.right);
                root.right = null;
            }

            if(root.left == null){
                if(!stack.isEmpty()){
                    root.right = stack.pop();
                    root = root.right;
                }
            }else{
                root.right = root.left;
                root.left = null;
                root = root.right;
            }

        }
    }

}
