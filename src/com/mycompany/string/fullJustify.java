package com.mycompany.string;
import  java.util.*;
public class fullJustify {
    public static List<String> fullJustify(String[] words, int maxWidth) {

        java.util.List<String> res = new java.util.ArrayList<>();
        java.util.List<String> temp = new java.util.ArrayList<>();

        int len =0;
        for(String word :words ){

            if(len +word.length() > maxWidth) {
                res.add(helper(temp,maxWidth,len));
               len=0;
                temp = new java.util.ArrayList<>();
            }
            len +=word.length()+1;
            temp.add(word);
        }
        if(temp.size()>1){
            StringBuilder sb = new StringBuilder(temp.get(0));
            for(int i =1;i<temp.size();i++){
                sb.append(temp.get(i));
                sb.append(" ");
            }
            int remi = maxWidth-sb.length();
            for(int i =0;i<remi;i++)
                sb.append(" ");
            res.add(sb.toString());
        }
        return res;
    }

    private static  String helper( List<String> list, int maxWidth,int  len) {
        StringBuilder sb = new StringBuilder();
        if (list.size() == 1) {
            sb.append(list.get(0));
            for (int i = 0; i < maxWidth - list.get(0).length(); i++) sb.append(" ");
            return sb.toString();
        }
        int textLen = len - list.size();
        int spaces = maxWidth - textLen;
        int avg = spaces / (list.size() - 1);
        int extra = spaces % (list.size() - 1);
        for (int i = 0; i < list.size() - 1; i++) {
            sb.append(list.get(i));
            for (int j = 0; j < avg; j++) sb.append(" ");
            if (extra-- > 0) sb.append(" ");
        }
        sb.append(list.get(list.size() - 1));
        return sb.toString();
    }

    public  static  void  main(String[] args){
        String[] just = {"ask","not","what","your","country","can","do","for","you","ask","what","you","can","do","for","your","country"};
        System.out.println(fullJustify(just,16));
    }
}
