package com.mycompany.stack;

 class MaxStack {

    /** initialize your data structure here. */
    java.util.Stack<Integer> stack;
    java.util.Stack<Integer> maxStack;

    public MaxStack() {
        stack = new java.util.Stack<>();
        maxStack = new java.util.Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if(maxStack.isEmpty() || x>=maxStack.peek())
            maxStack.push(x);

    }

    public int pop() {
        if(stack.peek().equals(maxStack.peek()))
            maxStack.pop();
        return stack.pop();

    }

    public int top() {
        return stack.peek();
    }

    public int peekMax() {
        return maxStack.peek();

    }

    public int popMax() {
        int temp = maxStack.pop();
        java.util.Stack<Integer> st = new java.util.Stack<>();
        boolean removed = false;
        while(!stack.isEmpty()){
            if(!maxStack.isEmpty())
                maxStack.pop();
            int t = stack.pop();
            if(t!=temp || removed){
                st.push(t);
                removed = true;
            }
        }
        while(!st.isEmpty())
            push(st.pop());
        return temp;
    }

}