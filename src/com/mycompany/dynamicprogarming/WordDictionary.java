package com.mycompany.dynamicprogarming;

class WordDictionary {
    class TrieNode {
        boolean isWord;
        TrieNode[] children;
        TrieNode() {
            isWord = false;
            children = new TrieNode[26];
        }
    }
    /** Initialize your data structure here. */
    TrieNode root;
    public WordDictionary() {
        root=  new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode  curr = root;
        for(char c : word.toCharArray()){
            if(curr.children[c-'a'] ==null)
                curr.children[c-'a'] = new TrieNode();
            curr = curr.children[c-'a'];

        }
        curr.isWord = true;

    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        TrieNode  curr = root;
        return searchRec(word,curr);
    }
    public boolean searchRec(String word,TrieNode node) {
        if(node == null)
            return false;
        if(word==null || word.length()==0)
            return   node.isWord;
       boolean curr = false;
        if(word.charAt(0)=='.'){
            for(int i =0;i<26;i++)
                curr = curr|| searchRec(word.substring(1),node.children[i]);
            if(!curr)
                return false;
        }
        else
            curr = node.children[word.charAt(0)-'a'] !=null && searchRec(word.substring(1),node.children[word.charAt(0)-'a']);
        return curr;
    }

    public  static void  main(String[] args){
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("pad"));//-> false
        System.out.println(wordDictionary.search("bad")) ;//-> true
        System.out.println(wordDictionary.search(".ad")) ;//-> true
        System.out.println(wordDictionary.search("b..")) ;//-> true
    }
}