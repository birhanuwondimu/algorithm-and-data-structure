package com.mycompany.dynamicprogarming;

public class LPS {
    public int findLPSLength(String st) {
        int n = st.length();
        int[][] memo = new int[n][n];
        return  findLPSLength(memo,st.toCharArray(),0,st.length()-1);
    }
    public int findLPSLength(int[][] memo ,char[] st,int i, int j) {
        if(i==j)
          return 1;
        if(i>j)
            return 0;
        if(memo[i][j]==0) {

            if (st[i] == (st[j]))
                memo[i][j] = 2 + findLPSLength(memo, st, i + 1, j - 1);
            else
                memo[i][j]= Math.max(findLPSLength(memo, st, i + 1, j), findLPSLength(memo, st, i, j - 1));
        }
        return memo[i][j];
    }

    public int findLPSLengthDp(String st) {
        int n = st.length();
        int[][]dp = new int[n][n];
        char[] arr = st.toCharArray();
       // dp[0][0] =1;
        for(int i =0;i<n;i++)
            dp[i][i] =1;
        for(int i =n-1;i>=0;i--)
            for(int j =i+1;j<n;j++) {
                if (arr[i] == arr[j])
                        dp[i][j] = 2 + dp[i+1][j-1];
                    else
                        dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }

        return dp[0][n-1];

    }

    public int findLPSLengthRecursive(String str){
        int n = str.length();
        int[][] memo = new int[n][n];
        return findLPSLengthRecursive(memo,str.toCharArray(),0,str.length()-1);
    }
    public int findLPSLengthRecursive(int[][] memo,char[] str,int i,int j) {
    if(i>j)
        return 0;
    if(i==j)
        return  1;
    if(memo[i][j] ==0) {
        if (str[i] == str[j]) {
            int len = j - i - 1;
            if (len == findLPSLengthRecursive(memo, str, i + 1, j - 1)) {
                memo[i][j] = 2 + len;
                return memo[i][j];
            }
        }
        memo[i][j]=  Math.max(findLPSLengthRecursive(memo,str,i+1,j),findLPSLengthRecursive(memo,str,i,j-1));
    }

    return memo[i][j];

    }

    int count =0;
    public int findCPS(String st) {
        //return findCPS(st.toCharArray(),0);
        return -1;
    }

    public int findCPS(char[] arr,int i,int j) {
        if(i>=arr.length)
            return 0;
        if(i==j)
            return 1;
        if(arr[i]==arr[j]){
            int len = j-i-1;
            if(len== findCPS(arr,i+1,j-1))
                count++;
        }
        return count;
    }

    public int findCPSDP(String st) {
        int n = st.length();
        boolean [][] dp = new boolean[n][n];
        char[] arr = st.toCharArray();
        int count =0;
        for(int i =0;i<n;i++) {
            dp[i][i] = true;
            count++;
        }
        for(int i =n-1;i>=0;i--)
            for(int j =i+1;j<n;j++){
                if(arr[i] == arr[j]){
                    if(j-i==1 || dp[i+1][j-1]){
                        dp[i][j] = true;
                        count++;
                    }
                }
            }
        return count;
    }
    public int findLPSLengthD(String str){
        int n = str.length();
        boolean[][] dp = new boolean [n][n];
        char[] arr = str.toCharArray();
        for(int i =0;i<n;i++)
            dp[i][i] =true;
        int maxLeng = 1;
        for(int i =n-1;i>=0;i--)
            for(int j=i+1;j<n;j++) {
                if (arr[i] == arr[j]) {
                    int len = j - i;
                    if (len == 1 || dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                        maxLeng = Math.max(maxLeng, len + 1);
                    }
                }
            }
        return maxLeng;
    }
    public static void main(String[] args) {
        LPS cps = new LPS();
        System.out.println(cps.findCPSDP("abdbca"));
        System.out.println(cps.findCPSDP("cdpdd"));
        System.out.println(cps.findCPSDP("pqr"));
    }
}
