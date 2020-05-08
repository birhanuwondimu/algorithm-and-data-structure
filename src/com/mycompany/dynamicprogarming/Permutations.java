package com.mycompany.dynamicprogarming;
import  java.util.Queue;
import  java.util.List;
public class Permutations {
    public static List<List<Integer>> findPermutations(int[] nums) {
        List<List<Integer>> res = new java.util.ArrayList<>();
        Queue<List<Integer>> qu = new java.util.LinkedList<>();
        qu.add(new java.util.ArrayList<>());
        for(int num :nums){
           int s = qu.size();
            for(int i =0;i<s;i++){
                List<Integer> prev = qu.poll();
                for(int j =0;j<= prev.size();j++){
                    List<Integer> temp = new java.util.ArrayList<>(prev);
                     temp.add(j,num);
                     if(temp.size()==nums.length)
                         res.add(temp);
                     else
                         qu.add(temp);
                }

            }
        }
      return res;
    }

    public static List<String> findLetterCaseStringPermutations(String str) {
        List<String> permutations = new java.util.ArrayList<>();
        Queue<String> qu = new java.util.LinkedList<>();
        qu.add("");
        for(char c : str.toCharArray()){
            int s = qu.size();
            for(int i =0;i<s;i++){
                String curr = qu.poll();
                for(int j =0;i<=curr.length();j++){
                    //curr = curr
                }
            }
        }
       // findLetterCaseStringPermutationsrec(permutations,str,new StringBuilder(),0);
        return permutations;
    }

    private  static  void findLetterCaseStringPermutationsrec( List<String> permutations ,String str, StringBuilder temp,int i){
        if(i==str.length()){
            permutations.add(temp.toString());
            return;
        }
        char curr = str.charAt(i);
        findLetterCaseStringPermutationsrec(permutations,str,new StringBuilder(temp.append(curr)),i+1);
        if(Character.isLetter(curr)){
            if(Character.isLowerCase(curr))
                findLetterCaseStringPermutationsrec(permutations,str,new StringBuilder(temp.append(Character.toUpperCase(curr))),i+1);
            else
                findLetterCaseStringPermutationsrec(permutations,str,new StringBuilder(temp .append(Character.toLowerCase(curr))),i+1);
        }

    }

    public static void main(String[] args) {
        List<String> result = findLetterCaseStringPermutations("ad52");
        System.out.println(" String permutations are: " + result);

        result = findLetterCaseStringPermutations("ab7c");
        System.out.println(" String permutations are: " + result);
    }
}
