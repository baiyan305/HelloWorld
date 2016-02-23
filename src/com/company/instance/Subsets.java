package com.company.instance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yanba_000 on 2/3/2016.
 */
public class Subsets implements com.company.support.Test{

    @Override
    public void execute() {
        System.out.println(subsets(new int[]{1,2,3}));
    }

    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);

        List<Integer> list = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        helper(0, nums, list, res);

        return res;
    }

    private void helper(int start, int[] nums, List<Integer> list, List<List<Integer>> res){
        res.add(new ArrayList<>(list));

        if(start == nums.length)
            return;

        for(int i=start; i<nums.length; i++){
            list.add(nums[i]);
            helper(i + 1, nums, list, res);
            list.remove(list.size()-1);
        }
    }

}
