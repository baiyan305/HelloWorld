package com.company.instance;

import com.company.support.TreeNode;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by yanba_000 on 2/9/2016.
 */
public class UniqueBinarySearchTreeTwo implements com.company.support.Test{

    @Override
    public void execute() {
        List<TreeNode> roots = generateTrees(3);

        for(TreeNode root : roots){
            System.out.println(root.val);
        }
    }

    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> roots = impl(1,n);
        return roots;
    }

    private List<TreeNode> impl(int left, int right){

        List<TreeNode> nodes = new ArrayList<>();

        if(left > right){
            nodes.add(null);
            return nodes;
        }

        for(int i=left; i<=right; i++){
            List<TreeNode> leftNodes = impl(left, i-1);
            List<TreeNode> rightNodes = impl(i+1, right);
            for(TreeNode leftNode : leftNodes){
                for(TreeNode rightNode : rightNodes){
                    TreeNode root = new TreeNode(i);
                    root.left = leftNode;
                    root.right = rightNode;
                    nodes.add(root);
                }
            }
        }

        return nodes;
    }


}
