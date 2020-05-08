package com.mycompany.dynamicprogarming;

public class MPP {
    public int findMPPCuts(String st) {
        return findMPPCutsRecursive(st.toCharArray(), 0, st.length()-1);
    }
    private  int findMPPCutsRecursive(char[]arr,int i,int j){
        if(i>=j)
            return 0;
        if(i==j)
            return 1;
        return -1;
    }
}
