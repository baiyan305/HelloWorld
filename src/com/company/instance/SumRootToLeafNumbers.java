package com.company.instance;

import com.company.support.Test;
import com.company.support.TreeNode;


/**
 * Created by yanba_000 on 2/16/2016.
 */
public class SumRootToLeafNumbers implements Test {

    @Override
    public void execute() {
        TreeNode node1= new TreeNode(1);
        TreeNode node2= new TreeNode(2);
        TreeNode node3= new TreeNode(3);
        TreeNode node4= new TreeNode(4);
        TreeNode node5= new TreeNode(5);
        TreeNode node6= new TreeNode(6);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;

        sumNumbers(node1);
    }

    public int sumNumbers(TreeNode root) {
        int sum = sumNumbers(root, 0);

        System.out.println(sum);

        return sum;
    }

    private int sumNumbers(TreeNode root, int sum){
        sum = sum*10+root.val;

        if(root.left == null && root.right == null)
            return sum;

        int leftsum = root.left == null? 0 : sumNumbers(root.left, sum);
        int rightsum = root.right == null? 0 : sumNumbers(root.right, sum);

        return leftsum + rightsum;
    }

}
