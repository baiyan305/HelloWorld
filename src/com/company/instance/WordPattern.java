package com.company.instance;

import com.company.support.Test;

import java.util.HashMap;

/**
 * Created by yanba_000 on 11/13/2015.
 */
public class WordPattern implements Test{

    @Override
    public void execute() {
        String pattern = "abcdabcd";
        String str = "one two three four one two three four";

        wordPattern(pattern, str);
    }

    public boolean wordPattern(String pattern, String str) {

        if(pattern == null && str == null)
            return true;
        if(pattern == null || str == null)
            return false;

        StringBuilder builder1 = new StringBuilder();
        char[] arr = new char[122];
        char symbol = 'a';
        for(int i=0; i<pattern.length(); i++){
            char c = pattern.charAt(i);
            if(arr[c] == '\u0000')
                arr[c] = symbol++;

            builder1.append(arr[c]);
        }

        StringBuilder builder2 = new StringBuilder();
        HashMap<String, Character> map = new HashMap<>();
        symbol = 'a';
        String[] strs = str.split(" ");
        for(String s : strs){
            if(!map.containsKey(s))
                map.put(s, symbol++);

            builder2.append(map.get(s));
        }

        return builder1.toString().equals(builder2.toString());
    }

}
