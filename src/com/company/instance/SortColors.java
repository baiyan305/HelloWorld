package com.company.instance;

/**
 * Created by Yan on 9/4/15.
 */
public class SortColors implements com.company.support.Test {


    @Override
    public void execute() {
        int[] nums = {1,1,2,0,1};
        for(int i=0; i<nums.length; i++){
            System.out.println(nums[i]);
        }
        System.out.println();
        sortColors(nums);
        for(int i=0; i<nums.length; i++){
            System.out.println(nums[i]);
        }

    }

    public void sortColors(int[] nums) {

        int redIndex = 0, blueIndex = nums.length-1, i = 0, temp=0;

        while(i<blueIndex+1){
            switch(nums[i]){
                case 0:
                    System.out.println("case 0");

                    nums[i] = nums[redIndex];
                    nums[redIndex] = 0;
                    redIndex++;
                    i++;
                    break;
                case 1:
                    System.out.println("case 1");

                    i++;
                    break;
                case 2:
                    System.out.println("case 2");

                    nums[i] = nums[blueIndex];
                    nums[blueIndex] = 2;
                    blueIndex--;
                    break;
            }
        }

    }

}
