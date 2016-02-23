package com.company.instance;

import java.util.*;
import java.util.LinkedList;

/**
 * Created by yanba_000 on 2/16/2016.
 */
public class WordLadder implements com.company.support.Test{

    @Override
    public void execute() {
        Set<String> wordList = new HashSet<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");

        System.out.print(ladderLength("hit", "cog", wordList));
    }

    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        int nodesOfThisLevel = 1, nodesOfNextLevel = 0, level = 0;

        while(!queue.isEmpty()){
            String word = queue.poll();
            nodesOfThisLevel--;

            for(int i=0; i<word.length(); i++){
                char[] arr = word.toCharArray();
                for(char c='a'; c<='z'; c++){
                    arr[i] = c;
                    String str = String.valueOf(arr);

                    if(str.equals(endWord)){
                        return level+2;
                    }

                    if(wordList.contains(str)){
                        queue.add(str);
                        nodesOfNextLevel++;
                        wordList.remove(str);
                    }
                }
            }

            if(nodesOfThisLevel == 0){
                nodesOfThisLevel = nodesOfNextLevel;
                nodesOfNextLevel = 0;
                level++;
            }

        }

        return 0;
    }


}
