package com.company.instance;

import com.company.support.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Yan on 4/12/15.
 */
public class LargestNumber implements Test{

    @Override
    public void execute() {
        int[] arr = {0,0};
        largestNumber(arr);
    }


    public String largestNumber(int[] num) {
        String[] str = new String[num.length];
        for(int i=0; i<=num.length-1; i++){
            str[i] = String.valueOf(num[i]);
        }

        Arrays.sort(str, new Comparator<String>(){
            @Override
            public int compare(String left, String right) {
                String leftRight = left.concat(right);
                String rightLeft = right.concat(left);

                return leftRight.compareTo(rightLeft);
            }
        });

        if(str[str.length-1].compareTo("0") == 0) return "0";

        StringBuilder builder = new StringBuilder();
        for(int i=str.length-1;i>=0;i--){
            builder.append(str[i]);
        }

        return builder.toString();
    }

}
