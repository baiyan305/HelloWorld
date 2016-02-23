package com.company.instance;

import com.company.support.Test;

import java.util.Queue;
import java.util.LinkedList;

/**
 * Created by yanba_000 on 11/22/2015.
 */
public class ImplementStackUsingQueues implements Test{

    @Override
    public void execute() {

    }

    class MyStack {

        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        // Push element x onto stack.
        public void push(int x) {
            q1.add(x);
            while(!q2.isEmpty())
                q1.add(q2.poll());

            Queue<Integer> tmp = q1;
            q1 = q2;
            q2 = tmp;
        }

        // Removes the element on top of the stack.
        public void pop() {
            q2.poll();
        }

        // Get the top element.
        public int top() {
            return q2.peek();
        }

        // Return whether the stack is empty.
        public boolean empty() {
            return q1.isEmpty();
        }
    }

}
