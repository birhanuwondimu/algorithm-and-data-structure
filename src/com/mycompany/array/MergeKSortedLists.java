package com.mycompany.array;

import  java.util.*;

public class MergeKSortedLists {
    class ListNode {
        int value;
        ListNode next;

        ListNode(int value) {
            this.value = value;
        }
    }


    public static ListNode merge(ListNode[] lists) {
        MergeKSortedLists mergeKSortedLists = new MergeKSortedLists();
        ListNode result = mergeKSortedLists.new ListNode(-1);
        java.util.PriorityQueue<com.mycompany.array.MergeKSortedLists.ListNode> minHeap = new java.util.PriorityQueue<>((node1, node2)->node1.value-node2.value);    // TODO: Write your code here
        for(ListNode node : lists){
            if(node!=null)
                minHeap.add(node);
        }
        ListNode temp = result;
        while(!minHeap.isEmpty()){
            ListNode curr =minHeap.poll();
            temp.next = curr;
            temp = temp.next;


            if(curr !=null){
                minHeap.add(curr.next);
            }
        }
        return result.next;
    }

    public static int findKthSmallest(int[][] matrix, int k) {
        java.util.PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a->matrix[a[0]][a[1]]));
        for(int i =0;i<matrix.length;i++)
            minHeap.add(new int[]{i,0});
        int count =0;
         while(!minHeap.isEmpty()){
             int[] curr = minHeap.poll();
             count++;
             if(count==k)
                 return matrix[curr[0]][curr[1]];
             if(curr[1] < matrix[curr[0]].length-1)
                 minHeap.add(new int[]{curr[0],curr[1]+1});
         }
        // TODO: Write your code here
        return -1;
    }

    public static void main(String[] args) {
        MergeKSortedLists mergeKSortedLists = new MergeKSortedLists();
        ListNode l1 = mergeKSortedLists.new ListNode(2);
        l1.next = mergeKSortedLists.new ListNode(6);
        l1.next.next = mergeKSortedLists.new ListNode(8);

        ListNode l2 = mergeKSortedLists.new ListNode(3);
        l2.next = mergeKSortedLists.new ListNode(6);
        l2.next.next = mergeKSortedLists.new ListNode(7);

        ListNode l3 = mergeKSortedLists.new ListNode(1);
        l3.next = mergeKSortedLists.new ListNode(3);
        l3.next.next = mergeKSortedLists.new ListNode(4);

        ListNode result = MergeKSortedLists.merge(new ListNode[] { l1, l2, l3 });
        System.out.print("Here are the elements form the merged list: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }
}
