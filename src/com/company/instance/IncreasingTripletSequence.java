package com.company.instance;

/**
 * Created by yanba_000 on 2/20/2016.
 */
public class IncreasingTripletSequence implements com.company.support.Test {

    @Override
    public void execute() {
        System.out.print(increasingTriplet(new int[]{1,2,1,1}));
    }

    public boolean increasingTriplet(int[] nums) {
        if(nums == null || nums.length<3)
            return false;

        //initialize 1 and 2
        int num1 = nums[0], num2 = 0;
        int i= 1;
        for(; i<nums.length; i++){
            if(nums[i] <= num1) {
                num1 = nums[i];
            }else {
                num2 = nums[i];
                break;
            }
        }

        while(i<nums.length){
            if(nums[i] > num2)
                return true;
            else if(nums[i] <= num1)
                num1 = nums[i];
            else if(nums[i] <= num2)
                num2 = nums[i];

            i++;
        }

        return false;
    }

}
