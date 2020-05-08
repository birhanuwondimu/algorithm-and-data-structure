package com.mycompany.dynamicprogarming;
import  java.util.*;
class  WordSearchII {
class TrieNode{
    String word;
    TrieNode[] children;
    TrieNode(){
        this.word = null;
        this.children = new TrieNode[26];
    }
}
    private void buildTrie(String word){
        TrieNode  curr = root;
        for(char c : word.toCharArray()){
            if(curr.children[c-'a'] ==null)
                curr.children[c-'a'] = new TrieNode();
            curr = curr.children[c-'a'];
        }
        curr.word = word;
    }

    private boolean search(String word) {
        TrieNode  curr = root;
        for(char c : word.toCharArray()){
            if(curr ==null)
                return false;
            curr = curr.children[c-'a'];
        }
        return curr.word  !=null;

    }

    java.util.List<String> result = new java.util.ArrayList<>();
    char[][] board;
    int n;
    int m;
    TrieNode root;
    public List<String> findWords(char[][] board, String[] words) {
        this.board =  board;
        this.n = board.length;
        this.m = board[0].length;
        if(n==0 || m==0 || words.length==0)
            return result;
        root = new TrieNode();
        for(String str : words)
            buildTrie(str);
        for(int i =0 ;i<n;i++)
            for(int j =0;j<m;j++){
                TrieNode curr = root;
                char c = board[i][j];
                if( curr.children[c-'a'] !=null){
                    dfs(i,j, curr);
                }
            }

        return result;
    }

    private  void dfs(int i,int j,TrieNode node){

        if(node==null)
            return;
        char letter = board[i][j];
        TrieNode currNode = node.children[letter-'a'];

        if(currNode.word !=null) {
            if(!result.contains(currNode.word))
                this.result.add(currNode.word);
            return ;
        }

        board[i][j] ='#';

        int[][] dir ={{1,0},{0,1},{-1,0},{0,-1}};
        for(int k =0;k<4;k++){
            int r = i+dir[k][0];
            int c = j +dir[k][1];
            if( r>=0 &&r<n && c>=0 && c<m && board[r][c] !='#' && currNode.children[board[r][c]-'a'] !=null) {
                dfs(r, c, currNode);
            }
        }
        board[i][j] = letter;

    }

    public  static  void  main(String[] args){
        //[["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]]
        //["oath","pea","eat","rain"]
        char[][] board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        String[] words ={"oath","pea","eat","rain"};
        //[["a"]]
        //["a"]
        WordSearchII wordSearchII = new WordSearchII();
        System.out.println(wordSearchII.findWords(board,words));

    }
}
