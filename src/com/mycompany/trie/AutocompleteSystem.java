package com.mycompany.trie;

import  java.util.*;
class AutocompleteSystem {

    class TriNode {
        int fequency;
        String word;
        Map<Integer,TriNode> children;
        TriNode(){
            fequency =0;
            children = new java.util.HashMap<>();
            word = null;
        }
    }

    private void buildTrie(String sentences, int times){
        TriNode curr =  root;
        for(char c : sentences.toCharArray()){
            if(!curr.children.containsKey(charToInt(c))) {
                curr.children.put(charToInt(c), new TriNode());
            }
            curr = curr.children.get(charToInt(c));
        }
        curr.fequency = times;
        curr.word = sentences;
    }

    private List<String> searchInput(char c){

        TriNode  temp =  root;
        java.util.List<String> result = new java.util.ArrayList<>();
        if(c=='#'){
            /*curr.fequency +=1;
            if(curr.word ==null)
            curr.word = inputSofar.toString();
            inputSofar = new StringBuilder();
            curr = root;*/
            TriNode node =getPrefixNode(inputSofar.toString());
            node.fequency +=1;
            node.word = inputSofar.toString();
            inputSofar = new StringBuilder();
            return result;
        }

        inputSofar.append(c);



         temp = getPrefixNode(inputSofar.toString());

        qu = new java.util.PriorityQueue<TriNode>((a,b)->(
                a.fequency ==b.fequency ?b.word.compareTo(a.word):a.fequency-b.fequency
        ));
            searchInputRec(temp);

        while(!qu.isEmpty()){
            result.add(0,qu.poll().word);
        }

        //curr = curr.children.get(charToInt(c));
        return result;

    }

    private void searchInputRec( TriNode node){

        if(node==null)
            return ;
        if(node.fequency>0){
            qu.offer(node);
            if(qu.size()>3)
                qu.poll();
        }
        for(java.util.Map.Entry<Integer,TriNode> et :node.children.entrySet() ){
            searchInputRec(et.getValue());
        }

    }

    private TriNode getPrefixNode(String str){
        TriNode curr = root;

        for(char c : str.toCharArray()){
            if(!curr.children.containsKey(charToInt(c)))
                curr.children.put(charToInt(c),new TriNode());
            curr = curr.children.get(charToInt(c));
        }
      return curr;
    }

    TriNode root;
    //TriNode curr;
    StringBuilder inputSofar;
    java.util.Queue<TriNode>  qu;
    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new TriNode();
        //curr = root;
        inputSofar = new StringBuilder();

        for(int i =0;i<sentences.length;i++){
            buildTrie(sentences[i],times[i]);
        }

    }
    private int charToInt(char c){
        return c==' '? 26:c-'a';
    }

    public List<String> input(char c) {
        return searchInput(c);
    }

    public  static  void main(String[]args){
       //["AutocompleteSystem","input","input","input","input","input","input","input","input","input","input","input","input"]
        //[[["i love you","island","iroman","i love leetcode"],[5,3,2,2]],["i"],[" "],["a"],["#"],["i"],[" "],["a"],["#"],["i"],[" "],["a"],["#"]]
        String[] sentences = {"i love you","island","iroman","i love leetcode"};
        int[] times = {5,3,2,2};
        AutocompleteSystem  ob= new AutocompleteSystem(sentences, times);
        ob.input('i');
        ob.input(' ');
        ob.input('a');
        ob.input('#');

        ob.input('i');
        ob.input(' ');
        ob.input('a');
        ob.input('#');

        ob.input('i');
        ob.input(' ');
        ob.input('a');
        ob.input('#');

    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */