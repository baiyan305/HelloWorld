package com.company.instance;

import com.company.support.Test;

/**
 * Created by Yan on 4/5/15.
 */
public class DecodeWays implements Test {

    @Override
    public void execute() {
        System.out.println(numDecodings("110"));

    }

    public int numDecodings(String s) {
        boolean containsZero = false;
        int ways = 0;

        if(s.charAt(0) == '0') return 0;

        for(int i=1; i<s.length(); i++){
            if(s.charAt(i) == '0'){
                containsZero = true;
                if(Character.getNumericValue(s.charAt(i-1))>=1 && Character.getNumericValue(s.charAt(i-1))<=2) {
                    //System.out.println("way add at line 25.");
                    //ways++;
                }else {
                    return 0;
                }
            }else if(s.charAt(i-1)!= '0' && Integer.parseInt(s.substring(i-1,i+1)) <= 26) {
                System.out.println("way add at line 31.");
                ways++;
            }

        }

        return containsZero ? ways : ways+1;
    }

}
