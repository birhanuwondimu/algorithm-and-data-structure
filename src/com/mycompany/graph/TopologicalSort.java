package com.mycompany.graph;
import  java.util.*;
public class TopologicalSort {
    class Node {
        int indegre;
        int val;
        List<Node> childreen;
        public Node(int val){
            this.indegre =0;
            this.val = val;
            childreen = new ArrayList<>();

        }
    }

    public static String alienOrder(String[] words) {
        Map<Character,List<Character>> graph = new java.util.HashMap<>();
        int[] inDegre = new int[26];

        Set<Character> seen = new java.util.HashSet<>();
        for(String  str: words)
            for(char c :str.toCharArray())
                if(!seen.contains(c))
                    seen.add(c);

                for(char c : seen)
                    inDegre[c-'a']=0;

        for(int i =0;i<words.length-1;i++){
            String curr = words[i];
            String next = words[i+1];
            int minlen = Math.min(curr.length(),next.length());
            for(int j =0;j<minlen;j++){
                char currChar =curr.charAt(j);
                char nextChar =next.charAt(j);
                if(currChar != nextChar){
                    graph.putIfAbsent(currChar, new java.util.ArrayList<>());
                    graph.get(currChar).add(nextChar);
                    inDegre[nextChar-'a']++;
                    break;
                }
            }
        }

        java.util.Queue<Character> qu = new java.util.PriorityQueue<>();

        for(char c: seen)
            if(inDegre[c-'a']==0)
                qu.add(c);

        StringBuilder sb = new StringBuilder();
        while(!qu.isEmpty()){
            char curr = qu.poll();
            sb.append(curr);
            if(graph.containsKey(curr)) {
                for (char ch : graph.get(curr)){
                    inDegre[ch-'a']--;
                    if(inDegre[ch-'a']==0)
                        qu.add(ch);
                }
            }
        }
     return sb.toString().length()!=seen.size()? "" :sb.toString();
    }

    public static List<Integer> sort(int vertices, int[][] edges) {
        TopologicalSort topologicalSort = new TopologicalSort();
        List<Integer> sortedOrder = new ArrayList<>();
        Map<Integer,Node> graph = new HashMap<>();
        for(int[] edge :edges){
            graph.putIfAbsent(edge[0], topologicalSort.new Node(edge[0]));
            graph.putIfAbsent(edge[1], topologicalSort.new Node(edge[1]));


            graph.get(edge[0]).childreen.add(graph.getOrDefault(edge[1],topologicalSort.new Node(edge[1])));
            graph.get(edge[1]).indegre++;

        }
        java.util.Queue<Node> qu = new java.util.ArrayDeque<>();
        for(Map.Entry<Integer, Node> et : graph.entrySet()){
            if(et.getValue().indegre==0) {
                qu.add(et.getValue());
            }
        }
        while(!qu.isEmpty()){
            Node curr = qu.poll();
            sortedOrder.add(curr.val);
            if(graph.containsKey(curr.val)){
                for(Node nd : graph.get(curr.val).childreen){
                    nd.indegre--;
                    if(nd.indegre == 0)
                        qu.add(nd);
                }
            }
        }
        // TODO: Write your code here
        return sortedOrder.size() != vertices? new ArrayList<>():sortedOrder;
    }

    public static boolean isSchedulingPossible(int tasks, int[][] prerequisites) {
        TopologicalSort topologicalSort = new TopologicalSort();
        int count =0;
        Map<Integer,Node> graph = new HashMap<>();
        for(int[] edge :prerequisites){
            graph.putIfAbsent(edge[0], topologicalSort.new Node(edge[0]));
            graph.putIfAbsent(edge[1], topologicalSort.new Node(edge[1]));


            graph.get(edge[0]).childreen.add(graph.getOrDefault(edge[1],topologicalSort.new Node(edge[1])));
            graph.get(edge[1]).indegre++;

        }
        java.util.Queue<Node> qu = new java.util.ArrayDeque<>();
        for(Map.Entry<Integer, Node> et : graph.entrySet()){
            if(et.getValue().indegre==0) {
                qu.add(et.getValue());
            }
        }
        while(!qu.isEmpty()){
            Node curr = qu.poll();
            count++;
            if(graph.containsKey(curr.val)){
                for(Node nd : graph.get(curr.val).childreen){
                    nd.indegre--;
                    if(nd.indegre == 0)
                        qu.add(nd);
                }
            }
        }
        // TODO: Write your code here
        return count != tasks? false:true;
    }

    public void allScheduleDFS(List<List<Integer>> result,Map<Integer,Node> graph,Node nd, List<Integer> list){
        if(graph.get(nd.val).childreen ==null){
            result.add(list);
            return;
        }
        for(Node node : graph.get(nd.val).childreen){

        }
    }

    public  static void  main(String[] args){
        boolean result = com.mycompany.graph.TopologicalSort.isSchedulingPossible(3, new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 } });
        System.out.println("Tasks execution possible: " + result);

        result = TopologicalSort.isSchedulingPossible(3,
                new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 }, new int[] { 2, 0 } });
        System.out.println("Tasks execution possible: " + result);

        result = TopologicalSort.isSchedulingPossible(6, new int[][] { new int[] { 2, 5 }, new int[] { 0, 5 },
                new int[] { 0, 4 }, new int[] { 1, 4 }, new int[] { 3, 2 }, new int[] { 1, 3 } });
        System.out.println("Tasks execution possible: " + result);
    }
}

