package com.company.instance;

import com.company.support.*;

/**
 * Created by Yan on 3/24/15.
 */
public class FirstMissingPositive implements com.company.support.Test {

    @Override
    public void execute() {
        int[] arr = {-1,4,2,1,9,10};
        System.out.println(implement(arr));
    }

    private int implement(int[] A) {

        for(int i=0; i<A.length; i++){
            if(A[i] >0 && A[i] <A.length && A[i] != A[A[i]-1]){
                int temp = A[i];
                A[i] = A[A[i]-1];
                A[temp-1] = temp;
                i--;
            }
        }

        for(int j=0; j<A.length; j++){
            if(j != A[j]-1) return j+1;
        }

        return A.length+1;
    }

}
