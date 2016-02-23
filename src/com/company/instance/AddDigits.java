package com.company.instance;

import com.company.support.Test;

/**
 * Created by yanba_000 on 11/15/2015.
 */
public class AddDigits implements Test{

    @Override
    public void execute() {
        int i = 12345;
        System.out.println(addDigits(i));
    }

    public int addDigits(int num) {
        if(num == 0)
            return 0;

        int re = num%9;

        return re==0?9:re;
        /*
        while(num > 9){
            int sum = 0;
            while(num != 0){
                sum += num%10;
                num /= 10;
            }
            num = sum;
        }

        return num;
        */
    }

}
