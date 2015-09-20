package com.company.instance;

import com.company.support.Test;
import com.company.support.TreeNode;

import java.util.Queue;
import java.util.Map;
import java.util.Stack;
import java.util.LinkedList;
import java.util.HashMap;

/**
 * Created by Yan on 4/18/15.
 */
public class BinarySearchTreeIterator implements Test{

    Queue<Integer> queue = new LinkedList<Integer>();

    @Override
    public void execute() {
        TreeNode root = new TreeNode(10);

        TreeNode node1 = new TreeNode(5);

        TreeNode node2 = new TreeNode(15);

        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(7);
        TreeNode node6 = new TreeNode(6);


        root.left = node1;
        root.right = node2;
        node1.left = node4;
        node1.right = node5;
        node5.left = node6;

        BinarySearchTreeIterator(root);

        System.out.println(queue);
    }



    public void BinarySearchTreeIterator(TreeNode root) {
        Map<TreeNode, Boolean> map = new HashMap<TreeNode, Boolean>();
        Stack<TreeNode> stack = new Stack<TreeNode>();

        TreeNode cur = root;

        while(cur != null){
            //traverse left child if it exists
            if(cur.left != null && !map.containsKey(cur.left)){
                stack.push(cur);
                cur = cur.left;
                continue;
            }

            //add current node if left node is already been added
            if( (cur.left != null && map.containsKey(cur.left)) || (cur.left == null) ){
                queue.offer(cur.val);
                map.put(cur, true);
                cur = cur.right;
            }

            if(cur == null){
                if(!stack.isEmpty()) cur = stack.pop();
            }
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if(!queue.isEmpty()) return true;
        else return false;
    }

    /** @return the next smallest number */
    public int next() {
        return queue.poll();
    }

}
