package com.company.instance;

import com.company.support.Test;

/**
 * Created by yanba_000 on 11/15/2015.
 */
public class ExcelSheetColumnTitle implements Test{

    @Override
    public void execute() {
        StringBuilder builder = new StringBuilder();

        System.out.println(builder.toString());
    }

    public String convertToTitle(int n) {
        StringBuilder builder = new StringBuilder();

        while(n>0){
            int digit = n%26;
            n = n/26;
            if(digit == 0){
                builder.insert(0, 'Z');
                n--;
            }else{
                builder.insert(0, (char)('A'+digit-1));
            }
        }

        return builder.toString();
    }

}
