package com.company.instance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Yan on 3/20/15.
 */
public class Calculator {

    private List<String> result;
    private HashMap<Character, String> dict;

    public void test(String origin){

        List<String> result = new ArrayList<String>();
        HashMap<Character, String> dict = new HashMap<Character, String>();
        dict.put('2', "abc");
        dict.put('3', "def");
        dict.put('4', "gh");
        dict.put('5', "jkl");
        dict.put('6', "mno");
        dict.put('7', "pqrs");
        dict.put('8', "tuv");
        dict.put('9', "wxyz");

        combine(result, dict, new String(), origin, 0);

        System.out.println("aa");
    }

    private void combine(List<String> result, HashMap<Character, String> dict, String temp, String origin, int index){

        if(index > origin.length() -1) {
            result.add(temp);
            return;
        }

        String str = dict.get(origin.charAt(index));

        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            String temp1 = temp + ch;

            combine(result, dict, temp1, origin, index+1);
        }

    }


}
