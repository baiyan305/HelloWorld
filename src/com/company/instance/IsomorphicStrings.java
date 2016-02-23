package com.company.instance;

import com.company.support.Test;

/**
 * Created by yanba_000 on 11/8/2015.
 */
public class IsomorphicStrings implements Test{

    @Override
    public void execute() {
        System.out.println(isIsomorphic("paper","title"));
    }

    public boolean isIsomorphic(String s, String t) {

        if(helper(s).equals(helper(t)) )
            return true;
        else
            return false;
    }

    private String helper(String str){
        int[] dict = new int[256];
        int index = 0;
        StringBuilder builder = new StringBuilder();

        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            if(dict[c] == 0){
                builder.append(++index);
                dict[c] = index;
            }
            else
                builder.append(dict[c]);
        }

        return builder.toString();
    }

}
