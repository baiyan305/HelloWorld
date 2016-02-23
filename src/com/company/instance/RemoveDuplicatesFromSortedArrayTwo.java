package com.company.instance;

/**
 * Created by yanba_000 on 2/4/2016.
 */
public class RemoveDuplicatesFromSortedArrayTwo implements com.company.support.Test{

    @Override
    public void execute() {
        int[] nums = {1,1,1,1,1,1,1,2,2,2,3,3,4,5,6,6,6,};

        int len = removeDuplicates(nums);

        System.out.println(len);
    }

    public int removeDuplicates(int[] nums) {

        int steps = 0, counter = 1;

        for(int i=1; i<nums.length; i++){

            if(nums[i] == nums[i-1]){
                counter++;
                if(counter > 2){
                    steps++;
                }
            }else{
                counter = 1;
            }

            if(steps > 0 && counter <=2){
                nums[i-steps] = nums[i];
            }

        }

        return nums.length-steps;
    }

}
