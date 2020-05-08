package com.mycompany.tree;
import  java.util.*;
import com.mycompany.tree.TreeNode;

public class LevelAverage {
    public static List<Double> findLevelAverages(TreeNode root) {
        java.util.List<Double> result = new java.util.ArrayList<>();
        // TODO: Write your code here
        if(root==null)
            return result;
        java.util.Queue<TreeNode> qu = new java.util.LinkedList<>();
        qu.add(root);
        while(!qu.isEmpty()){
            int levelSize= qu.size();
            int s = levelSize;
            double levelSum =0;
            while(s-->0){
                TreeNode curr = qu.poll();
                levelSum +=curr.val;
                if(curr.left !=null)
                    qu.add(curr.left);
                if(curr.right !=null)
                    qu.add(curr.right);
            }
            result.add(levelSum/levelSize);
        }
        return result;
    }

}
