package com.company.instance;

import com.company.support.Test;

import java.util.Stack;

/**
 * Created by yanba_000 on 11/22/2015.
 */
public class ImplementQueueWithStack implements Test{

    @Override
    public void execute() {
        MyQueue queue = new MyQueue();

        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        queue.push(5);


        System.out.println("peek:" + queue.peek());
        queue.pop();
        System.out.println("peek:" + queue.peek());
    }



    class MyQueue {

        Stack<Integer> in = new Stack<>();
        Stack<Integer> out = new Stack<>();

        // Push element x to the back of queue.
        public void push(int x) {
            in.push(x);
        }

        // Removes the element from in front of queue.
        public void pop() {
            if(out.isEmpty()){
                while(!in.isEmpty())
                    out.push(in.pop());
            }

            out.pop();
        }

        // Get the front element.
        public int peek() {
            if(out.isEmpty()){
                while(!in.isEmpty())
                    out.push(in.pop());
            }

            return out.peek();
        }

        // Return whether the queue is empty.
        public boolean empty() {
            return in.empty() && out.empty();
        }

    }

}
