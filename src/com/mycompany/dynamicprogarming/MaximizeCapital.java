package com.mycompany.dynamicprogarming;

public class MaximizeCapital {
    public static int findMaximumCapital(int[] capital, int[] profits, int numberOfProjects, int initialCapital) {
        java.util.Queue<int[]> minCapital = new java.util.PriorityQueue<>((a,b)->(a[0]-b[0]));
        java.util.Queue<Integer> maxCapital = new java.util.PriorityQueue<>((a,b)->(b-a));

        for(int i =0;i<capital.length;i++)
            minCapital.add(new int[]{capital[i],profits[i]});

        int currcapital = initialCapital;
        for(int i =0;i<numberOfProjects;i++){
            while(!minCapital.isEmpty() && minCapital.peek()[0]<=currcapital){
                maxCapital.add(minCapital.poll()[1]);
            }
            if(maxCapital.isEmpty())
                break;
            currcapital +=maxCapital.peek();
        }
        return currcapital;
    }

    public static void main(String[] args) {
        int result = MaximizeCapital.findMaximumCapital(new int[] { 0, 1, 2 }, new int[] { 1, 2, 3 }, 2, 1);
        System.out.println("Maximum capital: " + result);
        result = MaximizeCapital.findMaximumCapital(new int[] { 0, 1, 2, 3 }, new int[] { 1, 2, 3, 5 }, 3, 0);
        System.out.println("Maximum capital: " + result);
    }
}
