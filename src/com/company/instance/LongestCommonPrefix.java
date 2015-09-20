package com.company.instance;

import com.company.support.Test;

/**
 * Created by Yan on 4/22/15.
 */
public class LongestCommonPrefix implements Test{

    @Override
    public void execute() {
        String[] strs = {"abcdefg", "abcde" , "abc", "abcd"};
        longestCommonPrefix(strs);
    }

    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";

        return getPrefix(strs, strs[0], 1);
    }

    private String getPrefix(String[] strs, String prefix, int index){
        if(index == strs.length) return prefix;

        String str = strs[index];

        int len = prefix.length() < str.length() ? prefix.length():str.length();

        int lenOfPrefix = 0;
        for(int i=0; i<len; i++){
            if(prefix.charAt(i) == str.charAt(i)) lenOfPrefix++;
            else break;
        }

        return getPrefix(strs, prefix.substring(0, lenOfPrefix), index+1);
    }

}
