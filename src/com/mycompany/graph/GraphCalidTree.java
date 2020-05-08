package com.mycompany.graph;
import java.util.*;
public class GraphCalidTree {
    public boolean validTree(int n, int[][] edges) {

        Map<Integer,List<Integer>> graph = new java.util.HashMap<>();
        for(int[] edge : edges){
            int i =edge[0];
            int j =edge[1];

            graph.putIfAbsent(i, new java.util.ArrayList<>());
            graph.putIfAbsent(j, new java.util.ArrayList<>());

            graph.get(i).add(j);
            graph.get(j).add(i);

        }

        boolean[] visited = new boolean[n];
        boolean[] onStack = new boolean[n];
        if(!dfs(visited,onStack,graph,0))
            return false;

        for(int i =0;i<n;i++)
            if(!visited[i])
                return false;

        return true;

    }

    private boolean dfs(boolean[] visited, boolean[] onStack,Map<Integer,List<Integer>> graph, int node){

        java.util.Stack<Integer>st = new java.util.Stack<>();
        st.push(node);
        visited[node] = true;
        Map<Integer,Integer> parent = new java.util.HashMap<>();
        while(!st.isEmpty()) {
            int curr = st.pop();
            if(graph.containsKey(curr)) {
                for (int n : graph.get(curr)) {
                    if(parent.containsKey(n)) {
                        if (visited[n] && n == parent.get(n))
                            return false;
                    }
                    //visited[n] = true;
                    st.push(n);
                    parent.put(n, curr);

                }
            }
        }
        return true;
    }

    public static void main(String[]args){
        GraphCalidTree graph = new GraphCalidTree();
        int[][] edges ={{0,1}, {0,2}, {0,3}, {1,4}};
        graph.validTree(5,edges);
    }
}
