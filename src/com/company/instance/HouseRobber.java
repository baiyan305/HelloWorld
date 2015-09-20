package com.company.instance;

import com.company.support.Test;

/**
 * Created by Yan on 4/10/15.
 */
public class HouseRobber implements Test {

    @Override
    public void execute() {
        int[] num = {1,2,1,1,1,1,2,1};

        int money = rob(num);
        System.out.println(money);
    }

    public int rob(int[] num) {
        if(num == null || num.length == 0) return 0;
        if(num.length == 1) return num[0];
        if(num.length == 2) return num[0]>=num[1] ? num[0] : num[1];

        int[] max = new int[num.length];
        max[0] = num[0];
        max[1] = num[0]>=num[1] ? num[0] : num[1];

        for(int i=2; i<num.length; i++){
            max[i] = Math.max(max[i-2]+num[i], max[i-1]);
        }

        return max[max.length-1];
    }

}
