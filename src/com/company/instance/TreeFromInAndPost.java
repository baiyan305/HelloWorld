package com.company.instance;

import com.company.support.Test;
import com.company.support.TreeNode;


/**
 * Created by Yan on 4/3/15.
 */
public class TreeFromInAndPost implements Test{

    @Override
    public void execute() {
        //int[] inorder = {8,4,9,2,10,5,11,1,12,6,13,3,14,7,15};
        //int[] postorder = {8,9,4,10,11,5,2,12,13,6,14,15,17,3,1};

        int[] inorder = {1,2};
        int[] postorder = {2,1};

        buildTree(inorder, postorder);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        return buildTree(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
    }

    private TreeNode buildTree(int[] inorder, int startOfInOrder, int endOfInOrder,
                               int[] postorder, int startOfPostOrder, int endOfPostOrder){

        //to-do:when to stop?
        if(startOfInOrder > endOfInOrder || startOfPostOrder > endOfPostOrder) return null;

        //find root
        int rootVal = postorder[endOfPostOrder];
        TreeNode root = new TreeNode(rootVal);

        //get the divide of left and right
        int rootIndex = -1;
        for(int i=startOfInOrder; i<=endOfInOrder; i++){
            if(inorder[i] == rootVal){
                rootIndex = i;
                break;
            }
        }

        int leftTreeSize = rootIndex - startOfInOrder;
        int rightTreeSize = endOfInOrder - rootIndex;

        //left sub tree
        root.left = buildTree(inorder, startOfInOrder, rootIndex-1, postorder, startOfPostOrder, startOfPostOrder+ leftTreeSize -1);
        root.right = buildTree(inorder, rootIndex+1, endOfInOrder, postorder, endOfPostOrder - rightTreeSize, endOfPostOrder-1);

        return root;
    }

}
