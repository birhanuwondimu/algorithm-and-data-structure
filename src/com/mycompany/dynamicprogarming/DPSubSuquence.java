package com.mycompany.dynamicprogarming;
import  java.util.*;
public class DPSubSuquence {
    String m;
    String n;
    public boolean Interleaving(String m, String n , String p){
  this.m = m;
  this.n =n;
        return InterleavingRec(m,n,p,0,0,0) ;
    }

    public boolean InterleavingRec(String m, String n , String p,int mi,int ni,int pi) {
         if(pi==p.length()){

             return mi==m.length() && ni==n.length();
         }

         if(pi==p.length())
             return false;

         if(mi<m.length() && m.charAt(mi)==p.charAt(pi))
             if(InterleavingRec(m,n,p,mi+1,ni,pi+1))
                 return true;

        if(ni < n.length() && n.charAt(ni)==p.charAt(pi))
            if(InterleavingRec(m,n,p,mi,ni+1,pi+1))
                return true;
            return false;
    }
    public  int longestCommonSubstring(String s1,String s2){

        int n = s1.length();
        int m = s2.length();
        int maxlen = n<m?n:m;
        Integer[][][] memo = new Integer[n][m][maxlen];
        return longestCommonSubstring(memo,s1,s2,0,0,0);
    }

    public int longestCommonSubstring(Integer[][][] memo,String s1,String s2,int i, int j,int c) {

        if(i==s1.length() || j == s2.length())
            return c;
        if(memo[i][j][c]==null) {
            if (s1.charAt(i) == s2.charAt(j))
                 return  memo[i][j][c]= longestCommonSubstring(memo, s1, s2, i + 1, j + 1, c + 1);
                int l1 = longestCommonSubstring(memo, s1, s2, i + 1, j, 0);
                int l2 = longestCommonSubstring(memo, s1, s2, i, j + 1, 0);
                //c = Math.max(c, Math.max(l1, l/2));

            memo[i][j][c] =Math.max(c, Math.max(l1, l2));;
        }


        return   memo[i][j][c];
    }

    public  int longestCommonSubstringDp(String s1,String s2){

        int n = s1.length();
        int m = s2.length();
        int max = 0;
        int[] index = {0,0};
        Integer[][] dp = new Integer[2][m+1];
        for(int i =0;i<n;i++)
            for(int j =0;j<m;j++){

                if(i==0 || j==0){
                    dp[i%2][j] =0;
                }
                else if(s1.charAt(i)==s2.charAt(j)) {
                        dp[i%2][j] = 1+dp[(i-1)%2][j-1];
                    if(dp[i%2][j]>max){
                        max = dp[i%2][j];
                        index = new int[]{i,j};
                    }
                }
                else
                    dp[i%2][j] = 0;
            }

        int j = index[1];
            String sub = "";
        /*for(int k = index[0];k>0 && j>=0;){
            if(dp[k%2][j]  != dp[(k-1)%2][j]) {
                sub = s2.charAt(k) + sub;
                k--;
            }
            else
                j--;

        }

        System.out.println(sub)*/
        return max;
    }

    public  Map<String,Integer>  minimumDeletionAndInsertion(String s1, String s2){
        int n = s1.length();
        int m = s2.length();
        Map<String,Integer> resul = new java.util.HashMap<>();
        int[][]dp = new int[n+1][m+1];

        for(int i =1;i<=n;i++)
            for(int j =1;j<=m;j++){

                /*if(i==0|| j==0){
                    dp[i][j] =0;
                }*/
                 if(s1.charAt(i-1)==s2.charAt(j-1))
                        dp[i][j] = 1+dp[i-1][j-1];
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        int lcs = dp[n][m];
            int minLen = Math.min(n,m);
            resul.put("Insertion",minLen-lcs);//Deletion
              resul.put("Deletion",minLen-lcs +Math.abs(n-m));
            return resul;
    }

    public  int longestIncreasingSubsequence(int[] arr){
        int[][] memo = new int[arr.length][arr.length+1];
        //return longestIncreasingSubsequenceRe(memo,arr,0,-1);
        return -1;
    }
    /*public int  longestIncreasingSubsequenceRe(int[][] memo,int[] arr,int i,int preIndex){
        if(i==arr.length)
            return 0;

        int include = 0;
        if(preIndex ==-2 || arr[i]<arr[preIndex])
            include= longestIncreasingSubsequence(memo,arr,i+1,c+1);

           int include = longestIncreasingSubsequence(arr,i+1,c);
        int exclude = longestIncreasingSubsequence(arr,i+1,0);
           return  Math.max(include,exclude);

    }*/

    //Input: s1 = "abdca"
    //       s2 = "cbda"

    public  static  void  main(String[] args){
        DPSubSuquence dpSubSuquence = new  DPSubSuquence();
        int[]arr ={4,2,3,6,10,1,12};
        System.out.println(dpSubSuquence.longestIncreasingSubsequence(arr));
        //Input: m="abd", n="cef", p="abcdef"
        //Output: true
    }
}
