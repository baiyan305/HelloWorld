package com.company.instance;

import com.company.support.Test;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by Yan on 3/25/15.
 */
public class PascalTriangle implements Test {
    @Override
    public void execute() {
        List<List<Integer>> triangle = generate(5);
        System.out.println(triangle);
    }

    private List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>(numRows);

        int[] arr = new int[numRows];
        arr[0] = 1;
        List<Integer> first = new ArrayList<Integer>();
        first.add(1);
        triangle.add(first);

        for(int outer=1; outer<numRows; outer++){

            for(int inner = outer; inner>0; inner--){
                arr[inner] = arr[inner] + arr[inner-1];
            }

            List<Integer> row = new ArrayList<Integer>(outer+1);
            int index=0;
            while(index<numRows && arr[index]>0){
                row.add(arr[index]);
                index++;
            }

            triangle.add(row);
        }

        return triangle;
    }

}
