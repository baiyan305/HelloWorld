package com.company.instance;

import com.company.support.Test;

/**
 * Created by yanba_000 on 11/7/2015.
 */
public class MinimumPathSum implements Test{

    @Override
    public void execute() {
        int[][] grid = {
                {1,2},
                {1,1}
        };

        int sum = minPathSum(grid);

        System.out.println(sum);
    }

    private int minPathSum(int[][] grid) {
        int col = grid.length, row = grid[0].length;
        int[][] dp = new int[col][row];
        dp[0][0] = grid[0][0];

        for(int r=1; r<row; r++)
            dp[0][r] = dp[0][r-1]+grid[0][r];

        for(int c=1; c<col; c++)
            dp[c][0] = dp[c-1][0]+grid[c][0];

        for(int i=1; i<col; i++){
            for(int j=1; j<row; j++){
                if(dp[i-1][j] >= dp[i][j-1])
                    dp[i][j] = dp[i][j-1] + grid[i][j];
                else
                    dp[i][j] = dp[i-1][j] + grid[i][j];
            }
        }

        return dp[col-1][row-1];
    }

}
