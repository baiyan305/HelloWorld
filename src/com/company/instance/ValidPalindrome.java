package com.company.instance;

import com.company.support.Test;

/**
 * Created by Yan on 4/23/15.
 */
public class ValidPalindrome implements Test{

    @Override
    public void execute() {
        String str = "1a2";
        System.out.println(isPalindrome(str));
    }

    public boolean isPalindrome(String s) {
        if(s == null || s.length()<2) return true;

        int left=0, right=s.length()-1;

        while(left<right){
            char cLeft = Character.toLowerCase(s.charAt(left)), cRight = Character.toLowerCase(s.charAt(right));
            boolean bLeft = isAlphaNumeric(cLeft);
            boolean bRight = isAlphaNumeric(cRight);

            //both valid characters
            if(bLeft && bRight){
                if(cLeft != cRight) return false;

                left++;
                right--;
                continue;
            }

            if(!bLeft) left++;
            if(!bRight) right--;
        }

        return true;
    }

    private boolean isAlphaNumeric(char c){
        if ( (c>=97 && c<=122) || (c>=48 && c<=57)) return true;

        return false;
    }

}
