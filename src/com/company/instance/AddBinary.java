package com.company.instance;

import com.company.support.Test;

/**
 * Created by yanba_000 on 11/15/2015.
 */
public class AddBinary implements Test{

    @Override
    public void execute() {
        String a = "11110";
        String b = "11";

        addBinary(a, b);
    }

    public String addBinary(String a, String b) {
        if(a==null&b==null)
            return null;
        if(a==null || b ==null)
            return a+b;

        StringBuilder sum = new StringBuilder();

        int pa = a.length()-1, pb = b.length()-1;
        int flag = 0;

        while(pa>=0 || pb>=0){
            int num = flag;
            if(pa>=0)
                num += a.charAt(pa)-48;
            if(pb>=0)
                num += b.charAt(pb)-48;
            switch(num){
                case 0:
                    sum.append('0');
                    break;
                case 1:
                    sum.append('1');
                    flag = 0;
                    break;
                case 2:
                    sum.append('0');
                    flag = 1;
                    break;
                case 3:
                    sum.append('1');
                    flag = 1;
                    break;
            }

            pa--;
            pb--;
        }

        /*
        while(pa >= 0){
            int num = (a.charAt(pa)-48) + flag;
            switch(num){
                case 0:
                    sum.append('0');
                    break;
                case 1:
                    sum.append('1');
                    flag = 0;
                    break;
                case 2:
                    sum.append('0');
                    flag = 1;
                    break;
            }

            pa--;
        }

        while(pb >= 0){
            int num = (b.charAt(pb)-48) + flag;
            switch(num){
                case 0:
                    sum.append('0');
                    break;
                case 1:
                    sum.append('1');
                    flag = 0;
                    break;
                case 2:
                    sum.append('0');
                    flag = 1;
                    break;
            }

            pb--;
        }
        */
        if(flag == 1)
            sum.append('1');

        return sum.reverse().toString();
    }

}
