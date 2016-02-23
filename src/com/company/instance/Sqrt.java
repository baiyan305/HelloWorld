package com.company.instance;

import com.company.support.Test;

/**
 * Created by yanba_000 on 2/3/2016.
 */
public class Sqrt implements Test{

    @Override
    public void execute() {
        //System.out.println(Long.MAX_VALUE);
        //System.out.println(1073741823 * 1073741823);
        System.out.println(mySqrt(2147483647));
    }

    public int mySqrt(int x) {

        long low = 0, high = x/2+1;

        while(low<=high){
            long mid = low+(high-low)/2;
            long square = mid * mid;
            if(square == x)
                return (int)mid;
            else if(square > x)
                high = mid -1;
            else
                low = mid + 1;
        }

        return (int)high;
    }

}
