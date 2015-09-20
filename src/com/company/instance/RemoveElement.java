package com.company.instance;


/**
 * Created by Yan on 6/25/15.
 */
public class RemoveElement implements com.company.support.Test {

    @Override
    public void execute() {
        int[] nums = {9, 5, 11, 3, 7, 6, 6, 250, 6, 13, 108, 95, 6, 2, 1, 6};

        System.out.println(removeElement(nums, 6));
    }

    public int removeElement(int[] nums, int val) {
        if(nums.length == 0) return 0;

        int occurence = 0;

        for(int i=0; i<nums.length; i++){
            if(nums[i] == val){
                occurence++;
            }else{
                nums[i-occurence] = nums[i];
            }
        }

        for(int i=nums.length-1; i>nums.length-1-occurence; i--){
            nums[i] = -1;
        }

        return nums.length - occurence;
    }

}
