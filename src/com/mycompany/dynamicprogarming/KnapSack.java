package com.mycompany.dynamicprogarming;

public class KnapSack {
    static java.util.List<Integer>  list = new java.util.ArrayList<>();
    public int solveKnapsack(int[] profits, int[] weights, int capacity) {
        if(capacity==0 || profits.length==0 || profits.length != weights.length)
            return 0;
        int n = profits.length;
        int[][]dp = new int[n][capacity+1];
        for(int i =0;i<n;i++)
            dp[i][0] =0;

        for(int i =0;i<n;i++)
            if(weights[0]<=capacity)
                dp[0][i] =profits[0];

            for(int i =1;i<n;i++)
                for(int c =1;c<=capacity;c++){
                    int profit1=0;
                    if(weights[i]<=c){
                        profit1 = profits[i]+ dp[i-1][c-weights[i]];
                    }
                    int profit2 = dp[i-1][c];
                    dp[i][c] = Math.max(profit1,profit2);
                }

            int totalprofit = dp[n-1][capacity];
                java.util.List<Integer> res = new java.util.ArrayList<>();
        for(int i=n-1; i > 0; i--) {
            if(totalprofit != dp[i-1][capacity]) {
                res.add(weights[i]);
                capacity -= weights[i];
                totalprofit -= profits[i];
            }
        }
        list = res;
        return dp[n-1][capacity];
    }

    public static boolean canPartition(int[] num) {
        if(num.length==0)
            return true;
        int sum = 0;
        for(int n: num)
            sum +=n;
        if(sum%2 !=0)
            return false;
        Boolean[][] memo = new Boolean[num.length][sum/2+1];


        return canPartitionRec(memo,num,sum/2,0);
    }
    private  static boolean canPartitionRec(Boolean[][] memo,int[] num, int sum,int index){
      //  if(num.length==0 || index>=num.length)
      //  return false;
       // if(sum==0)
        //    return true;

        if (sum == 0)
            return true;

        if (num.length == 0 || index >= num.length)
            return false;
        if(memo[index][sum] ==null) {
            if (num[index] <= sum) {
                if (canPartitionRec(memo, num, sum - num[index], index + 1)) {
                    memo[index][sum] = true;
                    return true;

                }
            }
            memo[index][sum] = canPartitionRec(memo,num, sum, index + 1);
        }
            return memo[index][sum];
       /* if (memo[index][sum] == null) {
            // recursive call after choosing the number at the currentIndex
            // if the number at currentIndex exceeds the sum, we shouldn't process this
            if (num[index] <= sum) {
                if (canPartitionRec(memo, num, sum - num[index], index + 1)) {
                    memo[index][sum] = true;
                    return true;
                }
            }

            // recursive call after excluding the number at the currentIndex
            memo[index][sum] = canPartitionRec(memo, num, sum, index + 1);
        }

        return memo[index][sum];*/

    }

    private  static  boolean sumEqual(int[] arr, int sum){
        Boolean[][] memo = new Boolean[arr.length][sum+1];
        //return sumEqualRec(memo,arr,sum,0);
        return sumEqualDp(arr,sum);

    }

    private  static  boolean sumEqualRec( Boolean[][] memo,int[] arr, int sum,int i){
        if(sum ==0)
            return true;
        if(i>=arr.length)
            return false;
        if(memo[i][sum] !=null)
            return memo[i][sum];
        if(arr[i]<=sum){
            memo[i][sum] =(sumEqualRec(memo,arr,sum-arr[i],i+1));
            if(memo[i][sum])
                return true;
        }
        return  memo[i][sum]= sumEqualRec(memo,arr,sum,i+1);
    }

