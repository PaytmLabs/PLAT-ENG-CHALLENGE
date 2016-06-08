package com.paytm.impl;

import com.paytm.iface.Queue;
import com.paytm.iface.Stack;
import com.paytm.util.ImmutableStackUtil;

/**
 * Created by Sunil on 6/7/2016.
 */
public class ImmutableQueue<T> implements Queue<T>{

    private final Stack<T> primaryStackInOrder;
    private final Stack<T> secondaryStackInReverseOrder;

    public ImmutableQueue() {
        this.primaryStackInOrder = new ImmutableStack();
        this.secondaryStackInReverseOrder = new ImmutableStack();
    }

    private ImmutableQueue(Stack<T> primaryStackInOrder, Stack<T> secondaryStackInReverseOrder) {
        this.primaryStackInOrder = primaryStackInOrder;
        this.secondaryStackInReverseOrder = secondaryStackInReverseOrder;
    }

    @Override
    public Queue<T> enQueue(T t) {
        if(primaryStackInOrder.isEmpty() && secondaryStackInReverseOrder.isEmpty()) {
            return new ImmutableQueue<>(primaryStackInOrder.push(t), secondaryStackInReverseOrder);
        }
        return new ImmutableQueue<>(primaryStackInOrder, secondaryStackInReverseOrder.push(t));
    }

    @Override
    public Queue<T> deQueue() {
        if(isEmpty()) {
            throw new RuntimeException("Empty queue");
        }

        Stack<T> updatedStack = primaryStackInOrder.pop();
        // if first stack is not empty, copy references
        // if first stack is empty, then check if second is also empty
        // if second is empty too then the queue is empty, return empty queue
        // if second is not empty, then elements in secondary stack are in reverse queue order, reverse them again
        // and assign them as primary stack elements
        if(!updatedStack.isEmpty()) {
            return new ImmutableQueue<>(updatedStack, secondaryStackInReverseOrder);
        } else if(secondaryStackInReverseOrder.isEmpty()) {
            return new ImmutableQueue<>();
        } else {
            return new ImmutableQueue<>(new ImmutableStackUtil<T>().reverseStack(secondaryStackInReverseOrder), new ImmutableStack());
        }
    }

    @Override
    public T head() {
        if(isEmpty()) throw new RuntimeException("Empty queue");
        return primaryStackInOrder.peek();
    }

    @Override
    public boolean isEmpty() {
        return primaryStackInOrder.isEmpty() && secondaryStackInReverseOrder.isEmpty();
    }
}
