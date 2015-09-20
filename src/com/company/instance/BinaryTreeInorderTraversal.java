package com.company.instance;

import com.company.support.Test;
import com.company.support.TreeNode;

import java.util.*;
import java.util.LinkedList;

/**
 * Created by Yan on 4/13/15.
 */
public class BinaryTreeInorderTraversal implements Test {

    @Override
    public void execute() {
        TreeNode root = new TreeNode(10);

        TreeNode node1 = new TreeNode(7);

        TreeNode node2 = new TreeNode(8);

        TreeNode node4 = new TreeNode(6);
        TreeNode node5 = new TreeNode(3);
        TreeNode node6 = new TreeNode(2);


        root.left = node1;
        root.right = node2;
        node1.left = node4;
        node1.right = node5;
        node5.left = node6;

        List<Integer> list = inorderTraversal(root);

        System.out.println(list);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<Integer>();
        Map<TreeNode, Boolean> map = new HashMap<TreeNode, Boolean>();
        Stack<TreeNode> stack = new Stack<TreeNode>();

        while(root != null){

            //left
            if( root.left != null && !map.containsKey(root.left) ){
                stack.push(root);
                root = root.left;
                continue;
            }

            //root
            if( root.left == null || map.containsKey(root.left) ){
                result.add(root.val);
                map.put(root, true);
            }

            //right
            if(root.right != null) {
                root = root.right;
                continue;
            }

            if(!stack.isEmpty()) root = stack.pop();
            else root = null;

        }

        return result;
    }

}
