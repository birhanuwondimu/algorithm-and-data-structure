package com.mycompany.graph;
import  java.util.*;
public interface Monarchy {
    void birth(String child,String parent);
    void death(String name);
    List<String> getOrderOfSuccession();
}
