package com.company.instance;

import com.company.support.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.HashMap;
import java.util.Map.Entry;

/**
 * Created by Yan on 4/4/15.
 */
public class ConcatenationfOfWords implements Test {

    @Override
    public void execute() {
        String str = "barfoothefoobarman";
        String[] L = {"bar", "foo"};

        findSubstring(str, L);
    }

    private List<Integer> findSubstring(String S, String[] L) {
        List<Integer> list = new ArrayList<Integer>();

        if(S == null || S.length() == 0 || L == null) return list;

        int len = L[0].length() * L.length;
        if(S.length() < len) return list;


        HashMap<String, Integer> map = new HashMap<String, Integer>();

        for(int i=0; i<L.length; i++){
            if(!map.containsKey(L[i])) map.put(L[i], 1);
            else map.put(L[i], map.get(L[i])+1);
        }

        for(int i=0; i<S.length()-len+1; i++){
            if(helper( S.substring(i, i+len), L[0].length(), map)) list.add(i);
        }

        return list;
    }

    private boolean helper(String str, int len, HashMap<String, Integer> map){
        HashMap<String, Integer> temp = new HashMap<String, Integer>();
        temp.putAll(map);
        String word;

        for(int i=0; i<str.length(); i=i+len){
            word = str.substring(i, i+len);
            if(temp.containsKey(word)) temp.put(word, temp.get(word)-1);
        }

        for(Entry<String, Integer> entry : temp.entrySet()){
            if(entry.getValue() != 0) return false;
        }

        return true;
    }


}
