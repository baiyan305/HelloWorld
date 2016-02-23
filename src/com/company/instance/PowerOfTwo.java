package com.company.instance;

import com.company.support.Test;

/**
 * Created by yanba_000 on 11/22/2015.
 */
public class PowerOfTwo implements Test{

    @Override
    public void execute() {

        int num = 1;

        for(int i=0; i<30; i++){
            num *= 2;
            System.out.println(num);
        }

    }

    public boolean isPowerOfTwo(int n) {
        int num = 1;

        while(num <= Integer.MAX_VALUE && num < n){
            if(num == n)
                return true;
            num *= 2;
        }

        return false;
    }

}
