package com.company.instance;

import com.company.support.Test;

/**
 * Created by yanba_000 on 11/15/2015.
 */
public class LengthLastWord implements Test{

    @Override
    public void execute() {
        String s = "   this is yan from China     ";

        int last = lengthOfLastWord(s);

        System.out.println(last);
    }

    public int lengthOfLastWord(String s) {
        if(s == null)
            return 0;

        int n = s.length()-1;
        int lastWordLen = 0;

        while(n>=0){
            if(s.charAt(n) != ' ') {
                lastWordLen++;
            }else{
                if(lastWordLen > 0)
                    break;
            }

            n--;
        }

        return lastWordLen;
    }

}
