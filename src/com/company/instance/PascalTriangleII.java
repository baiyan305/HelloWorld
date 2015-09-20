package com.company.instance;

import com.company.support.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Yan on 3/25/15.
 */
public class PascalTriangleII implements Test {

    @Override
    public void execute() {
        List<Integer> re = implement(10);

        System.out.println(re);
    }

    public List<Integer> implement(int rowIndex) {
        int[] triangle = new int[rowIndex+1];

        for(int outer=1; outer<=rowIndex; outer++){
            for(int inner=outer; inner>0; inner--){
                triangle[inner] = triangle[inner] + triangle[inner-1];
            }
        }

        List list = new ArrayList<Integer>(rowIndex+1);
        for(int i=0; i<triangle.length ; i++) list.add(triangle[i]);

        return list;
    }

}
