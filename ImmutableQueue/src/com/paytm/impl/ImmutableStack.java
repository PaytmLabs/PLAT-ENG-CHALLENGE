package com.paytm.impl;

import com.paytm.iface.Stack;

/**
 * Created by Sunil on 6/7/2016.
 */

public class ImmutableStack<T> implements Stack<T> {

    private final T head;
    private final Stack<T> remainingElements;

    public ImmutableStack() {
        this.head = null;
        this.remainingElements = null;
    }

    private ImmutableStack(T head, Stack<T> remainingElements) {
        this.head = head;
        this.remainingElements = remainingElements;
    }

    @Override
    public Stack<T> push(T value) {
        return new ImmutableStack<>(value, this);
    }

    @Override
    public Stack<T> pop() {
        if(remainingElements == null && head == null) throw new RuntimeException("Empty Stack");
        return remainingElements;
    }

    @Override
    public T peek() {
        if(head == null) throw new RuntimeException("Empty Stack");
        return head;
    }

    @Override
    public boolean isEmpty() {
        return (head==null);
    }
}
