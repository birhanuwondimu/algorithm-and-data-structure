package com.mycompany.array;
import  java.util.*;
public class CyclicSort {
    public static void sort(int[] nums) {
        int n = nums.length;
        for(int i =0;i<n;)
            if(nums[i] !=i+1){
                int temp = nums[nums[i]-1];
                nums[nums[i]-1] =nums[i];
                nums[i] = temp;
            }
        else
            i++;

        // TODO: Write your code here
    }

    public static int findMissingNumber(int[] nums) {
        // TODO: Write your code here
        int n = nums.length;
        for(int i =0;i<n;){
            if (nums[i] < nums.length && nums[i] != nums[nums[i]]){
                int temp = nums[nums[i]];
                nums[nums[i]] =nums[i];
                nums[i] = temp;
            }
            else
                i++;
        }
        for(int i =0;i<n;i++)
            if(nums[i] !=i)
                return i;
        return -1;
    }

    public static List<Integer> findNumbers(int[] nums) {
        java.util.List<Integer> missingNumbers = new java.util.ArrayList<>();
        int n =nums.length;
        for(int i =0;i<n;) {
            if(nums[i] != nums[nums[i] - 1]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
            for(int i= 0;i<n;i++)
                if(nums[i] !=i+1)
                    missingNumbers.add(i+1);
        // TODO: Write your code here
        return missingNumbers;
    }

    public static int findDuplicateNumber(int[] nums) {

         int slow = nums[0];
         int fast = nums[0];

        do{
            slow = nums[slow];
             fast = nums[nums[fast]];
        }while(fast != slow);
   return  nums[fast];
    }

    public static List<Integer> findDublicateNumbers(int[] nums) {
        List<Integer> duplicateNumbers = new ArrayList<>();
        int n =nums.length;
        for(int i =0;i<n;){
            if(nums[i] !=nums[nums[i]-1]) {
                int temp =nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] =temp;
            }
            else
                i++;


        }
        for(int i =0;i<n;i++)
            if(nums[i] !=i+1)
                duplicateNumbers.add(nums[i]);
        // TODO: Write your code here
        return duplicateNumbers;
    }

    public static int[] findCorruptedNumbers(int[] nums) {

        int[] res = new int[] { -1, -1 };
         int i =0;
         int n = nums.length;
         while(i<n){
                 if (nums[i] != nums[nums[i]-1]){
                     int temp = nums[nums[i]-1];
                     nums[nums[i]-1] = nums[i];
                     nums[i] = temp;

             }
             else
                 i++;
         }
         for(i =0;i<n;i++){
             if(nums[i] !=i+1) {
                 res[0] = nums[i];
                 res[1] =i+1;
             }
         }
        return res;
    }

    public static int findFirstMissingPositiveNumber(int[] nums) {
       int i =0;
       int n = nums.length;
       while(i<n){
           if(nums[i]>0  && nums[i]<=n&& nums[i] !=nums[nums[i]-1]){
               int temp  = nums[nums[i]-1];
               nums[nums[i]-1] = nums[i];
               nums[i] = temp;
           }
           else
               i++;
       }
       for(i=0;i<n;i++)
           if(nums[i] !=i+1)
               return i+1;
        return -1;
    }

    public static List<Integer> findKthNumbers(int[] nums, int k) {
        List<Integer> missingNumbers = new ArrayList<>();
        int i =0;
        int n = nums.length;
        while(i<n){
            if(nums[i]>0 && nums[i]<=n && nums[i] != nums[nums[i]-1]){
                int temp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = temp;
            }
            else
                i++;
        }
        Set<Integer> set = new java.util.HashSet<>();
        for( i =0;i<n;i++) {
            if (nums[i] != i + 1 && missingNumbers.size() < k) {
                missingNumbers.add(i + 1);
                set.add(nums[i]);
            }
        }
            int j =n;
            while(missingNumbers.size()<k){
                if(!set.contains(j))
                    missingNumbers.add(j);
                j++;

            }
        return missingNumbers;
    }
    public  static void  main(String[] args){
        int[] arr = {2, 3, 4};
        //int[] res = findCorruptedNumbers(arr);
        findKthNumbers(arr,3).forEach(x->System.out.println(x));
        //System.out.println(findFirstMissingPositiveNumber(arr));
    }
}
