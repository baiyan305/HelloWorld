package com.company.instance;

import com.company.support.*;

import java.util.HashMap;

/**
 * Created by Yan on 3/24/15.
 */
public class LongestConsecutiveSequence implements com.company.support.Test {

    @Override
    public void execute() {
        int[] arr = {100, 4, 200, 1, 3, 2};
        System.out.println(implement(arr));
    }

    private int implement(int[] num){
        int longest = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(int i=0; i<num.length; i++){
            if(!map.containsKey(num[i])){
                int left = map.containsKey(num[i]-1) ? map.get(num[i]-1) : 0;
                int right = map.containsKey(num[i]+1) ? map.get(num[i]+1) : 0;

                int sum = left+right+1;
                map.put(num[i], sum);
                longest = Math.max(longest, sum);


                map.put(num[i]-left, sum);
                map.put(num[i]+right, sum);
            }
        }

        return longest;
    }

}
