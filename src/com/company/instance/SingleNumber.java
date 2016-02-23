package com.company.instance;

import java.util.Arrays;

/**
 * Created by yanba_000 on 2/17/2016.
 */
public class SingleNumber implements com.company.support.Test {

    @Override
    public void execute() {
        int[] nums = {1,3,5,9,5,3,4,1,9};
        System.out.println(singleNumber(nums));
    }

    public int singleNumber(int[] nums) {

        Arrays.sort(nums);
        int counter = 1;
        for(int i=0; i<nums.length-1; i++){
            if(nums[i] == nums[i+1]){
                counter++;
            }else{
                if(counter<2){
                    return nums[i];
                }else{
                    counter = 1;
                }
            }
        }

        return nums[nums.length-1];
        /*
        Arrays.sort(nums);
        if(nums[0] != nums[1])
            return nums[0];

        if(nums[nums.length-1] != nums[nums.length-2])
            return nums[nums.length-1];

        int re = -1;
        for(int i=1; i<nums.length-1; i++)
            if(nums[i] != nums[i-1] && nums[i] != nums[i+1])
                return i;


        return re;
        */

    }

}
