package com.company.instance;

import com.company.support.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Yan on 4/11/15.
 */
public class RepeatedDNA implements Test{

    @Override
    public void execute() {
        String str = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        findRepeatedDnaSequences(str);

        System.out.println("123");
    }

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> list = new ArrayList<String>();
        if(s == null || s.length()<10) return list;

        Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        for(int i=0; i<= s.length()-10; i++){
            String substr = s.substring(i, i + 10);
            int sub = str2Int(substr);
            if(!map.containsKey(sub)) map.put(sub, true);
            else if(!list.contains(substr))list.add(substr);
        }

        return list;
    }

    private static int str2Int(String str){
        int res = 0;

        for(int i=0; i<str.length(); i++){
            res = res<<2 | getDigits(str.charAt(i));
        }

        return res;
    }

    private static int getDigits(char c){
        switch (c){
            case 'A' : return 0;
            case 'C' : return 1;
            case 'G' : return 2;
            case 'T' : return 3;
            default  : return 4;
        }
    }

}
