package com.mycompany.interval;

import  java.util.*;
import com.mycompany.interval.Interval;
class InsertInterval {

    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        java.util.List<Interval> mergedIntervals = new java.util.ArrayList<>();
        if(intervals.size()==0 || newInterval ==null)
            return mergedIntervals;

        int n = intervals.size();
        for(int i =0;i<n;i++){
            if(intervals.get(i).start>=newInterval.start && !equalInterval(intervals.get(i),newInterval))
                //if(!equalInterval(intervals.get(i),newInterval))
                intervals.add(i,newInterval);
            break;
        }

        //if(intervals.size()==n && !equalInterval(intervals.get(n-1),newInterval))
        //intervals.add(n-1,newInterval);


        for(Interval iter: intervals){
            int size = mergedIntervals.size();
            if(size==0 || mergedIntervals.get(size-1).end<iter.start)
                mergedIntervals.add(iter);
            else if(mergedIntervals.get(size-1).end<iter.end)
                mergedIntervals.get(size-1).end = iter.end;

        }
        //TODO: Write your code here
        return mergedIntervals;
    }
    public static boolean equalInterval(Interval ite1, Interval ite2){
        if(ite1==null && ite2==null)
            return true;
        if(ite1==null|| ite2 ==null)
            return false;
        return ite1.start==ite2.start && ite1.end==ite2.end;

    }

    public static Interval[] merge(Interval[] arr1, Interval[] arr2) {
        List<Interval> intervalsIntersection = new ArrayList<Interval>();
        // TODO: Write your code here
        int i =0;
        int n= arr1.length;
        int m = arr2.length;
        int j =0;
        while(i<n && j<m){
            int[] ar1 = new int[]{arr1[i].start,arr1[i].end};
            int[] ar2 = new int[]{arr2[j].start,arr2[j].end};

            if(doOverLap(arr1[i],arr2[j])){
                int maxstart = Math.max(arr1[i].start,arr2[j].start);
                int minEnd = Math.min(arr1[i].end,arr2[j].end);
                intervalsIntersection.add(new Interval(maxstart,minEnd));
            }
            if(arr1[i].end<arr2[j].end)
                i++;
            else
                j++;
        }
        return intervalsIntersection.toArray(new Interval[intervalsIntersection.size()]);
    }
    private static boolean doOverLap(Interval ite1,Interval ite2){
        return !(ite1.start> ite2.end ||ite1.end<ite2.start);
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int []> res = new ArrayList<>();

        int i =0;

        if(intervals[0][0]<newInterval[0]){
            res.add(intervals[0]);
            i++;
        }
        else
            res.add(newInterval);

        while(res.get(res.size()-1)[1]<newInterval[1]){
            int s = res.size();
            if(res.get(s-1)[1]<newInterval[0]){
                if(intervals[i][0]<newInterval[0]) {
                    res.add(intervals[i++]);
                }
                else
                    res.add(newInterval);
            }
            else if(res.get(s-1)[1]<newInterval[1])
                res.get(s-1)[1] =newInterval[1];
        }
         if(res.get(res.size()-1)[1]<=intervals[i][0] &&  res.get(res.size()-1)[1] <intervals[i][1])
            res.get(res.size()-1)[1] =intervals[i++][1];

        while(i<intervals.length){
            res.add(intervals[i++]);
        }
        int[][] result = new int[2][res.size()];
        for(int k =0;k<res.size();i++)
            result[k] = res.get(k++);
        return result;
    }

    public static void main(String[] args) {
    int[][] interval =  {{1,3},{6,9}};
        int[] newiInterval = {0,1};
        System.out.println(insert(interval,newiInterval));
    }


}