package com.mycompany.interval;

public class NextInterval {
    public static int[] findNextInterval(com.mycompany.interval.Interval[] intervals) {
        int n = intervals.length;
        // heap for finding the maximum start
        java.util.PriorityQueue<Integer> maxStartHeap = new java.util.PriorityQueue<>(n, (i1, i2) -> intervals[i2].start - intervals[i1].start);
        // heap for finding the minimum end
        java.util.PriorityQueue<Integer> maxEndHeap = new java.util.PriorityQueue<>(n, (i1, i2) -> intervals[i2].end - intervals[i1].end);
        int[] result = new int[n];
        for (int i = 0; i < intervals.length; i++) {
            maxStartHeap.offer(i);
            maxEndHeap.offer(i);
        }

        // go through all the intervals to find each interval's next interval
        for (int i = 0; i < n; i++) {
            int topEnd = maxEndHeap.poll(); // let's find the next interval of the interval which has the highest 'end'
            result[topEnd] = -1; // defaults to -1
            if (intervals[maxStartHeap.peek()].start >= intervals[topEnd].end) {
                int topStart = maxStartHeap.poll();
                // find the the interval that has the closest 'start'
                while (!maxStartHeap.isEmpty() && intervals[maxStartHeap.peek()].start >= intervals[topEnd].end) {
                    topStart = maxStartHeap.poll();
                }
                result[topEnd] = topStart;
                maxStartHeap.add(topStart); // put the interval back as it could be the next interval of other intervals
            }
        }
        return result;
    }

    public  static int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int currMax = 0;
        for(int i =0;i<nums.length;i++){
            currMax = Math.max(currMax+nums[i],nums[i]);
            max = Math.max(max,currMax);
        }
        return max;
    }

    public static void main(String[] args) {
        int [] arr = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(arr));
    }
}
