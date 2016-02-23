package com.company.instance;

import com.company.support.Test;

/**
 * Created by yanba_000 on 11/8/2015.
 */
public class RotateImage implements Test{

    @Override
    public void execute() {
        int[][] matrix = {
                {1,2,3,4},
                {5,6,7,8},
                {-1,-2,-3,-4},
                {-5,-6,-7,-8}
        };

        rotate(matrix);

        for(int h=0; h<matrix.length; h++){
            for(int w=0; w<matrix[0].length; w++){
                //System.out.print(matrix[h][w]+"  ");
            }
            //System.out.println();
        }
    }

    public void rotate(int[][] matrix) {

        int length = matrix.length;

        for(int layer=0; layer<matrix.length/2; layer++){
            for(int offset=layer; offset<length-layer-1; offset++){
                //cache top
                int cache = matrix[layer][offset];

                //top = left
                matrix[layer][offset] = matrix[length-offset-1][layer];

                //left = bottom
                matrix[length-offset-1][layer] = matrix[length-layer-1][length-offset-1];

                //bottom = right
                matrix[length-layer-1][length-offset-1] = matrix[offset][length-layer-1];

                matrix[offset][length-layer-1] = cache;
            }
        }

    }

}
