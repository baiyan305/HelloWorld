package com.company.instance;

import com.company.support.Test;

/**
 * Created by yanba_000 on 11/16/2015.
 */
public class ExcelSheetColumnNumber implements Test{

    @Override
    public void execute() {
        titleToNumber("");
    }

    public int titleToNumber(String s) {
        if(s==null)
            return 0;

        int num = 0, times=0;

        for(int i=s.length()-1; i>=0; i--){
            int digit = s.charAt(i)-'A'+1;
            num += digit * Math.pow(26,times++);
        }

        System.out.println(num);

        return num;
    }

}
