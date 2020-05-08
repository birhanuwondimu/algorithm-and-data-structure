package com.mycompany.array;
import  java.util.*;
public class TwoPoniters {
    public static List<List<Integer>> searchTriplets(int[] arr) {
        List<List<Integer>> triplets = new java.util.ArrayList<>();
        java.util.Arrays.sort(arr);
        for(int i =0;i<arr.length-1;i++){
            if(i==0 || arr[i] !=arr[i-1]){
                searchPairs(triplets,arr,i);
            }
        }
        // TODO: Write your code here
        return triplets;
    }
    private static List<List<Integer>> searchPairs(List<List<Integer>> res,int[] arr, int k){
        int i =0;
        int j = arr.length-1;
        while(i<j){
            int curr = arr[i]+arr[j];
            if(curr + arr[k] ==0) {
                res.add(Arrays.asList(new Integer[]{k,i,j}));
                i++;
                j--;
                while(i<j && arr[i] ==arr[i-1])
                     i++;
                while(i<j && arr[j] ==arr[j+1])
                    j--;
            }
            if(curr + arr[k]<0)
                i++;
            else
                j--;
        }
        return res;
    }

    public static List<List<Integer>> findSubarrays(int[] arr, int target) {
        List<List<Integer>> subarrays = new ArrayList<>();
        int n = arr.length;
        int curProduct = 1;
        int low = 0;
        for (int i = 0; i < n; i++) {
            curProduct = curProduct * arr[i];

            while (low < n && curProduct >= target) {
                curProduct /=arr[low];
                low++;
            }
            List<Integer> temp = new java.util.ArrayList<>();
            for (int k = i; k >=low; k--) {
                temp.add(0,arr[k]);
                subarrays.add(new java.util.ArrayList<>(temp));
            }
        }
        return subarrays;
    }


    public static void main(String[] args) {
        System.out.println(findSubarrays(new int[] { 2, 5, 3, 10 }, 30));
        System.out.println(findSubarrays(new int[] { 8, 2, 6, 5 }, 50));
    }

}
