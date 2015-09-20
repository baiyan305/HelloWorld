package com.company.instance;

import com.company.support.Test;
import com.company.support.TreeNode;

/**
 * Created by Yan on 4/4/15.
 */
public class TreeFromInAndPre implements Test{

    @Override
    public void execute() {

    }

    private TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length-1,
                  inorder, 0, inorder.length-1);
    }

    private TreeNode buildTree(int[] preorder, int prestart, int preend,
                               int[] inorder, int instart, int inend) {

        if(prestart > preend || instart > inend) return null;

        int rootVal = preorder[prestart];
        TreeNode root = new TreeNode(rootVal);

        int rootIndex = -1;
        for(int i=instart; i<=inend; i++){
            if(rootVal == inorder[i]){
                rootIndex = i;
                break;
            }
        }

        int sizeOfLeft = rootIndex - instart;
        int sizeOfRight = inend - rootIndex;

        root.left = buildTree(preorder, prestart+1, prestart+sizeOfLeft,
                              inorder, instart, rootIndex-1);

        root.right = buildTree(preorder, preend-sizeOfRight+1, preend,
                              inorder, rootIndex+1, inend);

        return root;
    }

}
