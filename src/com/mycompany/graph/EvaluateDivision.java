package com.mycompany.graph;
import  java.util.*;
import  java.util.Queue;
public class EvaluateDivision {
    class Pair {
        double weight;
        String val;
        public Pair(String val,double weight){
            this.val = val;
            this.weight = weight;
        }
    }
    Map<String,List<Pair>> graph;
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        double[] result =new double[queries.size()];
        if(equations.size()!=values.length)
            return result;

        this.graph = new java.util.HashMap<>();

        for(int i =0;i<values.length;i++){
            List<String> curr = equations.get(i);

            graph.putIfAbsent(curr.get(0),new java.util.ArrayList<>());
            graph.putIfAbsent(curr.get(1),new java.util.ArrayList<>());

            graph.get(curr.get(0)).add(new Pair(curr.get(1),values[i]));
            graph.get(curr.get(1)).add(new Pair(curr.get(0),1/values[i]));
        }
        for(int i =0;i<queries.size();i++){
            result[i] = bfs(queries.get(i).get(0),queries.get(i).get(1));
        }
        return result;
    }
    double bfs(String source, String dest){

        if(graph.containsKey(source)) {
            if (source.equals(dest))
                return 1.0;
            Set<String> set = new HashSet<>();

            Queue<Pair> qu = new java.util.LinkedList<>();
            set.add(source);
            qu.add(new Pair(source, 1.0));
            while (!qu.isEmpty()) {
                Pair curr = qu.poll();
                for (Pair p : this.graph.get(curr.val)) {
                    double currwe = curr.weight * p.weight;
                    if (p.val.equals(dest))
                        return currwe;
                    if (!set.contains(p.val)) {
                        qu.add(new Pair(p.val, currwe));
                        set.add(p.val);
                    }
                }
            }
        }

        return -1.0;
    }

    public  static  void  main(String[] args){
        //equations = [ ["a", "b"], ["b", "c"] ],
        //values = [2.0, 3.0],
        //queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ].
        EvaluateDivision evaluateDivision = new EvaluateDivision();
        List<List<String>> equations = new java.util.ArrayList<>();
         //list.add("");
        equations.add(Arrays.asList(new String[]{"a","b"}));
        equations.add(Arrays.asList(new String[]{"b","c"}));
        double[] values ={2.0,3.0};

        List<List<String>> queries = new java.util.ArrayList<>();
        queries.add(Arrays.asList(new String[]{"a","c"}));
        queries.add(Arrays.asList(new String[]{"b","a"}));
        queries.add(Arrays.asList(new String[]{"a","e"}));
        queries.add(Arrays.asList(new String[]{"a","a"}));
        queries.add(Arrays.asList(new String[]{"x","x"}));
        evaluateDivision.calcEquation(equations,values,queries);
    }
}
