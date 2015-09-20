package com.company.instance;

import com.company.support.Test;
import com.company.support.TreeNode;

import java.util.List;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Yan on 4/13/15.
 */
public class BinaryTreeLevelOrderTraversal implements Test{

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

        List<List<Integer>> list = levelOrder(root);

        System.out.println(list);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
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
                result.add(level);
                level = new LinkedList<Integer>();
                numOfLevel = numOfNextLevel;
                numOfNextLevel = 0;
            }
        }

        return result;

        //DFS solution
        //levelOrderImpl(root, 0, result);
    }

    //Implementation of DFS
    private void levelOrderImpl(TreeNode node, int level, List<List<Integer>> result){

        if(node == null) return;

        //add current node to list
        if(level > result.size()-1){
            List<Integer> list = new LinkedList<Integer>();
            list.add(node.val);
            result.add(list);
        }else{
            result.get(level).add(node.val);
        }

        //left and right child
        levelOrderImpl(node.left, level+1, result);
        levelOrderImpl(node.right, level+1, result);
    }
}
