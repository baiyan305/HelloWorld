package com.company.instance;

import com.company.support.Test;

/**
 * Created by yanba_000 on 11/12/2015.
 */
public class StringToInteger implements Test{

    @Override
    public void execute() {
        System.out.println(myAtoi("9223372036854775809"));
    }

    public int myAtoi(String str) {
        if(str == null || str.length() == 0)
            return 0;

        str = str.trim();

        int flag = 0;
        int index=0;
        if(str.charAt(index) == '+'){
            flag = 1;
            index++;
        }else if(str.charAt(index) == '-'){
            flag = -1;
            index++;
        }

        double res = 0;
        while(index<str.length() && str.charAt(index) >= '0' && str.charAt(index) <= '9'){
            res = res*10 + Character.getNumericValue(str.charAt(index));
            System.out.println("11111111res="+res);
            index++;
        }

        System.out.println("res="+res);

        res = flag==0 ? res:res*flag;

        if(res > Integer.MAX_VALUE )
            return Integer.MAX_VALUE;
        if(res < Integer.MIN_VALUE )
            return Integer.MIN_VALUE;

        return (int)res;
    }

}
