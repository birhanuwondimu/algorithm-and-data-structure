package com.mycompany.binarysearch;

class BinarySearch {

    public static int search(int[] arr, int key) {
        if(arr.length==0)
            return -1;
        if(arr.length==1) {
            if(arr[0]==key)
                return 0;
            else
                return  -1;
        }
        int n = arr.length;
        boolean increasingOrder = arr[0]< arr[n-1]? true:false;

        int i = 0;
        int j = n-1;

        while(i<=j){
            int mid = i +(j-i)/2;
            if(arr[mid]==key)
                return mid;
            if(key> arr[mid]){
                if(increasingOrder)
                    i = mid+1;
                else
                    j= mid-1;
            }
            else{
                if(increasingOrder)
                    j= mid-1;
                else
                    i = mid+1;
            }
        }


        // TODO: Write your code here
        return -1;
    }

    public static int searchCeilingOfANumber(int[] arr, int key) {

      if(arr.length==0)
          return -1;
      int l =0;
      int h = arr.length-1;
   if(key>arr[h])
    return -1;
      while(l<=h){
          int mid = l +(h-l)/2;
          if(arr[mid]==key)
              return mid;
          if(key>arr[mid])
               l = mid +1;
          else
              h= mid-1;
      }
         return l;
    }

    public static int searchMinDiffElement(int[] arr, int key) {
        // TODO: Write your code here
        if(arr.length==0)
            return -1;

        int n = arr.length;
        if(key<arr[0])
            return arr[0];

        if(arr[n-1]< key)
            return arr[n-1];

        int l = 0;
        int h = n-1;
        while(l<=h){
            int mid = l +(h-l)/2;
            if(arr[mid]==key)
                return arr[mid];
            if(key<arr[mid])
                h = mid-1;
            else
                l= mid+1;
        }
        if(Math.abs(arr[l]-key) < Math.abs(arr[h]-key))
            return arr[l];
        else
            return arr[h];
    }

    public static void main(String[] args) {
        System.out.println(searchMinDiffElement(new int[] { 4, 6, 10 }, 7));
        System.out.println(searchMinDiffElement(new int[] { 4, 6, 10 }, 4));
        System.out.println(searchMinDiffElement(new int[] { 1, 3, 8, 10, 15 }, 12));
        System.out.println(searchMinDiffElement(new int[] { 4, 6, 10 }, 17));
    }
}