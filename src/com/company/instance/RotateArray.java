package com.company.instance;

import com.company.support.Test;
/**
 * Created by Yan on 4/11/15.
 */
public class RotateArray implements Test{

    @Override
    public void execute() {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        rotate(arr, 3);

        System.out.println("123");
    }


    public void rotate(int[] nums, int k) {
        for(int i= nums.length-k-1; i>=0; i--){
            int cur = i, times = k;
            while(times > 0){
                int temp = nums[cur];
                nums[cur] = nums[cur+1];
                nums[cur+1] = temp;

                cur++;
                times--;
            }
        }
    }
    /*
    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length<2) return;

        if(k>nums.length) k = k% nums.length;

        reverseImpl(nums, 0, nums.length-1);
        reverseImpl(nums, 0, k-1);
        reverseImpl(nums, k, nums.length-1);
    }

    private void reverseImpl(int[] arr, int left, int right){
        while(left < right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
    }
    */
}
