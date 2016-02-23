package com.company.instance;

import com.company.support.Test;
import com.company.support.TreeNode;

import java.util.*;
import java.util.LinkedList;

/**
 * Created by Yan on 4/12/15.
 */
public class BinaryTreePreorderTraversal implements Test{

    @Override
    public void execute() {

    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();

        while(root != null){

            //add root
            list.add(root.val);

            //right
            if(root.right != null){
                stack.push(root.right);
            }

            //left
            if(root.left != null){
                root = root.left;
            }else{
                if(!stack.empty()) root = stack.pop();
                else root = null;
            }

        }

        return list;
    }

}
