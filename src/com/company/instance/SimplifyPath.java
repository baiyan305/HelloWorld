package com.company.instance;

import com.company.support.Test;

import java.util.Stack;

/**
 * Created by yanba_000 on 2/2/2016.
 */
public class SimplifyPath implements Test{

    @Override
    public void execute() {
        System.out.println(simplifyPath("/.."));
    }

    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<String>();
        String[] strs = path.split("/");

        for(String str : strs){
            if(str.equals("..")){
                if(!stack.isEmpty())
                    stack.pop();
            }else if(str.equals(".") || str.equals("")){
                continue;
            }else{
                stack.push(str);
            }
        }

        StringBuilder builder = new StringBuilder();

        while(!stack.isEmpty()){
            builder.insert(0, stack.pop());
            builder.insert(0, '/');
        }

        if(builder.length() == 0)
            builder.append('/');

        return builder.toString();
    }

}
