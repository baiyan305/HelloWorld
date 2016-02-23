package com.company.instance;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yanba_000 on 2/17/2016.
 */
public class WordBreak implements com.company.support.Test {

    @Override
    public void execute() {
        Set<String> set = new HashSet<>();
        set.add("le");
        set.add("leet");
        set.add("code");

        System.out.println(wordBreak("leetcode", set));
    }

    public boolean wordBreak(String s, Set<String> wordDict) {
        return wordBreakImpl(s, wordDict, 0);
    }

    private boolean wordBreakImpl(String s, Set<String> wordDict, int index){
        if(index == s.length())
            return true;

        for(String word : wordDict){
            int len = word.length();
            if(index+len>s.length())
                continue;

            if(s.substring(index, index+len).equals(word)){
                if(wordBreakImpl(s, wordDict, index+len))
                    return true;
            }

        }

        return false;
    }

}
