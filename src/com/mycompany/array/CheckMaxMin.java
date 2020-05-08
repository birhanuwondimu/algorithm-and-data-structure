package com.mycompany.array;

class CheckMaxMin {

    public static void maxMin(int[] arr) {
        int[] result =new int[arr.length];
        int i =0;
        int n = arr.length;
        int j =n-1;
        while(i<n){
            result[i] = arr[j];
            i +=2;
            j--;
        }
        i =1;
        j =0;
        while(i<n) {
            result[i] = arr[j];
            i +=2;
            j++;
        }
        for( i =0 ;i<arr.length;i++)
            arr[i] = result[i];


        // Write - Your - Code
    }

    public static void maxMinModified(int[] arr) {
        int maxIdx = arr.length - 1;
        int minIdx = 0;
        int maxElem = arr[maxIdx] + 1; // store any element that is greater than the maximum element in the array
        for( int i = 0; i < arr.length; i++) {
            // at even indices we will store maximum elements
            if (i % 2 == 0){
                arr[i] += (arr[maxIdx] % maxElem ) * maxElem;
                maxIdx -= 1;
            }
            else { // at odd indices we will store minimum elements
                arr[i] += (arr[minIdx] % maxElem ) * maxElem;
                minIdx += 1;
            }
        }
        // dividing with maxElem to get original values.
        for( int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] / maxElem;
        }
    }

    public static void main(String args[]) {

        int[] arr = {0,1,2,3,4,5,6,7,8,9};
        System.out.print("Array before min/max: ");
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();

        maxMinModified(arr);

        System.out.print("Array after min/max: ");
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

}