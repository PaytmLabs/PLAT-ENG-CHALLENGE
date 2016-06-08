package com.paytm.iface;

/**
 * Created by Sunil on 6/7/2016.
 */
public interface Queue<T> {
    Queue<T> enQueue(T t);
    Queue<T> deQueue();
    T head();
    boolean isEmpty();
}
