package com.company.instance;

/**
 * Created by yanba_000 on 2/11/2016.
 */
public class BestTimeToBuyAndSellStockTwo implements com.company.support.Test{

    @Override
    public void execute() {
        int[] prices = {5,5,4,9,3,8,5,5,1,6,8,3,4};

        System.out.print(maxProfit(prices));
    }

    public int maxProfit(int[] prices) {

        int amount = 0;
        int i = 1;

        while(i<prices.length){

            //buy time, descent
            while(i<prices.length && prices[i] <= prices[i-1]){
                i++;
            }
            int buytime = i-1;

            //sell time, ascent
            while(i<prices.length && prices[i] >= prices[i-1]){
                i++;
            }
            int selltime = i-1;

            amount += prices[selltime] - prices[buytime];
        }

        return amount;
        /*
        int amount = 0;
        int buytime = 0;

        for(int i=1; i<prices.length; i++){


            //last one
            if(i == prices.length-1){
                if(prices[i-1]<=prices[i]){
                    int profit = prices[i] - prices[buytime];
                    if(profit > 0)
                        amount += profit;
                }

                continue;
            }

            //buy time
            if(prices[i-1]>=prices[i] && prices[i] < prices[i+1]){
                System.out.println("buy at time"+i);
                buytime = i;
            }

            //sell time
            if(prices[i-1]<=prices[i] && prices[i] > prices[i+1]){
                System.out.println("sell at time"+i);
                int profit = prices[i] - prices[buytime];
                if(profit > 0)
                    amount += profit;
            }

        }

        return amount;
        */
    }

}
