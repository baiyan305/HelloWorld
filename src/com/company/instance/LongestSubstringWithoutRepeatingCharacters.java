package com.company.instance;

import com.company.support.Test;

import java.util.HashMap;

/**
 * Created by yanba_000 on 11/26/2015.
 */
public class LongestSubstringWithoutRepeatingCharacters implements Test{

    @Override
    public void execute() {
        HashMap<Character, Integer> map = new HashMap<>();

        String s = "a";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public int lengthOfLongestSubstring(String s) {
        if(s == null)
            return 0;

        int longest = 0, start = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        int i=0;
        for(; i<s.length(); i++){
            char ch = s.charAt(i);
            if(map.get(ch) != null && map.get(ch) >= start){
                int len = i-start;
                if(len > longest)
                    longest = len;
                start = map.get(ch)+1;
            }

            map.put(ch, i);
        }//end of 'for' loop

        if(i-start > longest)
            longest = i-start;
        return longest;
    }//end of method 'lengthOfLongestSubstring'

}//end of class 'LongestSubstringWithoutRepeatingCharacters'
