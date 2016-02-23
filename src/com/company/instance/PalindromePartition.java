package com.company.instance;

import java.util.*;
import java.util.LinkedList;

/**
 * Created by yanba_000 on 2/16/2016.
 */
public class PalindromePartition implements com.company.support.Test {

    @Override
    public void execute() {
        System.out.println(partition("abacc"));
    }

    public List<List<String>> partition(String s) {
        List<String> strList = new LinkedList<>();
        List<List<String>> res = new LinkedList<>();

        partitionImpl(s, strList, res, 0);

        return res;
    }

    private void partitionImpl(String s, List<String> strList, List<List<String>> res, int startIndex){

        if(startIndex == s.length()){
            res.add(new LinkedList<>(strList));
            return;
        }

        for(int i=startIndex;i<s.length(); i++){
            String sub = s.substring(startIndex, i+1);
            if(isPalindrome(sub)){
                strList.add(sub);
                partitionImpl(s, strList, res, i+1);
                strList.remove(strList.size()-1);
            }
        }

    }

    private boolean isPalindrome(String s){
        int left = 0, right = s.length()-1;

        while(left<right){
            if(s.charAt(left) == s.charAt(right)){
                left++;
                right--;
            }else{
                return false;
            }
        }

        return true;
    }

}
