package com.company.instance;

import com.company.support.Test;

/**
 * Created by yanba_000 on 11/11/2015.
 */
public class ReverseInteger implements Test{

    @Override
    public void execute() {

        System.out.println("1 1".trim());

    }

    private int reverse(int x) {
        long res = 0;

        while(x != 0){
            int digit = x%10;
            res = res*10 + digit;
            x /= 10;
        }

        if(res > Integer.MAX_VALUE || res < Integer.MIN_VALUE)
            return 0;
        else
            return (int)res;
    }

}
