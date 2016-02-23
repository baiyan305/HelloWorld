package com.company.instance;

import com.company.support.Test;

/**
 * Created by yanba_000 on 11/22/2015.
 */
public class Search2DMatrix implements Test{

    @Override
    public void execute() {
        int[][] matrix = {
                {3,7,12,15,19},
                {30,39,41,44,47},
                {55,56,57,62,68},
                {75,77,79,83,86}
        };

        searchMatrix(matrix, 86);
    }

    public boolean searchMatrix(int[][] matrix, int target) {

        int min=0, max=matrix.length-1;
        while(min<max){
            int mid = min+(max-min)/2;
            if(target == matrix[mid][0])
                return true;
            if(target < matrix[mid][0])
                max=mid-1;
            else{
                if(target <= matrix[mid][matrix[0].length-1]) {
                    min = mid;
                    break;
                }else{
                    min = mid+1;
                }
            }

        }

        System.out.println("Possible row: "+ (min+1));

        int row = min;
        min = 0;
        max = matrix[0].length-1;
        while(min<=max){
            int mid=min+((max-min)/2);
            if(target == matrix[row][mid])
                return true;
            else if(target<matrix[row][mid])
                max = mid -1;
            else
                min = mid + 1;
        }

        System.out.println("target NOT FOUND");

        return false;
        //int row = min;
        //min = 0;
        //max = matrix[0].length;
        //while()


    }

}
