package com.company.instance;

import com.company.support.Test;
import com.company.support.TreeNode;

/**
 * Created by Yan on 4/4/15.
 */
public class SameTree implements Test {

    @Override
    public void execute() {

    }

    private boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if( (p == null && q != null) || (p != null && q == null) || (p.val != q.val) ) return false;
        if(!isSameTree(p.left, q.left) || !isSameTree(p.right, q.right)) return false;

        return true;
    }

}
