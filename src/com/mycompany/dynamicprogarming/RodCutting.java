package com.mycompany.dynamicprogarming;
import  java.util.*;
public class RodCutting {
    public int solveRodCutting(int[] lengths, int[] prices, int n) {
       int[][] memo = new int[lengths.length][n+1];
        return solveRodCuttingRec(memo,lengths,prices,n,0);
    }
    public int solveRodCuttingRec(int[][] memo,int[] lengths, int[] prices, int n,int i) {
        if(n<=0 || lengths.length==0 || lengths.length!= prices.length || i>=prices.length)
            return 0;
        int profit1 =0;
        if(memo[i][n]==0) {
            if (lengths[i] <= n)
                profit1 = prices[i] + solveRodCuttingRec(memo, lengths, prices, n - lengths[i], i);
            int profit2 = solveRodCuttingRec(memo, lengths, prices, n, i + 1);
            memo[i][n] = Math.max(profit1,profit2);
        }
        return memo[i][n];
    }

    public int solveRodCuttingDp(int[] lengths, int[] prices, int n){
        int len = lengths.length;
        int[][]dp = new int[len][n+1];
        for(int i =0;i<len;i++)
            dp[i][0] = 0;
        for(int i =0;i<len;i++)
            for(int c =1;c<=n;c++){
                int profit1 =0;
                int profit2 =0;
                if(lengths[i]<=c){
                    profit1 = prices[i] + dp[i][c-lengths[i]];
                }
                if(i>0)
                 profit2 = dp[i-1][c];
                dp[i][c] = Math.max(profit1,profit2);
            }
        int profit = dp[len-1][n];
            int ans = profit;
        List<Integer> selection = new java.util.ArrayList<>();
        int i= len-1;
            while(i>=0) {
                if(i==0){
                    if(profit != 0)
                        selection.add(lengths[0]);
                    break;
                }
                else if (profit != dp[i - 1][n]) {
                    selection.add(lengths[i]);
                    n = n - lengths[i];
                    profit = profit - prices[i];
                }
                else
                    i--;
            }
           selection.forEach(a->System.out.println(a));
        return  ans;
    }

    public static void main(String[] args) {
        RodCutting rc = new RodCutting();
        int[] lengths = {1, 2, 3, 4, 5};
        int[] prices = {2, 6, 7, 10, 13};
        int maxProfit = rc.solveRodCuttingDp(lengths, prices, 5);

        System.out.println(maxProfit);
    }
}
