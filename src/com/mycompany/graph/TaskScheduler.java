package com.mycompany.graph;
import  java.util.*;
class TaskScheduler {

    public static int scheduleTasks(char[] tasks, int k) {
        Map<Character, Integer> charFrequency = new HashMap<>();

        for(char task : tasks)
            charFrequency.put(task,charFrequency.getOrDefault(task,0)+1);
        PriorityQueue<Map.Entry<Character,Integer>> pq = new java.util.PriorityQueue<>((a,b)->b.getValue()-a.getValue());
        pq.addAll(charFrequency.entrySet());
        int count =0;

        //java.util.Queue<Map.Entry<Character,Integer>> queue = new LinkedList();
        while(!pq.isEmpty()){

            int n= k+1;
            List<Map.Entry<Character,Integer>> waitList = new java.util.ArrayList<>();
            for(;n>0 && !pq.isEmpty();n--) {
                Map.Entry<Character, Integer> curr = pq.poll();
                curr.setValue(curr.getValue() - 1);
                if(curr.getValue()>0)
                 waitList.add(curr);
                count++;
            }
            pq.addAll(waitList);
            if(!pq.isEmpty())
                count +=n;

        }
        // TODO: Write your code here
        return count;
    }

    public static void main(String[] args) {
        char[] tasks = new char[] { 'a', 'a', 'a', 'b', 'c', 'c' };
        System.out.println("Minimum intervals needed to execute all tasks: " + TaskScheduler.scheduleTasks(tasks, 2));

        tasks = new char[] { 'a', 'b', 'a' };
        System.out.println("Minimum intervals needed to execute all tasks: " + TaskScheduler.scheduleTasks(tasks, 3));
    }
}