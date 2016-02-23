package com.company.instance;

import com.company.support.Test;

/**
 * Created by yanba_000 on 11/5/2015.
 */
public class RomanToInteger implements Test{

    @Override
    public void execute() {
        String roman = "";
    }

    private int romanToInt(String s) {

        int num = 0;

        for(int i=s.length()-1; i>=0 ;i--){

            switch(s.charAt(i)){

                case 'I':
                    if(num >=5)
                        num += -1;
                    else
                        num += 1;
                    break;

                case 'V':
                    num += 5;
                    break;

                case 'X':
                    if(num >=50)
                        num += -10;
                    else
                        num += 10;
                    break;

                case 'L':
                    num += 50;
                    break;

                case 'C':
                    if(num >=500)
                        num += -100;
                    else
                        num += 100;
                    break;

                case 'D':
                    num += 500;
                    break;

                case 'M':
                    num += 1000;
                    break;
            }
        }

        return num;
    }

}
