package com.mycompany.queue;

class MyCircularQueue {

    class Node{
        int val;
        Node next;
        Node(int val){
            this.val = val;
            this.next = null;
        }
    }

    /** Initialize your data structure here. Set the size of the queue to be k. */
    Node tail;
    Node head;
    int size;
    int count;
    public MyCircularQueue(int k) {
        this.size =k;
        this.tail = null;
        this.head = null;
        this.head.next= tail;
        this.count =0;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(count==size)
            return false;
        Node nd = new Node(value);
        if(count==0){
            head= nd;
            tail = nd;
            head.next = tail;
            count++;
        }
        else{
            nd.next = tail;
            tail = nd;
            head.next = tail;
        }
        return true;

    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(count==0)
            return false;
        if(head ==tail) {
            head =null;
            tail = null;
        }
        else{
            Node curr = tail;
            while(curr.next !=head){
                curr= curr.next;
            }
            curr.next = tail;
            head = curr;
        }
        return true;

    }

    /** Get the front item from the queue. */
    public int Front() {
        if(isEmpty())
            return -1;
        return head.val;

    }

    /** Get the last item from the queue. */
    public int Rear() {
        return tail.val;
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return count ==0;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return count==size;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */