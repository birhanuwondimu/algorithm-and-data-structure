package com.mycompany.graph;
import  java.util.*;
import  java.util.Stack;

public class MonarchyEmpl implements com.mycompany.graph.Monarchy {
    Map<String, com.mycompany.graph.Person> monary;
  String kingId;

    public  MonarchyEmpl(String name){
        //this.king = king;

        monary = new HashMap<>();
        com.mycompany.graph.Person k = new com.mycompany.graph.Person(name);
        monary.put(k.getCount().toString(),k);
        this.kingId = k.getCount().toString();
    }
    @Override
    public void birth(String child, String parent) {
         com.mycompany.graph.Person newBorn = new com.mycompany.graph.Person(child);
         for(com.mycompany.graph.Person p : monary.values()) {
             if(p.name ==parent) {
                 p.getChildreen().add(newBorn);
                 break;
             }
            // monary.get(parent).getChildreen().add(newBorn);
            //
         }
        monary.put(newBorn.getCount().toString(), newBorn);

    }

    @Override
    public void death(String name) {
        for(com.mycompany.graph.Person p : monary.values())
            if(p.name==name){
                p.isDead = true;
            }
    }

    @Override
    public java.util.List<String> getOrderOfSuccession() {

        Stack<String> stack= new Stack<>();
        stack.add(kingId);
        List<String> res = new ArrayList<>();
        while(!stack.isEmpty()){
            String name = stack.pop();
            com.mycompany.graph.Person person = monary.get(name);
            if(!person.isDead())
                res.add(person.name);
            for(int i = person.childreen.size()-1;i>=0;i--){
                stack.add(person.childreen.get(i).getCount().toString());
            }
        }
        return res;
    }
}
