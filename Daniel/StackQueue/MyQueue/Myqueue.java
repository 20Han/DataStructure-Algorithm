package StackQueue.MyQueue;

import StackQueue.Truck.Solution;

public class MyQueue<T> {
    class Node<T> {
        T data;
        Node<T> next;

        private Node(T data) {
            this.data = data;
        }
    }

    Node<T> first;
    Node<T> last;

    public MyQueue() {
    }

    public void add(T data) {
        Node<T> node = new Node<T>(data);
        if (last != null)
            last.next = node;
        last = node;
        if (first == null)
            first = node;
    }

    public T remove() {
        if (first == null)
            return null;
        T data = first.data;
        first = first.next;
        if (first == null)
            last = null;
        return data;
    }

    public T peek() {
        return first.data;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.peek());
        System.out.println(queue.isEmpty());
        System.out.println(queue.remove());
        System.out.println(queue.isEmpty());
    }
}
