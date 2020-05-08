package com.mycompany.graph;
import  java.util.*;
public class Person {
    String name;

    public static java.util.concurrent.atomic.AtomicInteger getCount() {
        return count;
    }

    private static final java.util.concurrent.atomic.AtomicInteger count
            = new java.util.concurrent.atomic.AtomicInteger(0);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public java.util.List<Person> getChildreen() {
        return childreen;
    }

    public void setChildreen(java.util.List<Person> childreen) {
        this.childreen = childreen;
    }

    public boolean isDead() {
        return isDead;
    }

    public void setDead(boolean dead) {
        isDead = dead;
    }

    List<Person> childreen;
    boolean isDead;
    public Person(String name){
        this.name = name;
        this.childreen = new java.util.ArrayList<>();
        this.isDead =false;
        count.incrementAndGet();

    }
}
