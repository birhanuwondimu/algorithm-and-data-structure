package com.mycompany.array;

public class SumArraySum {
    int max = Integer.MIN_VALUE;
    private int TowOverLappingSubArray(int[] arr){
        int[]memo = new int[arr.length];
     return TowOverLappingSubArray(memo,arr,0);
    }

    private  int TowOverLappingSubArray( int[]memo ,int[] arr,int i){
        if(i>=arr.length)
            return max;
        //if(memo[i]==0){
        int curr = arr[i];

          return  Math.max(arr[i]+ TowOverLappingSubArray(memo,arr,i+1),TowOverLappingSubArray(memo,arr,i+1));

    }

    public static void  main(String[]args){
        SumArraySum sum = new SumArraySum();
        System.out.println(sum.TowOverLappingSubArray(new int[]{-3,-2,-1}));
    }
}
