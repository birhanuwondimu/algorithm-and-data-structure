package com.mycompany.array;

public class MaxSumSubArrayOfSizeK {
    public static int findMaxSumSubArray(int k, int[] arr) {
        int max = Integer.MIN_VALUE;
        int n = arr.length;
        int i =0;
        int sum =0;
        for(int  j=0;j<n;j++){
            sum +=arr[j];
            if(j>=k-1){
                max = Math.max(max,sum);
                sum -=arr[i];
                i++;
            }


        }
        // TODO: Write your code here
        return max;
    }

    public static int findMinSubArray(int S, int[] arr) {
        int l =0;
        int n = arr.length;
        int sum =0;
        int minlen =Integer.MAX_VALUE;
       for(int i =0;i<n;i++) {
           sum +=arr[i];
           while(sum>=S) {
               minlen = Math.min(minlen, i-l+1);
               sum -= arr[l];
               l++;
           }

        }
        return minlen ==Integer.MAX_VALUE? 0:minlen;
    }

    public  static void  main(String[]args){
        int[] arr ={2, 1, 5, 2, 3, 2};
        System.out.println(findMinSubArray(7,arr));
    }
}
