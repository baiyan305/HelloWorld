package com.company.instance;

import com.company.support.Test;
import com.company.support.TreeNode;

import java.util.List;
import java.util.ArrayList;


/**
 * Created by Yan on 4/5/15.
 */
public class PathSumII implements Test{

    @Override
    public void execute() {
        TreeNode head = new TreeNode(1);

        TreeNode node1 = new TreeNode(2);
        head.left = node1;

        TreeNode node2 = new TreeNode(1);
        head.right = node2;

        TreeNode node3 = new TreeNode(4);
        node1.left = node3;

        TreeNode node4 = new TreeNode(5);
        node1.right = node4;

        TreeNode node5 = new TreeNode(6);
        node2.left = node5;

        TreeNode node6 = new TreeNode(7);
        node2.right = node6;

        List<List<Integer>> list = pathSum(head, 8);

        System.out.println(list);
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();

        if(root == null) return result;

        recursion(root, 0, path, result, sum);

        return result;
    }

    private void recursion(TreeNode root, int curSum, List<Integer> path, List<List<Integer>> result, int sum){
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.addAll(path);
        list.add(root.val);

        if(root.left == null && root.right == null){
            if(curSum+root.val == sum) result.add(list);
            return;
        }

        if(root.left != null)recursion(root.left, curSum + root.val, list, result, sum);
        if(root.right != null)recursion(root.right, curSum + root.val, list, result, sum);
    }

}
