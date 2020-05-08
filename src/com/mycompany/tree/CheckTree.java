package com.mycompany.tree;
import  com.mycompany.graph.Graph;

public class CheckTree {

        public static boolean isTree(Graph g) {
            // Write -- Your -- Code
            int n = g.getVertices();
            boolean[] visited = new boolean[n];
           com.mycompany.stack.Stack<Integer> st= new com.mycompany.stack.Stack(n);
            //visited[0] = true;
            st.push(0);
            while(!st.isEmpty()) {
                Integer curr = (Integer)st.pop();
                if(visited[curr])
                    return false;
                visited[curr] = true;
                com.mycompany.lru.DoublyLinkedList<Integer>.Node temp = null;
                if(g.getAdjacencyList()[curr] !=null)
                    temp = g.getAdjacencyList()[curr].headNode;
                while(temp !=null){
                    st.push(temp.data);
                    temp = temp.nextNode;
                }

            }
            for(int i= 0;i<n;i++){
                if(!visited[i])
                    return false;
            }
            return true;
        }

    public static int findMin(com.mycompany.graph.Graph g, int source, int destination) {
        //Write -- Your -- Code
        int n = g.getVertices();
        boolean[] visited = new boolean[n];
        com.mycompany.queue.Queue qu = new com.mycompany.queue.Queue(n);
        qu.enqueue(source);

        int level =0;

        while(!qu.isEmpty()){
            int curr = (int)qu.dequeue();
            if(curr==destination)
                return level;
            level++;
            com.mycompany.lru.DoublyLinkedList<Integer>.Node temp = null;
            if(g.getAdjacencyList()[curr] !=null)
                temp = g.getAdjacencyList()[curr].headNode;
            while(temp !=null){
                if(!visited[temp.data]){
                    visited[temp.data] = true;
                    qu.enqueue(temp.data);
                }
                temp = temp.nextNode;
            }

        }
        return -1;
    }

    public static void main(String args[]) {

        com.mycompany.graph.Graph g = new com.mycompany.graph.Graph(5);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(0,3);
        g.addEdge(3,4);
        g.printGraph();
        System.out.println("isTree : " + isTree(g));

        com.mycompany.graph.Graph g2 = new com.mycompany.graph.Graph(4);
        g2.addEdge(0,1);
        g2.addEdge(0,2);
        g2.addEdge(0,3);
        g2.addEdge(3,2);
        g2.printGraph();
        System.out.println("isTree : " + isTree(g2));

        com.mycompany.graph.Graph g3 = new com.mycompany.graph.Graph(6);
        g3.addEdge(0,1);
        g3.addEdge(0,2);
        g3.addEdge(0,3);
        g3.addEdge(4,5);
        g3.printGraph();
        System.out.println("isTree : " + isTree(g3));
    }



}

