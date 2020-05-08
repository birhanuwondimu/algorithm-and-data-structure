package com.mycompany.dynamicprogarming;

public class HouseThief {
    public int findMaxSteal(int[] wealth) {
        int[] mem=  new int[wealth.length+1];
       return findMaxStealRec(mem,wealth,0);

    }
    public int findMaxStealRec( int[] memo,int[] wealth,int i) {
        if(wealth.length==0 || i>=wealth.length)
            return 0;
        if(memo[i]==0) {
            return Math.max(wealth[i]+findMaxStealRec(memo,wealth,i+2),findMaxStealRec(memo,wealth,i+1));
        }
        return memo[i];
    }

    public int findMaxStealDp(int[] wealth) {
        //int[] dp=  new int[wealth.length];
        int pre1 =0;
       int pre =wealth[1];
       int curr =0;
        for(int i =2;i<wealth.length;i++) {
            curr = Math.max(wealth[i] + pre1, pre);
            pre1 = pre;
            pre = curr;
        }
        return curr;

    }

    public static void main(String[] args) {
        HouseThief ht = new HouseThief();
        int[] wealth = {2, 5, 1, 3, 6, 2, 4};
        System.out.println(ht.findMaxStealDp(wealth));
        wealth = new int[]{2, 10, 14, 8, 1};
        System.out.println(ht.findMaxStealDp(wealth));
    }
}
