package com.company.instance;

import com.company.support.Test;

import java.util.*;

/**
 * Created by Yan on 4/23/15.
 */
public class Anagrams implements Test{

    @Override
    public void execute() {
        String[] strs = {"", ""};
        //System.out.println(anagrams(strs));
    }

    public List<String> anagrams(String[] strs) {
        List<String> result = new ArrayList<String>();
        if(strs == null || strs.length <2) return result;

        HashMap<String, java.util.LinkedList<String>> map = new HashMap<String, java.util.LinkedList<String>>();

        for(int i=0; i<strs.length; i++){
            String count = wordCount(strs[i]);
            if(map.get(count) == null){
                java.util.LinkedList<String> list = new java.util.LinkedList<String>();
                list.add(strs[i]);
                map.put(count, list);
            }else{
                map.get(count).add(strs[i]);
            }
        }

        for(Map.Entry<String, java.util.LinkedList<String>> entry : map.entrySet()){
            java.util.LinkedList<String> values = entry.getValue();
            if(values.size()>1){
                for(String s : values) result.add(s);
            }
        }

        return result;
    }

    private String wordCount(String str){
        if(str.length() == 0) return "empty";

        StringBuilder builder = new StringBuilder();
        int[] counts = new int[26];

        for(int i=str.length()-1; i>=0;i--) {
            counts[str.charAt(i)-97]++;
        }

        for(int i=0; i<counts.length; i++){
            if(counts[i]>0)builder.append(String.valueOf(Character.toChars(i+97)[0])+counts[i]);
        }

        return builder.toString();
    }
}
