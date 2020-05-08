package com.mycompany.graph;

import  java.util.*;
public class GraphExercise {
    Map<Integer,List<Integer>> graph;
    int[][] mGraph;
    int [] colors;
    List<List<Integer>> res;

    public  boolean pathExist(int[][] nodes,int p, int q){
        int n = nodes.length;
         graph = new java.util.HashMap<>();
        for(int[] node : nodes){
            graph.putIfAbsent(node[0],new java.util.ArrayList<>());
            graph.get(node[0]).add(node[1]);
        }

      return dfs(new boolean[n],p,q);
    }

    boolean dfs(boolean[] visited,int p, int q){

        if(p==q)
            return true;
        if(visited[p])
            return false;
        visited[p] =true;
        if(graph.containsKey(p)){
            for(int n : graph.get(p))
                if(dfs(visited,n,q))
                    return true;
        }
        return false;
    }

    public  boolean cycleExisit(int[][] gaph){
        Map<Integer,List<Integer>> g = new java.util.HashMap<>();
        for(int[] num : gaph){
            g.putIfAbsent(num[0],new java.util.ArrayList<>());
            g.putIfAbsent(num[1],new java.util.ArrayList<>());
            g.get(num[0]).add(num[1]);
            g.get(num[1]).add(num[0]);
        }
        boolean[] visited = new boolean[g.size()];
        for(int i =0;i<g.size();i++) {
            if(!visited[i])
             if(cycleDfs(g,visited,i,-1 ))
                 return true;
        }
        return false;
    }

    public boolean cycleDfs(Map<Integer,List<Integer>> graph,boolean[] visited,int v, int parent){

        visited[v] = true;
        if(graph.containsKey(v)){
            for(int n : graph.get(v)){
                if(!visited[n]){
                    if(cycleDfs(graph,visited,n,v))
                        return true;
                }
                else if(n !=parent)
                    return true;
                //return false;
            }
        }
        return false;
    }

   public List<List<Integer>> mColoringProblem(int[][] graph,int m){
        mGraph = graph;
        colors = new int[graph.length];
        res = new java.util.ArrayList<>();
        Arrays.fill(colors,0);
         dfsColoring(0,m,new java.util.ArrayList<>());
         return res;
   }

   private  boolean isSafe(int c,int v){
        for(int i =0;i<mGraph.length;i++){
            if(mGraph[v][i]==1 && c==colors[i])
                return false;
        }
        return true;
   }

   private  void dfsColoring(int v, int m,List<Integer> temp){
        if(v==mGraph.length) {
            res.add(temp);
            return ;
        }

        for(int c =1;c<=m;c++){
            if(isSafe(c,v)){
                colors[v]=c;
                List<Integer> curr = new java.util.ArrayList<>(temp);
                curr.add(c);
                dfsColoring(v+1,m,curr);
                colors[v] =0;
            }
        }
   }

    public  static  void  main(String[]args){

        GraphExercise graphExercise = new GraphExercise();
     //g1.addEdge(1, 0);
        //        g1.addEdge(0, 2);
        //        g1.addEdge(2, 1);
        //        g1.addEdge(0, 3);
        //        g1.addEdge(3, 4);
        int[][] g ={{0,1},{1,2}};
        System.out.println(graphExercise.cycleExisit(g));
    }
}
