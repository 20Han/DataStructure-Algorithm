import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};

        MyQueue<Integer> progressesQueue = new MyQueue<>();
        MyQueue<Integer> speedsQueue = new MyQueue<>();
        MyQueue<Integer> answerQueue = new MyQueue<>();

        for (int progress : progresses) {
            progressesQueue.offer(progress);
        }

        for (int speed : speeds) {
            speedsQueue.offer(speed);
        }

        int day = 0;
        int releasedWorksCount = 0;

        while (!progressesQueue.isEmpty() && !speedsQueue.isEmpty()) {

            if (progressesQueue.peek() + day * speedsQueue.peek() >= 100) {
                progressesQueue.poll();
                speedsQueue.poll();

                releasedWorksCount++;

                if (progressesQueue.isEmpty()) {
                    if (releasedWorksCount != 0) {
                        answerQueue.offer(releasedWorksCount);
                        break;
                    }
                }
                continue;
            }

            if (releasedWorksCount != 0) {
                answerQueue.offer(releasedWorksCount);
            }

            releasedWorksCount = 0;

            day++;
        }

        answer = new int[answerQueue.size()];
        
        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerQueue.poll();
        }
        
        return answer;
    }
    
    public static class MyNode<E> {
        E data;
        MyNode<E> next;

        public MyNode(E data) {
            this.data = data;
            this.next = null;
        }
    }
    
    public static class MyQueue<E>  {

        private MyNode<E> head;
        private MyNode<E> tail;
        private int size = 0;

        public int size() {
            return size;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean offer(E e) {
            MyNode<E> newNode = new MyNode<>(e);

            if (isEmpty()) {
                head = newNode;
            } else {
                tail.next = newNode;
            }

            tail = newNode;
            size++;

            return true;
        }

        public E poll() {
            if (isEmpty())
                return null;

            E element = head.data;

            MyNode<E> nextNode = head.next;

            head.data = null;
            head.next = null;

            head = nextNode;
            size--;

            return element;
        }

        public E peek() {
            if (isEmpty())
                return null;

            return head.data;
        }
    }
}
