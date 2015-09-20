package com.company.instance;

import com.company.support.Test;


/**
 * Created by Yan on 4/5/15.
 */
public class CompareVersionNumber implements Test{

    @Override
    public void execute() {
        //System.out.println(compareVersion("13","1"));
        System.out.println(compareVersion("1.2.001.0","1.2"));
    }

    public int compareVersion(String version1, String version2) {
        if(version1 == null || version2 == null) return 0;

        String[] strs1 = version1.split("\\.");
        String[] strs2 = version2.split("\\.");

        int len = strs1.length <= strs2.length ? strs1.length:strs2.length;

        int i = 0;
        for(; i< (strs1.length <= strs2.length ? strs1.length:strs2.length); i++){
            if( Integer.parseInt(strs1[i]) > Integer.parseInt(strs2[i]) ) return 1;
            else if( Integer.parseInt(strs1[i]) < Integer.parseInt(strs2[i]) ) return -1;
        }

        if(strs1.length == strs2.length) {
            return 0;
        }
        else if(strs1.length > strs2.length) {
            for(;i<strs1.length;i++){
                if(Integer.parseInt(strs1[i])!=0)return 1;
            }
        } else {
            for(;i<strs2.length;i++){
                if(Integer.parseInt(strs2[i])!=0)return -1;
            }
        }

        return 0;
    }


}
