package com.company.instance;

import com.company.support.Test;

/**
 * Created by yanba_000 on 11/13/2015.
 */
public class MergeSortedArray implements Test{

    @Override
    public void execute() {
        int[] nums1={9,15,17,18,25,36,38,45,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,};
        int[] nums2={7,8,16,22,37,40,49,51,53,0,0,0,0,0,0,0,0};

        merge(nums1,8,nums2,9);

        for(int i: nums1)
            System.out.print(i+" ");
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        while(nums1==null&&nums2==null)
            return;

        int index = m + n - 1;
        m = m - 1;
        n = n - 1;

        while(m>=0 && n>=0){
            if(nums1[m] >= nums2[n])
                nums1[index--] = nums1[m--];
            else if(nums1[m] < nums2[n]){
                nums1[index--] = nums2[n--];
            }
        }

        while(m>=0)
            nums1[index--] = nums1[m--];
        while(n>=0)
            nums1[index--] = nums2[n--];
    }

}
