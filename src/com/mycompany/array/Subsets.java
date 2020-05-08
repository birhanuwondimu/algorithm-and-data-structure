package com.mycompany.array;
import  java.util.*;
public class Subsets     {
    public static List<List<Integer>> findSubsets(int[] nums) {
        List<List<Integer>> subsets = new java.util.ArrayList<>();
        findSubsetsrec(subsets,nums,0,new ArrayList<>());
        return subsets;
    }
    private static  void  findSubsetsrec(List<List<Integer>> subsets,int[] nums,int i,List<Integer> curr){
        if(i==nums.length){
            subsets.add(new ArrayList<>(curr));
            return;
        }
        findSubsetsrec(subsets,nums,i+1,new ArrayList<>(curr));
        curr.add(nums[i]);
        findSubsetsrec(subsets,nums,i+1,new ArrayList<>(curr));
    }

    public static List<List<Integer>> findSubsetsBFS(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        // start by adding the empty subset
        subsets.add(new ArrayList<>());
        for (int currentNumber : nums) {
            // we will take all existing subsets and insert the current number in them to create new subsets
            int n = subsets.size();
            for (int i = 0; i < n; i++) {
                // create a new subset from the existing subset and insert the current element to it
                List<Integer> set = new ArrayList<>(subsets.get(i));
                set.add(currentNumber);
                subsets.add(set);
            }
        }
        return subsets;
    }

    public  static  void  main(String[] args){
     // int[] arr ={1, 3};
      //  findSubsets(arr).forEach(x->System.out.println(x));
        List<List<Integer>> result = findSubsetsBFS(new int[] { 1, 3 });
        System.out.println("Here is the list of subsets: " + result);

        result = findSubsetsBFS(new int[] { 1, 5, 3 });
        System.out.println("Here is the list of subsets: " + result);
    }
}
