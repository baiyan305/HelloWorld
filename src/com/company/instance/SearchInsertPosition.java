package com.company.instance;

import com.company.support.Test;

/**
 * Created by yanba_000 on 11/24/2015.
 */
public class SearchInsertPosition implements Test{

    @Override
    public void execute() {
        int[] arr = {1,3,5,6};

        System.out.println(searchInsert(arr,0));
    }

    public int searchInsert(int[] nums, int target) {
        int min=0, max= nums.length-1;

        while(min<=max){
            int mid = min+((max-min)/2);
            if(target<nums[mid])
                max=mid-1;
            else if(target>nums[mid])
                min=mid+1;
            else
                return mid;
        }

        /*
        if(max<0)
            return 0;
        if(min> nums.length-1)
            return nums.length;
        */
        return min;
    }

}
