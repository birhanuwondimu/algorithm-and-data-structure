package com.mycompany.lru;
class LRUCache {

    public class DlinkedList {
        int key;
        int val;
        DlinkedList next;
        DlinkedList prev;

        public DlinkedList(int key,int val){
            this.key = key;
            this.val = val;
        }
    }

    public void addNode(DlinkedList  node){
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;

    }

    public void removeNode(DlinkedList  node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public DlinkedList popTail(){
        DlinkedList node = tail.prev;
        removeNode(node);
        return node;
    }

    public void movetoHead(DlinkedList node){
        removeNode(node);
        addNode(node);

    }

    private java.util.Map<Integer, com.mycompany.lru.LRUCache.DlinkedList> cache = new java.util.HashMap<>();
    private int size;
    private int capacity;
    private DlinkedList  head,tail;
    public LRUCache(int capacity) {
        //this.cache = new HashMap<>();
        this.size =0;
        this.capacity = capacity;

        this.head = new DlinkedList(0,0);;
        this.tail = new DlinkedList(0,0);;

        this.head.next = this.tail;
        this.tail.prev = this.head;

    }

    public void put(int key, int val){
        DlinkedList node = cache.get(key);
        if(node ==null){
            DlinkedList nd = new DlinkedList(key,val);
            cache.put(key,nd);
            addNode(nd);
            size++;
            if(size>capacity){
                DlinkedList tail = popTail();
                cache.remove(tail.key);
                size--;
            }
        }
        else{
            node.val = val;
            movetoHead(node);

        }
    }

    public int get(int key){
        DlinkedList node = cache.get(key);
        if(node==null)
            return -1;
        movetoHead(node);
        return node.val;

    }

}

