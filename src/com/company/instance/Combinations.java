package com.company.instance;

import com.company.support.Test;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by yanba_000 on 2/3/2016.
 */
public class Combinations implements Test{

    @Override
    public void execute() {
        System.out.println(combine(4,4));
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<>();

        helper(1, n, k, list, res);

        return res;
    }

    private void helper(int start, int n, int k, List<Integer> list, List<List<Integer>> res){
        if(k==0){
            res.add(new ArrayList<>(list));
            return;
        }

        for(int i=start; i<=n; i++){
            list.add(i);
            helper(i + 1, n, k-1, list, res);
            list.remove(list.size()-1);
        }

    }

}
