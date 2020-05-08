package com.mycompany.array;

public class ProductArray {
    public static int[] findProduct(int arr[])
    {
        int [] result = new int[arr.length];
        int product =1;

        int zeroCount =0;
        int zeroIndex =-1;
        for(int i =0;i<arr.length;i++){
            if(arr[i]==0) {
                zeroCount++;
                zeroIndex =i;
            }
            else{

                product =product * arr[i];
            }
        }
        if(zeroCount>1)
            return result;
        if(zeroCount==1)
            result[zeroIndex] =product;
        else {
            for (int i = 0; i < arr.length; i++) {
                result[i] = product / arr[i];
            }
        }

        return result;
    }

    public static void main(String[] args){

        int[] arr = {4,3,-1,5,3};
       int[] res =  findProduct(arr) ;
       for(int n :res)
        System.out.print(n +" ");
    }
}
