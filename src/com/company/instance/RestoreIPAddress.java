package com.company.instance;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by yanba_000 on 2/7/2016.
 */
public class RestoreIPAddress implements com.company.support.Test {

    @Override
    public void execute() {
        List<String> list = restoreIpAddresses("25525511135");

        System.out.println(list);
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        StringBuilder builder = new StringBuilder();

        helper(0, 0, s, builder, res);

        return res;
    }


    private void helper(int pos, int level, String s, StringBuilder builder, List<String> res){

        if(level >= 4){
            if(pos>=s.length())
                res.add(builder.toString().substring(1));
            return;
        }

        for(int i=0; i<3; i++){
            if(pos+i>s.length()-1)
                return;

            String ipStr = s.substring(pos, pos+i+1);
            if(isValid(ipStr)){
                builder.append("."+ipStr);
                helper(pos+i+1, level+1, s, builder, res);
                for(int d=0; d<=i+1; d++){
                    builder.deleteCharAt(builder.length()-1);
                }
            }
        }

    }

    private boolean isValid(String str){
        if(str.startsWith("0") && str.length()>1 )
            return false;

        int ipInt = Integer.parseInt(str);
        if(ipInt>=0 && ipInt<=255)
            return true;
        else
            return false;
    }

}
