package com.mycompany.graph;
import  java.util.*;
import  java.util.Queue;

public class CloneGraph {
    public  Node cloneGraph(Node node) {

        java.util.Map<Node, Node> map = new java.util.HashMap<>();
        Queue<Node> qu = new LinkedList<>();
        Node res =new Node(node.val);
        qu.offer(node);
        map.put(node,res);

        while(!qu.isEmpty()){
            Node original = qu.poll();
            Node  clone  = map.get(original);
            for(Node nd : original.neighbors){
                if(map.containsKey(nd)){
                    Node newNode= new Node(nd.val);
                    clone.neighbors.add(newNode);
                    map.put(nd,newNode);
                    qu.offer(nd);
                }
            }
        }
        return res;
    }

    class    Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new java.util.ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new java.util.ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public  static void  main(String[] args){
        //[[2,4],[1,3],[2,4],[1,3
        //this.Node nd = new com.mycompany.graph.CloneGraph.Node(3)
        CloneGraph cloneGraph = new CloneGraph();
    }
}
