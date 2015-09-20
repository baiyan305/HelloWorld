package com.company.instance;

import com.company.support.Test;

/**
 * Created by Yan on 4/11/15.
 */
public class ReverseBits implements Test{

    @Override
    public void execute() {
        int n = 1;

        //System.out.println(Integer.toBinaryString(n));

        reverseBits(n);
    }

    public int reverseBits(int n) {
        int res = 0;

        for(int i=0; i<32; i++){
            res = (res<<1) + (n&1);
            n = n>>1;
        }

        return res;
    }

}
