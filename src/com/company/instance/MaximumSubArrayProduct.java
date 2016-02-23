package com.company.instance;

/**
 * Created by yanba_000 on 2/21/2016.
 */
public class MaximumSubArrayProduct implements com.company.support.Test {

    @Override
    public void execute() {

    }

    public int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;

        int global_max = nums[0], local_max = nums[0], local_min = nums[0];

        for(int i=1; i<nums.length; i++){
            int a = local_max * nums[i];
            int b = local_min * nums[i];
            local_max = Math.max(Math.max(a, b), nums[i]);
            local_min = Math.min(Math.min(a, b), nums[i]);
            global_max = Math.max(local_max, global_max);
        }

        return global_max;
    }

}
