package com.company.instance;

import java.util.Stack;

/**
 * Created by yanba_000 on 2/22/2016.
 */
public class VerifyPreorderSerialization implements com.company.support.Test {

    @Override
    public void execute() {
        System.out.println(isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
    }

    public boolean isValidSerialization(String preorder) {
        if(preorder == null || preorder.startsWith("#"))
            return false;


        String[] strs = preorder.split(",");
        Stack<String> stack = new Stack<>();
        for(String str : strs){
            while(stack.size() >= 2 && stack.peek().equals("#") && str.equals("#")){
                stack.pop();
                String top2 = stack.pop();
                if(top2.equals("#")){
                    return false;
                }
            }

            stack.push(str);
        }

        if(stack.size()==1 && stack.peek().equals("#"))
            return true;

        return false;
    }

}
