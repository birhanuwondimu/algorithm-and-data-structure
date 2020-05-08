package com.mycompany.array;

import  java.util.*;
import  java.util.Queue;
class MedianOfAStream {
    Queue<Integer> minHeap ;
    Queue<Integer> maxHeap ;
    int count;
   public  MedianOfAStream(){
       minHeap = new java.util.PriorityQueue<>();
       maxHeap = new java.util.PriorityQueue<>((a,b)->(b-a));
       count =0;

   }
    public void insertNum(int num) {
       count++;
        maxHeap.add(num);
       if(count %2==0){
           minHeap.add(maxHeap.poll());
       }
       if(count> 2 && maxHeap.peek()>minHeap.peek()){
           maxHeap.add(minHeap.poll());
           minHeap.add(maxHeap.poll());
       }

    }

    public double findMedian() {
       if(count==0)
           return -1;
       if(count%2==0){
           double median= minHeap.peek()+ maxHeap.peek();
           return median/2;
       }
       else
        return maxHeap.peek();
    }
    public  static  double[] findSlidingWindowMedian(int[] nums, int k) {
        double[] result = new double[nums.length - k + 1];
        Queue<Integer> smallerList = new java.util.PriorityQueue<>((a,b)->(b-a));
        Queue<Integer> largerList = new java.util.PriorityQueue<>();
        int n = nums.length;
        int j=0;
        for(int i =0;i<n;i++) {

            if (smallerList.isEmpty() || smallerList.peek() >= nums[i])
                smallerList.add(nums[i]);
            else
                largerList.add(nums[i]);

            rebalance(smallerList, largerList);

            if (i >= k - 1) {
                result[j++] = getMedia(smallerList, largerList);
                int elementToBeremoved = nums[i + 1 - k];
                if (elementToBeremoved <= smallerList.peek())
                    smallerList.remove(elementToBeremoved);
                else
                    largerList.remove(elementToBeremoved);

                rebalance(smallerList, largerList);

            }
        }

        return result;
    }

   private static  void   rebalance(java.util.Queue<Integer> smallerList,java.util.Queue<Integer> largerList){
       if(smallerList.size()>largerList.size()+1)
           largerList.add(smallerList.poll());
       else if(smallerList.size()<largerList.size())
           smallerList.add(largerList.poll());
   }

    private static double getMedia(java.util.Queue<Integer> smallerList,java.util.Queue<Integer> largerList){
        double media =0.0;
            if (smallerList.size() == largerList.size())
                media = smallerList.peek() / 2.0 + largerList.peek() / 2.0;
            else
                media = smallerList.peek();
        return media;
    }
    public static void main(String[] args) {
        //SlidingWindowMedian slidingWindowMedian = new SlidingWindowMedian();
        double[] result = findSlidingWindowMedian(new int[] {-2147483648,-2147483648,2147483647,-2147483648,-2147483648,
                -2147483648,2147483647,2147483647,2147483647,2147483647,-2147483648,2147483647,-2147483648}, 3);
        System.out.print("Sliding window medians are: ");
        for (double num : result)
            System.out.print(num + " ");
        System.out.println();

        //slidingWindowMedian = new SlidingWindowMedian();
        result = findSlidingWindowMedian(new int[] { 1, 2, -1, 3, 5 }, 3);
        System.out.print("Sliding window medians are: ");
        for (double num : result)
            System.out.print(num + " ");
    }
}
