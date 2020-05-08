package com.mycompany.dynamicprogarming;

public class CoinChange {
    public int countChange(int[] denominations, int total) {
        int n = denominations.length;
        int[][] memo = new int[n][total+1];
    return countChangeRec(memo,denominations,total,0);
    }

    public int countChangeDp(int[] denominations, int total) {
        int n = denominations.length;
        int[][] dp = new int[n][total+1];
        for(int i =0;i<n;i++)
            dp[i][0] =1;

        for(int i =0;i<n;i++)
            for(int c =1;c<=total;c++){
                int profit1 =0;
                int profit2 =0;
                if(denominations[i]<=c)
                    profit1 = dp[i][c-denominations[i]];
                if(i>0)
                 profit2 = dp[i-1][c];
                dp[i][c] = profit1+profit2;
            }
        return dp[n-1][total];
    }

    public int countChangeRec(int[][] memo,int[] denominations, int total,int i) {
        if(total==0)
            return 1;
        if(denominations.length==0 || i>=denominations.length)
            return 0;
        int take =0;
        if(memo[i][total] ==0) {
            if (denominations[i] <= total)
                take = countChangeRec(memo, denominations, total - denominations[i], i);
            int noTake = countChangeRec(memo, denominations, total, i + 1);
            memo[i][total] = take+noTake;
        }
         return memo[i][total];
    }

    public static void main(String[] args) {
        CoinChange cc = new CoinChange();
        int[] denominations = {1, 2, 3};
        System.out.println(cc.countChangeDp(denominations, 5));
    }
}
