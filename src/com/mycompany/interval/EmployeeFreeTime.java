package com.mycompany.interval;
import  java.util.*;
public class EmployeeFreeTime {
   static class Job {
        int eid, index;

        Job(int e, int i) {
            eid = e;
            index = i;
        }
    }
    public static List<com.mycompany.interval.Interval> employeeFreeTime(List<com.mycompany.interval.Interval> schedule) {
        List<com.mycompany.interval.Interval> result = new java.util.ArrayList<>();

        List<com.mycompany.interval.Interval> merged =schedule;// new java.util.ArrayList<>();
        /*for(List<com.mycompany.interval.Interval> sche : schedule) {
            for (Interval it : sche) {
                merged.add(it);
            }
        }*/
        if(merged.size()==0)
            return result;

        java.util.Collections.sort(merged, (l1, l2)->{
            if(l1.start ==l2.start)
                return l2.end-l1.end;
            return  l1.start-l2.start;
        });
        for(com.mycompany.interval.Interval it : merged){
            System.out.print(it.start+""+it.end);
            System.out.println();
        }
        List<com.mycompany.interval.Interval> temp = new java.util.ArrayList<>();
        temp.add(merged.get(0));
        for(com.mycompany.interval.Interval it : merged){
                if (temp.get(temp.size() - 1).end < it.start)
                    temp.add(it);
                else if (temp.get(temp.size() - 1).end < it.end)
                    temp.get(temp.size() - 1).end = it.end;
        }

        for(int i =0;i<temp.size()-1;i++){
            if(temp.get(i).end<temp.get(i+1).start)
                result.add(new com.mycompany.interval.Interval(temp.get(i).end,temp.get(i+1).start));
        }

     return result;
    }

    public static List<com.mycompany.interval.Interval> employeeFreeTimePQ(List<List<com.mycompany.interval.Interval>> avails) {
        List<com.mycompany.interval.Interval> ans = new ArrayList();
        java.util.Queue<int[]> schudule = new java.util.PriorityQueue<>(
                java.util.Comparator.comparingInt(a->avails.get(a[0]).get(a[1]).start));
        int minStart = Integer.MAX_VALUE;
        int emplId =0;

        for(List<com.mycompany.interval.Interval> iterval :avails){
            schudule.add(new int[]{emplId++,0});
            minStart = Math.min(minStart,iterval.get(0).start);
        }
        while(!schudule.isEmpty()){
            int[] curr =schudule.poll();
            com.mycompany.interval.Interval iter = avails.get(curr[1]).get(0);
            if(minStart<iter.start)
                ans.add(new com.mycompany.interval.Interval(minStart,iter.start));
             minStart = Math.max(minStart,iter.end);
             if(++curr[1]<avails.get(curr[0]).size())
                 schudule.add(curr);

        }
        return ans;
    }

    public  static void  main(String[] args){
        List<com.mycompany.interval.Interval> emp1 = new java.util.ArrayList<>();
        emp1.add(new com.mycompany.interval.Interval(1,2));
        emp1.add(new com.mycompany.interval.Interval(5,6));
        emp1.add(new com.mycompany.interval.Interval(9,20));
        emp1.add(new com.mycompany.interval.Interval(12,14));

        List<com.mycompany.interval.Interval> emp2 = new java.util.ArrayList<>();
        emp2.add(new com.mycompany.interval.Interval(1,3));
        emp2.add(new com.mycompany.interval.Interval(4,10));
        emp2.add(new com.mycompany.interval.Interval(11,13));

        List<com.mycompany.interval.Interval> emp3 = new java.util.ArrayList<>();
        emp3.add(new com.mycompany.interval.Interval(4,6));
        emp3.add(new com.mycompany.interval.Interval(1,3));
        emp3.add(new com.mycompany.interval.Interval(8,10));
        List<List<com.mycompany.interval.Interval>> arr= new java.util.ArrayList<>();
       // arr.add(emp1);
        //arr.add(emp2);
   //int [][] emp =  {{0,25},{5,16},{6,24},{7,24},{9,16},{18,26},{27,35},{29,31},{29,33},{33,36},{39,57},
    //       {40,47},{40,55},{43,49},{45,57},{56,59},{57,87},{61,75},{65,74},{66,69},{68,71},{78,81},{80,81},{91,94},{94,99}};
   //for(int[] num :emp)
     //  arr.add(new com.mycompany.interval.Interval(num[0],num[1]));
        arr.add(emp1);
        arr.add(emp2);
        arr.add(emp3);
        System.out.println(employeeFreeTimePQ(arr));
    }
}
