package com.company.instance;

/**
 * Created by yanba_000 on 2/8/2016.
 */
public class UniqueBinarySearchTree implements com.company.support.Test{

    @Override
    public void execute() {

    }

    public int numTrees(int n) {
        int[] dp = new int[n+1];

        dp[0] = 1;
        dp[1] = 1;

        for(int i=2; i<=n; i++){
            for(int j=0; j<i; j++){
                dp[i] += dp[j] * dp[i-j-1];
            }
        }

        return dp[n];
    }

}
