package com.paytm.util;

import com.paytm.iface.Stack;
import com.paytm.impl.ImmutableStack;

/**
 * Created by Sunil on 6/7/2016.
 */
public class ImmutableStackUtil<T> {

    public Stack<T> reverseStack (Stack<T> stack) {
        Stack<T> reverse = new ImmutableStack();
        for (Stack<T> first = stack; !first.isEmpty(); first= first.pop()) {
            reverse = reverse.push(first.peek());
        }
        return reverse;
    }
}
