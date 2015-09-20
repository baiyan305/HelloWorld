package com.company.instance;

import com.company.support.Test;

/**
 * Created by Yan on 3/31/15.
 */
public class JumpGame implements Test{

    @Override
    public void execute() {
        int[] arr = {3,2,1,0,4};
        boolean re = implement(arr);

        System.out.println(re);
    }

    private boolean implement(int A[]){

        int position = 0, last = A.length-1;

        while(position <= last){
            if(A[position] == 0 && position != last) return false;

            if(position + A[position] >= last) {
                return true;
            }else{
                int max = position + A[position];
                int newPosition = max;
                for(int i=position+1; i<=position + A[position]; i++){
                    if(i+A[i] > max) {
                        max = i+A[i];
                        newPosition = i;
                    }
                }

                position = newPosition;
            }

        }

        return false;
    }

}
