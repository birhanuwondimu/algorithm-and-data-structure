package com.mycompany.dynamicprogarming;

public class UnboundedKnapSack {
    public int solveKnapsack(int[] profits, int[] weights, int capacity) {
        int n = profits.length;

        int[][] dp = new int[n][capacity+1];
        for(int i =0;i<n;i++)
            dp[i][0] =0;



        for(int i =0;i<n;i++)
            for(int j =1;j<=capacity;j++){
                int include =0;
                int exclude =0;
                        if(j>=weights[i])
                            include= profits[i] +dp[i][j-weights[i]];
                        if(i>0)
                            exclude= dp[i-1][j];
                dp[i][j] = Math.max(include,exclude);
            }
        return dp[n-1][capacity];
       // return this.knapsackRecursive(profits, weights, capacity, 0);
    }
    private int knapsackRecursive(int[] profits, int[] weights,int capcity,int i){
        if(i==weights.length)
            return 0;

        int include =0;
        int exclude =0;

        if(capcity>=weights[i])
            include =  profits[i] + knapsackRecursive(profits,weights,capcity-weights[i],i);
        exclude =   knapsackRecursive(profits,weights,capcity,i+1);
        return Math.max(include,exclude);

    }



    public int coinChange(int[] coins, int amount) {
 return this.coinChangeRec(coins,amount,0);
    }

    public int coinChangeRec(int[] coins, int amount,int i) {
        if(i==coins.length || amount<=0)
            return 0;

        int include =Integer.MAX_VALUE;
        if(coins[i]<amount)
            include = 1+ coinChangeRec(coins,amount-coins[i],i);


        int exclude =coinChangeRec(coins,amount,i+1);

        return  Math.max(include,exclude);
    }

    public static void main(String[] args) {
        UnboundedKnapSack ks = new UnboundedKnapSack();

        //Input: coins = [1, 2, 5], amount = 11
        int[]profit = {1,2,5};
        int maxProfit = ks.coinChange(profit, 11);
        System.out.println(maxProfit);
    }
}
