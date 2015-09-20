package com.company.instance;

import com.company.support.Test;

/**
 * Created by Yan on 4/1/15.
 */
public class FindPeakElement implements Test{

    @Override
    public void execute() {
        int[] arr = {1,2,3,8,5,3};
        System.out.println(findPeakElement(arr));
    }

    private int findPeakElement(int[] num) {

        int left = 0, right = num.length - 1;
        while(left<right){
            int mid = left + (right-left)/2;
            if(num[mid] < num[mid+1]){
                left = mid + 1;
            }else{
                right = mid;
            }
        }

        return left;

    }

}
