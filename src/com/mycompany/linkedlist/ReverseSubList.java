package com.mycompany.linkedlist;

class ReverseSubList {
    class ListNode {
        int value = 0;
        ListNode next;

        ListNode(int value) {
            this.value = value;
        }
    }


    public static ListNode reverse(ListNode head, int p, int q) {
        // TODO: Write your code here
        ListNode pre = null;
        ListNode curr = head;

        while (curr != null) {
            if(curr.value == p)
                break;
            pre = curr;
            curr = curr.next;

            }
            ListNode prev1 = null;
            while (curr != null) {
                if( curr.value == q)
                    break;
                ListNode temp = curr.next;
                curr.next = prev1;
                prev1 = curr;
                curr = temp;
            }
            pre.next.next = curr.next;
            curr.next = prev1;
            pre.next = curr;
            return head;
        }

        public static void main (String[]args){
            ReverseSubList reverseSubList = new ReverseSubList();
            ListNode head = reverseSubList.new ListNode(1);
            head.next = reverseSubList.new ListNode(2);
            head.next.next = reverseSubList.new ListNode(3);
            head.next.next.next = reverseSubList.new ListNode(4);
            head.next.next.next.next = reverseSubList.new ListNode(5);

            ListNode result = ReverseSubList.reverse(head, 2, 4);
            System.out.print("Nodes of the reversed LinkedList are: ");
            while (result != null) {
                System.out.print(result.value + " ");
                result = result.next;
            }
        }
}