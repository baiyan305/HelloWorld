package com.company.instance;

import com.company.support.Test;

/**
 * Created by Yan on 4/10/15.
 */
public class NumberOf1Bit implements Test {

    @Override
    public void execute() {
        //System.out.println(hammingWeight(65000));
        //System.out.println(Integer.toBinaryString(120));
        //System.out.println(Integer.toBinaryString(119));
        //System.out.println(Integer.toBinaryString(120&119));

        // System.out.println(Integer.toBinaryString(2147483647));
        //System.out.println(Integer.MAX_VALUE);

        System.out.println(hammingWeigh(100));
    }

    public int hammingWeigh(int n) {
        /*
        int count = 0;

        for(int i=0; i<32; i++){
            count = count + (n&1);
            n = n>>1;
        }

        return count;
        */
        int count = 0;
        while(n>0)
        {
                count ++;
            System.out.println(Integer.toBinaryString(n));

            n = n & (n-1);

        }

        return count;
    }
}
