package com.company.instance;

import java.util.HashMap;

/**
 * Created by yanba_000 on 2/22/2016.
 */
public class FractionToRecurringDecimal implements com.company.support.Test {

    @Override
    public void execute() {
        System.out.println(fractionToDecimal(2,3));
    }

    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder builder = new StringBuilder();

        if((numerator<0 && denominator>0) || (numerator>0&&denominator<0))
            builder.append('-');

        long num = numerator, den = denominator;
        num = Math.abs(num);
        den = Math.abs(den);

        long quotient = num/den;
        builder.append(String.valueOf(quotient));

        long fraction = (num%den)*10;
        if(fraction == 0)
            return builder.toString();

        HashMap<Long, Integer> map = new HashMap<>();
        builder.append('.');
        while(fraction != 0){
            if(map.containsKey(fraction)){
                int begin = map.get(fraction);
                builder.insert(begin, '(');
                builder.append(')');
                return builder.toString();
            }

            map.put(fraction, builder.length());
            quotient = fraction/den;
            builder.append(String.valueOf(quotient));
            fraction = (fraction%den)*10;
        }

        return builder.toString();
    }

}
