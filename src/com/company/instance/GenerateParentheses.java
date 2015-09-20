package com.company.instance;

import com.company.support.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yan on 4/5/15.
 */
public class GenerateParentheses implements Test{

    int counter = 1;

    @Override
    public void execute() {
        List<String > list = generateParenthesis(3);

        System.out.println(list);
    }

    public List<String> generateParenthesis(int n) {
        List<String > result = new ArrayList<String>();

        if(n > 0) helper(result, "(", 1, 0, n);

        return result;
    }

    private void helper(List<String> list, String str, int numOfLeft, int numOfRight, int num){

        if(numOfLeft == num) {
            if(numOfRight == num) {
                list.add(str);
            }
            else
            {
                while(numOfRight<num){
                    str = str+")";
                    numOfRight++;
                }
                list.add(str);
            }
            return;
        }
        else
        {
            if(numOfLeft == numOfRight){
                helper(list, str+"(", numOfLeft+1, numOfRight, num);
            }
            else
            {
                helper(list, str+"(", numOfLeft+1, numOfRight, num);
                helper(list, str+")", numOfLeft, numOfRight+1, num);
            }
        }

    }

}