    private  static  boolean sumEqualDp(int[] num, int sum){

        int n = num.length;
       // boolean[][] dp = new boolean[n][sum + 1];
        boolean[] dp = new boolean[sum+1];
        //for(int i =0;i<n;i++)
            dp[0] = true;

        for(int i =1;i<=sum;i++){
            dp[i] = num[0]==i?true:false;
        }


        for(int i =1;i<n;i++)
            for(int s=sum;s>=0;s--){

                if(!dp[s] && num[i]<=s){
                    dp[s] = dp[s-num[i]];
                }
            }
  return dp[sum];
    }
    public static int canPartitionMinDiff(int[] num) {
        int sum =0;
        for(int n :num)
            sum +=n;
        Integer[][]memo = new Integer[num.length][sum+1];

        return canPartitionRecRec(memo,num,0,0,0);
    }
    public static int canPartitionRecRec(Integer[][] memo,int[] num,int sum1,int sum2,int i) {
        if(i==num.length)
            return Math.abs(sum1-sum2);
        if(memo[i][sum1]==null) {
            //return memo[i][sum1];
            int diff1 = canPartitionRecRec(memo, num, sum1 + num[i], sum2, i + 1);
            int diff2 = canPartitionRecRec(memo, num, sum1, sum2 + num[i], i + 1);
            memo[i][sum1] = Math.min(diff1,diff2);
        }
        return  memo[i][sum1];
    }
  static int  count = 0;
    public static int canPartitionDp(int[] num) {
        int sum =0;
        for(int n :num)
            sum +=n;

        int n = num.length;
        boolean[][]dp = new boolean[n][sum/2+1];
        for(int i =0;i<n;i++){
            dp[i][0] = true;
        }
        for(int i =0;i<=sum/2;i++)
            dp[0][i] = (num[0] ==i)? true:false;
        for(int i = 1;i<n;i++)
            for(int s=1;s<=sum/2;s++){
                if(dp[i-1][s]){
                    dp[i][s] = dp[i-1][s];

                }
                else if(s>=num[i])
                    dp[i][s]= dp[i-1][s-num[i]];
            }
        int sum1 =0;
        for(int i = sum/2;i>=0;i--)
            if(dp[n-1][i]){
                sum1=i;
                break;
            }

        return Math.abs(2*sum1-sum);
    }
    public static int  countSubsets(int[] num, int sum){
      Integer[][] memo = new Integer[num.length][sum+1];
        return  countSubsetsRec(memo,num,sum,0);
    }

    public static int   countSubsetsRec(Integer[][] memo,int[] num, int sum,int i){
        if(sum==0)
            return 1;
        if(i>=num.length)
            return 0;
        int c1 =0;
        if(memo[i][sum]==null) {
            if (num[i] <= sum)
                c1 = countSubsetsRec(memo, num, sum - num[i], i + 1);
            int c2 = countSubsetsRec(memo, num, sum, i + 1);
            memo[i][sum] = c1+c2;;
        }
        return memo[i][sum];
    }

    public static int  countSubsetsDp(int[] num, int sum){
        int n = num.length;
        int[][] dp = new int[n][sum+1];
        for(int i =0;i<n;i++)
            dp[i][0] = 1;

        for(int i =0;i<=sum;i++)
            dp[0][i] =num[0]==i?1:0;

        for(int i =1;i<n;i++)
            for(int j =1;j<=sum;j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= num[i])
                    dp[i][j] += dp[i - 1][j - num[i]];
            }


        return  dp[n-1][sum];
    }

    public static int findTargetSubsets(int[] num, int s) {
        // TODO: Write your code here
        return findTargetSubsetsrec(num,s,0,0);
    }
    public static int findTargetSubsetsrec(int[] num, int sum,int curSum,int i) {
        if(curSum==sum)
            return 1;
        if(i>=num.length)
            return 0;

        return findTargetSubsetsrec(num,sum,curSum-num[i],i+1)
                + findTargetSubsetsrec(num,sum,curSum+num[i],i+1);
    }
    public  int knapsackRecursive(int[] profits, int[] weights, int capacity) {
        int[][] memo = new int[profits.length][capacity+1];
        return this.knapsackRecursiveRec(memo,profits, weights, capacity, 0);
    }
    private int knapsackRecursiveRec(int[][] memo,int[] profits, int[] weights, int capacity,int i){

        if(capacity<=0 || profits.length==0 || profits.length !=weights.length || i>=profits.length)
            return 0;
        int include =0;
        if(memo[i][capacity]==0) {
            if (weights[i] <= capacity)
                include = profits[i] + knapsackRecursiveRec(memo, profits, weights, capacity - weights[i], i);
            int exclude = knapsackRecursiveRec(memo, profits, weights, capacity, i + 1);
            memo[i][capacity] =  Math.max(exclude, include);
        }
            return memo[i][capacity];

    }

    public  int knapsackRecursiveDp(int[] profits, int[] weights, int capacity) {
        int[][] dp = new int[profits.length][capacity+1];
        int n = profits.length;

        for(int i =0;i<n;i++)
            dp[i][0] =0;
        for(int c =0;c<capacity;c++)
            dp[0][c] = weights[0]<=c? c:0;
        for(int i =1;i<n;i++)
            for(int c =1;c<=capacity;c++){
                int include=0;
                int exclude=0;
                if (weights[i] <= c)
                    include = profits[i] + dp[i][c - weights[i]];
                //if(i>0)
                 exclude = dp[i-1][c];
                dp[i][c] =  Math.max(exclude, include);
            }
        return dp[n-1][capacity];

    }

    public static void main(String[] args) {
        KnapSack ks = new KnapSack();
        int[] profits = { 15, 50, 60, 90 };
        int[] weights = { 1, 3, 4, 5 };
        int maxProfit = ks.knapsackRecursiveDp(profits, weights, 8);
        System.out.println(maxProfit);

    }
}
