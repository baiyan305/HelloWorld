package com.company.instance;

import com.company.support.Test;
import com.company.support.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by yanba_000 on 11/6/2015.
 */
public class BinaryTreePaths implements Test {

    @Override
    public void execute() {
        TreeNode n1 = new TreeNode(1);

        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);

        n1.left = n2;
        n1.right = n3;


        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);

        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;

        TreeNode n8 = new TreeNode(8);
        TreeNode n9 = new TreeNode(9);
        TreeNode n10 = new TreeNode(10);
        TreeNode n11 = new TreeNode(11);

        n4.left = n8;
        n4.right = n9;
        n5.left = n10;
        n5.right = n11;

        TreeNode n12 = new TreeNode(12);
        TreeNode n13 = new TreeNode(13);
        TreeNode n14 = new TreeNode(14);
        TreeNode n15 = new TreeNode(15);

        n6.left = n12;
        n6.right = n13;
        n7.left = n14;
        n7.right = n15;

        binaryTreePaths(n1);
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();

        helper(root, null, list);

        return list;
    }

    public void helper(TreeNode node, String str, List<String> list){

        if(str == null){  //node is not null but str is null which means this node is the first
            str = new String(String.valueOf(node.val)) ;
        }else{  //node is not null but str is null which means this node is the first
            str += "->"+node.val;
        }

        if(node.left == null && node.right == null) {
            list.add(str);
            return;
        }

        if(node.left != null)
            helper(node.left, str, list);
        if(node.right != null)
            helper(node.right, str, list);
    }

}
