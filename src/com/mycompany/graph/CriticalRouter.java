package com.mycompany.graph;
// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
import java.util.List;
import java.util.ArrayList;
// CLASS BEGINS, THIS CLASS IS REQUIRED
public class CriticalRouter {
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    List<Integer> criticalRouters(int numRouters, int numLinks,
                                  ArrayList<ArrayList<Integer>> links) {
        // WRITE YOUR CODE HERE
        boolean[] visitedRouters = new boolean[numRouters];
        List<List<Integer>> crcalRouters = new ArrayList();
        java.util.Map<Integer, java.util.List<Integer>> map = new java.util.HashMap<>();
        int[] lowLinks = new int[numLinks];

        int cycle = 0;
        for (List<Integer> link : links) {
            int v1 = link.get(0);
            int v2 = link.get(1);
            map.putIfAbsent(v1, new ArrayList());
            map.putIfAbsent(v2, new ArrayList());

            map.get(v1).add(v2);
            map.get(v2).add(v1);
        }
        for (int i = 0; i < map.size(); i++) {
            if (!visitedRouters[i])
                dfs(i, i, visitedRouters, lowLinks, map, cycle,crcalRouters);
        }
  return new java.util.ArrayList<>();
    }
    private void dfs(int curVertice, int parentVertice, boolean[] visitedRouters,
             int[] links, java.util.Map<Integer, java.util.List<Integer>> map,
             int cycle, List<List<Integer>> criticalRouters){
        cycle++;
        links[curVertice] =cycle;
        int discoveredValue = cycle;
        visitedRouters[curVertice] = true;
        for(int vertice: map.get(curVertice)){
            if(vertice==parentVertice)
                continue;
            if(!visitedRouters[vertice]){
                dfs(vertice,curVertice,visitedRouters,links,map,cycle,criticalRouters);
                if(discoveredValue < links[vertice])
                    criticalRouters.add(java.util.Arrays.asList(curVertice,vertice));
            }
            links[curVertice] = Math.min(links[curVertice],links[vertice]);

        }

    }
    // METHOD SIGNATURE ENDS
}