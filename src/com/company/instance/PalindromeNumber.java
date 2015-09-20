package com.company.instance;

import com.company.support.Test;

/**
 * Created by Yan on 3/25/15.
 */
public class PalindromeNumber implements Test {

    @Override
    public void execute() {

        int num = 1;

        System.out.println(implement(num));

    }

    private boolean implement(int x){
        int length = 1, divisor = 1;
        for(int i=1; x/i>=10; i*=10) {
            length++;
            divisor*=10;
        }

        for(int j=0; j<length/2; j++){
            int left = x/divisor;
            int right = x%10;
            if(left != right) return false;
            x = (x - (left* divisor))/10;
            divisor /= 100;
        }

        return true;
    }

}
