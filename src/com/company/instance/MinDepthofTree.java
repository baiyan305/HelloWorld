package com.company.instance;

import com.company.support.Test;
import com.company.support.TreeNode;

/**
 * Created by Yan on 4/21/15.
 */
public class MinDepthofTree implements Test{

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

        System.out.println(minDepth(root));
    }

    public int minDepth(TreeNode root) {
        if(root.left != null && root.right != null){
            int left = minDepth(root.left);
            int right = minDepth(root.right);

            return (left<right?left:right)+1;
        }else if(root.left != null){
            return minDepth(root.left);
        }else if(root.right != null){
            return minDepth(root.right);
        }else{
            return 1;
        }
    }

}
