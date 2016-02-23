package com.company.instance;

import java.util.*;
import java.util.LinkedList;

/**
 * Created by yanba_000 on 2/5/2016.
 */
public class SubSetTwo implements com.company.support.Test {

    @Override
    public void execute() {
        System.out.println(subsetsWithDup(new int[]{}));
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>> res = new LinkedList<List<Integer>>();

        helper(0, nums, new LinkedList<>(), res);

        return res;
    }

    private void helper(int start, int[] nums, List<Integer> list, List<List<Integer>> res){

        //add to res
        res.add(new LinkedList<>(list));

        //return if reach to the end
        if(list.size() == nums.length)
            return;

        for(int i = start; i<nums.length; i++){
            if(i != start &&nums[i] == nums[i-1])
                continue;

            list.add(nums[i]);
            helper(i+1, nums, list, res);
            list.remove(list.size()-1);
        }

    }

}
