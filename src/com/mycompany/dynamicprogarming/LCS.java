package com.mycompany.dynamicprogarming;

public class LCS {

    public int findLCSLength(String s1, String s2) {
        int maxlenght = s1.length()>s2.length()? s1.length():s2.length();
        int[][][]memo = new int[s1.length()][s2.length()][maxlenght];
        return findLCSLengthRecursive(memo,s1.toCharArray(), s2.toCharArray(), 0, 0,0);
    }
    private int findLCSLengthRecursive( int[][][] memo,char[] arr1, char[] arr2,int i,int j,int count){
        if(i== arr1.length || j==arr2.length)
            return count;
        if(memo[i][j][count]==0) {
            int c1= count;
            if (arr1[i] == arr2[j])
                c1 = findLCSLengthRecursive(memo, arr1, arr2, i + 1, j + 1, count + 1);
            int c2 = findLCSLengthRecursive(memo, arr1, arr2, i + 1, j, 0);
            int c3 = findLCSLengthRecursive(memo,arr1, arr2, i, j + 1, 0);
            memo[i][j][count] = Math.max(c1,Math.max(c2,c3));
        }
return memo[i][j][count];
    }

    public  int findLCSLengthDp(String s1, String s2){
        int n = s1.length();
        int m = s2.length();
        char[] arr1 =s1.toCharArray();
        char[]arr2 = s2.toCharArray();
        int[][] dp = new int[n][m];
        int max =0;
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++){
                if(i==0|| j==0)
                    dp[i][j] =0;
                else if(arr1[i]==arr2[j]){
                    dp[i][j] = 1+dp[i-1][j-1];
                    max = Math.max(max,dp[i][j]);
                }
            }
        return max;
    }

    public static void main(String[] args) {
        LCS lcs = new LCS();
        System.out.println(lcs.findLCSLengthDp("abdca", "cbda"));
        System.out.println(lcs.findLCSLengthDp("passport", "ppsspt"));
    }
}
