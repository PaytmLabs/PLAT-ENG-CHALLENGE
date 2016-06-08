package com.paytm.iface;

/**
 * Created by Sunil on 6/7/2016.
 */
public interface Stack<T> {
    Stack<T> push(T value);
    Stack<T> pop();
    T peek();
    boolean isEmpty();
}
