package com.company.instance;

import com.company.support.Test;

/**
 * Created by yanba_000 on 11/6/2015.
 */
public class IntegerToRoman implements Test{

    @Override
    public void execute() {
        System.out.println(intToRoman(3999));
    }

    private String intToRoman(int num) {
        char[] symbols = {'M','C','D','X','L','I','V'}; //1000, 100, 500, 10, 50, 1, 5
        StringBuilder builder = new StringBuilder();

        int divisor = 1000;
        for(int i=0; i<4; i++){
            int digit = num/divisor;

            if(digit > 0){
                if(i == 0){
                    for(int loop=0; loop<digit; loop++)
                        builder.append(symbols[0]);
                }else{
                    if(digit <=3){
                        for(int loop=0; loop<digit; loop++)
                            builder.append(symbols[i*2-1]);
                    }else if(digit == 4){
                        builder.append(symbols[i*2-1]);
                        builder.append(symbols[i*2]);
                    }else if(digit == 5){
                        builder.append(symbols[i*2]);
                    }else if(digit>5&&digit<9){
                        builder.append(symbols[i*2]);
                        for(int loop=0; loop<digit-5; loop++)
                            builder.append(symbols[i*2-1]);
                    }else if(digit == 9){
                        builder.append(symbols[i*2-1]);
                        if(i == 3)
                            builder.append(symbols[i]);
                        else
                            builder.append(symbols[i-1]);
                    }
                }
            }

            num -= digit * divisor;
            divisor = divisor / 10;
        }

        return builder.toString();
    }

}
