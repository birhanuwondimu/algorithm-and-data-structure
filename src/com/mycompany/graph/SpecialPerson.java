package com.mycompany.graph;

public class SpecialPerson {

    String name = "batman";

    String fullName = init();

    public SpecialPerson() {
        name = "superMan";
    }

    private String init() {
        return name;
    }

    public void print() {
        System.out.println(fullName);
    }
    public  static  void  main(String[] args){
        SpecialPerson specialPerson = new SpecialPerson();
        specialPerson.print();
    }
}