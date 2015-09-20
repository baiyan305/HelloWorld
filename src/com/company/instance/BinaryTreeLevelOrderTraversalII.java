package com.company.instance;

import com.company.support.Test;
import com.company.support.TreeNode;

import java.util.List;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Yan on 4/13/15.
 */
public class BinaryTreeLevelOrderTraversalII implements Test{

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

        List<List<Integer>> list = levelOrderBottom(root);

        System.out.println(list);
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        List<Integer> level = new LinkedList<Integer>();

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        int numOfLevel = 1, numOfNextLevel = 0;

        while(queue.peek() != null){

            TreeNode node = queue.poll();

            if(node.left != null){
                queue.offer(node.left);
                numOfNextLevel++;
            }
            if(node.right != null){
                queue.offer(node.right);
                numOfNextLevel++;
            }

            if(numOfLevel != 0){
                level.add(node.val);
                numOfLevel--;
            }

            if(numOfLevel == 0){
                result.add(0,level);
                level = new LinkedList<Integer>();
                numOfLevel = numOfNextLevel;
                numOfNextLevel = 0;
            }
        }

        return result;
    }

}
