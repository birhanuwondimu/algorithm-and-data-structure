package com.mycompany.hashmap;

import  java.util.*;
class MyHashMap {

    /** Initialize your data structure here. */
   List<Bucket>  myMap;
   int haskey = 2069;
    public MyHashMap() {
        myMap = new java.util.ArrayList<>();
        for(int i =0;i<haskey;i++)
            myMap.add(new Bucket());

    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
       int newkey = key%haskey;
      Bucket bucket = myMap.get(newkey);
       bucket.addPair(key,value);

    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int newkey = key%haskey;
        Bucket bucket = myMap.get(newkey);
        return bucket.get(key);
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int newkey = key%haskey;
        Bucket bucket = myMap.get(newkey);
        bucket.removePair(key);
    }

    class Pair<U,V> {
        public  U first;
        public V second;
        public  Pair(U first,V second){
            this.first  =first;
            this.second = second;
        }
    }

    class Bucket {
        public List<com.mycompany.hashmap.MyHashMap.Pair> pairList;

        Bucket(){
            pairList = new java.util.ArrayList<>();
        }

        public  void addPair(Integer key,Integer val ){
            boolean faound = false;
            for(Pair p: pairList){
                if(p.first.equals(key)) {
                    p.second =val;
                    faound = true;
                }
            }
            if(!faound)
            this.pairList.add(new Pair<>(key,val));
        }

        public  void removePair(int key){
            for(Pair p : pairList)
                if((int)p.first==key)
                    pairList.remove(p);
        }

        public  int get(int key){
            for(Pair p :pairList)
                if((int)p.first == key)
                    return (int)p.second;
                return -1;
        }
    }

    public  static  void  main(String[] args){
        MyHashMap hashMap = new MyHashMap();
        hashMap.put(1, 1);
        hashMap.put(2, 2);
       int v= hashMap.get(1);            // returns 1
        int v1= hashMap.get(3);            // returns -1 (not found)
        hashMap.put(2, 1);          // update the existing value
        int v2= hashMap.get(2);            // returns 1
        hashMap.remove(2);          // remove the mapping for 2
        int v3 =  hashMap.get(2);            // returns -1 (not found)
    }
}
//[1,1],[2,2],[1],[3],[2,1],[2],[2],[2]

