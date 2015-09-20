package com.company.instance;

import com.company.support.Test;

import java.util.Random;

/**
 * Created by Yan on 4/1/15.
 */
public class strStr implements Test {

    @Override
    public void execute() {
        System.out.println(strStr(new String("a"), new String("a")));
    }

    private int strStr(String haystack, String needle) {
        if(haystack == null || needle == null || needle.length() > haystack.length()) return -1;
        if(needle.length()==0) return 0;

        for(int i=0; i<haystack.length()-needle.length()+1; i++){
            if(haystack.charAt(i) == needle.charAt(0)){
                boolean same = true;
                int cur = i;
                for(int j=0; j<needle.length(); j++, cur++){
                    if(haystack.charAt(cur) != needle.charAt(j)){
                        same = false;
                        break;
                    }
                }

                if(same) return i;
            }
        }

        return -1;
    }

}
