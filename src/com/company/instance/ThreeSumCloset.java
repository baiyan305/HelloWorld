package com.company.instance;

import java.util.Arrays;
import com.company.support.Test;

/**
 * Created by yanba_000 on 11/26/2015.
 */
public class ThreeSumCloset implements Test{

    @Override
    public void execute() {
        int[] nums = {-1,2,1,-4};

        System.out.println(threeSumClosest(nums, 1));
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int len = nums.length;

        if(target >= nums[len-1]*3)
            return nums[len-1]+nums[len-2]+nums[len-3];
        if(target <= nums[0]*3)
            return nums[0]+nums[1]+nums[2];

        int min_offset = Integer.MAX_VALUE;
        int result = 0;
        for(int i=0; i<nums.length-2; i++){
            int j=i+1, k=len-1;
            while(j<k){
                int sum = nums[i]+nums[j]+nums[k];

                if(sum == target) {
                    return sum;
                }else if(sum > target){
                    k--;
                }else{
                    j++;
                }

                int offset = Math.abs(target-sum);
                if(offset<min_offset) {
                    min_offset = offset;
                    result = sum;
                }
            }
        }

        return result;
    }

}
