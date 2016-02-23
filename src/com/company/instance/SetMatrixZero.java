package com.company.instance;

import com.company.support.Test;

/**
 * Created by yanba_000 on 11/13/2015.
 */
public class SetMatrixZero implements Test{

    @Override
    public void execute() {
        int[][] matrix = {
                {0,0,0,5},
                {4,3,1,4},
                {0,1,1,4},
                {1,2,1,3},
                {0,0,1,1}
        };

        setZeroes(matrix);
        System.out.println();
        System.out.println();
        print(matrix);
    }

    public void setZeroes(int[][] matrix) {
        boolean firstRowZero = false, firstColumnZero = false;

        //check first row
        for(int c=0; c<matrix[0].length; c++){
            if(matrix[0][c] == 0){
                firstRowZero = true;
                break;
            }
        }

        //check first column
        for(int r=0; r<matrix.length; r++){
            if(matrix[r][0] == 0){
                firstColumnZero = true;
                break;
            }
        }

        //check left part of matrix
        for(int row=1; row<matrix.length; row++){
            for(int col=1; col<matrix[0].length; col++){
                if(matrix[row][col] == 0){
                    matrix[0][col] = 0;
                    matrix[row][0] = 0;
                }
            }
        }

        print(matrix);

        //check first row
        for(int c=1; c<matrix[0].length; c++){
            if(matrix[0][c] == 0){
                for(int r=1; r<matrix.length; r++){
                    matrix[r][c] = 0;
                }
            }
        }

        //check first column
        for(int r=1; r<matrix.length; r++){
            if(matrix[r][0] == 0){
                for(int c=1; c<matrix[0].length; c++){
                    matrix[r][c] = 0;
                }
            }
        }

        if(firstRowZero){
            for(int col=0; col<matrix[0].length; col++)
                matrix[0][col]=0;
        }
        if(firstColumnZero){
            for(int row=0; row<matrix.length; row++)
                matrix[row][0]=0;
        }

    }


    void print(int[][] matrix){
        for(int row=0; row<matrix.length; row++){
            for(int col=0; col<matrix[0].length; col++){
                System.out.print(matrix[row][col]+" ");
            }
            System.out.println();
        }
    }

}
