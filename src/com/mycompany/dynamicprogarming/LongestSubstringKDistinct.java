package com.mycompany.dynamicprogarming;
import java.util.*;
public class LongestSubstringKDistinct {
    public static int findLength(String str, int k) {

        java.util.Map<Character, Integer> map = new java.util.HashMap();
        char[] arr = str.toCharArray();
        int max = Integer.MIN_VALUE;
        int l =0;
        int n = arr.length;
        for(int i =0;i<n;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
            while(map.size()>k){
                map.put(arr[l],map.get(arr[l]-1));
                if(map.get(arr[l])==0)
                    map.remove(arr[l]);
                l++;

            }
            max = Math.max(max,i-l+1);
            /*char leftChar = s.charAt(windowStart);
            charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) - 1);
            if (charFrequencyMap.get(leftChar) == 0) {
                charFrequencyMap.remove(leftChar);
            }
            windowStart++; // shrink the window
        }
        maxLength = Math.max(maxLength, windowEnd - windowStart + 1); // remember the maximum length so far */

        }
        //abaccc  ,k=2
        //{bc}
        // TODO: Write your code here
        return max==Integer.MIN_VALUE?0:max;
    }
    public static int findLength(char[] arr) {
        int max = Integer.MIN_VALUE;
        int l =0;
        int n = arr.length;
        Map<Character,Integer> map = new HashMap<>();


        for(int i =0;i<n;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
            while(map.size()>2){
                map.put(arr[l],map.get(arr[l])-1);
                if(map.get(arr[l])==0)
                    map.remove(arr[l]);
                l++;
            }
            max = Math.max(max,i-l+1);
        }
        // TODO: Write your code here
        return max ==Integer.MIN_VALUE? 0:max;
    }

    public static int findLength(String str) {
        Set<Character>set = new HashSet<>();
        int max = Integer.MIN_VALUE;
        int l =0;
        int n =str.length();
        char[]arr = str.toCharArray();
        for(int i =0;i<n;i++){
            //set.add(arr[i]);
            while(set.contains(arr[i])){
                set.remove(arr[l]);
                l++;
            }
            set.add(arr[i]);
            max = Math.max(max,i-l+1);
        }
        // TODO: Write your code here
        return max == Integer.MIN_VALUE ?0:max;
    }

    public static int findLengthReplacement(String str, int k){
        int max =0;
        Map<Character,Integer> map = new HashMap<>();
        int l =0;
        int maxrepaingChar =0;
        int n = str.length();
        char[] arr = str.toCharArray();
        for(int i =0;i<n;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
            maxrepaingChar = Math.max(maxrepaingChar,map.get(arr[i]));
            while(i-l+1- maxrepaingChar>k){
                map.put(arr[l],map.get(arr[l])-1);
                l++;
            }
            max = Math.max(max,i-l+1);
        }

        return max;
    }

    public static int findLengthOnes(int[] arr, int k) {

        int max = 0;
        int[] zeroOne = new int[2];
        int l =0;
        int n = arr.length;
        for(int i =0;i<n;i++){
            zeroOne[arr[i]]++;
            while(zeroOne[0]>k){
                zeroOne[arr[l]]--;
                l++;
            }
            max = Math.max(max,i-l+1);
        }
        // TODO: Write your code here
        return max;
    }

    public static boolean findPermutation(String str, String pattern) {

        int n = str.length();
        char[] arr = str.toCharArray();
        Map<Character,Integer> map = new java.util.HashMap<>();
        for(char c :pattern.toCharArray())
            map.put(c,map.getOrDefault(c,0)+1);
        int l =0;
        int matchCount = 0;
        for(int i =0;i<n;i++){

            if(map.containsKey(arr[i])){
                map.put(arr[i],map.get(arr[i])-1);
                if(map.get(arr[i])==0)
                  matchCount++;

            }
            if(matchCount==map.size())
                return true;
           if(i>=pattern.length()-1) {
               //l++;
               if (map.containsKey(arr[l])) {
                   if(map.get(arr[l])==0)
                       matchCount--;
                   map.put(arr[l], map.get(arr[l]) +1);
               }
               l++;
           }
        }
        // TODO: Write your code here
        return false;
    }

    public static List<Integer> findStringAnagrams(String str, String pattern) {
        List<Integer> resultIndices = new ArrayList<Integer>();
        Map<Character,Integer> map = new HashMap<>();
        for(char c : pattern.toCharArray())
            map.put(c,map.getOrDefault(c,0)+1);

        int n = str.length();
        int matchFound =0;
        char[] arr = str.toCharArray();
        int l =0;
        for(int i =0;i<n;i++){

             if(map.containsKey(arr[i])){
                 map.put(arr[i],map.get(arr[i])-1);
                 if(map.get(arr[i])==0)
                     matchFound++;
             }
             if(matchFound==map.size())
                 resultIndices.add(l);
             if(i>=pattern.length()-1){
                 if(map.containsKey(arr[l])){
                     if(map.get(arr[l])==0)
                         matchFound--;
                     map.put(arr[l],map.get(arr[l])+1);

                 }
                 l++;
             }

        }
        // TODO: Write your code here
        return resultIndices;
    }

    public static String findSubstring(String str, String pattern) {
        Map<Character,Integer> map = new HashMap<>();
                for(char c: pattern.toCharArray())
                    map.put(c,map.getOrDefault(c,0)+1);

                int n = str.length();
                char[] arr = str.toCharArray();
                int mathCount=0;
                int minWindow = Integer.MAX_VALUE;
                int l =0;
                String res ="";
                for(int i =0;i<n;i++){
                    if(map.containsKey(arr[i])){
                        map.put(arr[i],map.get(arr[i])-1);
                        if(map.get(arr[i])==0)
                            mathCount++;

                    }
                    while(mathCount==map.size()){
                        if((i-l+1)<minWindow){
                            minWindow =i-l+1;
                            res = str.substring(l,i+1);
                        }
                        if(map.containsKey(arr[l])){
                            if(map.get(arr[l])==0)
                                mathCount--;
                            map.put(arr[l],map.get(arr[l])+1);
                        }
                        l++;
                    }
                }
        // TODO: Write your code here
        return res;
    }

    public  static void main(String[]args){
        int[] arr={0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1};
        System.out.println(findSubstring("adcad","abc"));
        //findStringAnagrams("abbcabc","abc").forEach(x->System.out.println(x));
        //"aaacb", Pattern="abc"
        //"abcdxabcde"
        //"abcdeabcdx"
    }
}
