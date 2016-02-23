package com.company.instance;

/**
 * Created by yanba_000 on 2/17/2016.
 */
public class GasStation implements com.company.support.Test {

    @Override
    public void execute() {

    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas == null || cost == null || gas.length == 0 || cost.length == 0 || gas.length != cost.length)
            return -1;

        int total_diff = 0;
        int tmp_diff = 0;
        int start_station = 0;

        for(int i=0; i<gas.length; i++){
            int diff = gas[i] - cost[i];
            total_diff += diff;
            tmp_diff += diff;
            if(tmp_diff < 0){
                start_station = i+1;
                tmp_diff = 0;
            }
        }

        if(total_diff<0)
            return -1;
        else
            return start_station;
    }

}
