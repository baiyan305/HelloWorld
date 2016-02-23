package com.company.instance;

import com.company.support.Test;

/**
 * Created by yanba_000 on 11/26/2015.
 */
public class ContainerWithMostWater implements Test {

    @Override
    public void execute() {

    }

    public int maxArea(int[] height) {
        if(height == null || height.length<2)
            return 0;

        int area = 0, left = 0, right = height.length-1;

        while(left<right){
            int tmp = Math.min(height[left], height[right]) * (right-left);

            if(height[left] < height[right]){
                left++;
            }else if(height[right] < height[left]){
                right--;
            }else{
                left++;
                right--;
            }

            if(tmp > area)
                area = tmp;
        }

        return area;
    }

}
