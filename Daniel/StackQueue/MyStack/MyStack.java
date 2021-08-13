package StackQueue.Truck;

import StackQueue.MyStack.MyStack;

public class Solution {
    static class MyQueue<T>
    {
        class Node<T>
        {
            T data;
            Node<T> next;
            private Node(T data)
            {
                this.data = data;
            }
        }
        Node<T> first;
        Node<T> last;

        public MyQueue()
        {
        }

        public void add(T data)
        {
            Node<T> node = new Node<T>(data);
            if(last != null)
                last.next = node;
            last = node;
            if(first == null)
                first = node;
        }
        public T remove()
        {
            if(first == null)
                return null;
            T data = first.data;
            first = first.next;
            if(first == null)
                last = null;
            return data;
        }
        public T peek()
        {
            return first.data;
        }
        public boolean isEmpty()
        {
            return first == null;
        }
    }
    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.isEmpty());
        System.out.println(stack.pop());
        System.out.println(stack.isEmpty());
    }
}
