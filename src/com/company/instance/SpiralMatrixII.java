package com.company.instance;

import com.company.support.*;

/**
 * Created by Yan on 3/21/15.
 */
public class SpiralMatrixII implements com.company.support.Test{

    @Override
    public void execute(){
        int[][] result = generateMatrix(5);
        showMatrix(result, 5);
        System.out.println("Done");
    }

    private int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int num = 1;

        for(int layer=0; layer< n/2 ;layer++){
            int first = layer;
            int last = n-1-layer;

            //top
            for(int i=first; i<=last; i++){
                matrix[first][i] = num;
                num++;
            }

            //right
            for(int j=first+1; j<=last; j++){
                matrix[j][last] = num;
                num++;
            }

            //bottom
            for(int m=last-1; m>=first; m--){
                matrix[last][m] = num;
                num++;
            }

            //bottom
            for(int k=last-1; k>=first+1; k--){
                matrix[k][first] = num;
                num++;
            }

        }

        if(n%2 != 0){
            int center = (n/2);
            matrix[center][center] = num;
        }

        return matrix;
    }

    private void showMatrix(int[][] matrix, int length){
        for(int i=0; i<length; i++){
            for(int j=0; j<length; j++){
                System.out.print(matrix[i][j]+"   ");
            }
            System.out.println();
        }
    }


}
