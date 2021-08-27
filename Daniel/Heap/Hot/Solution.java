package Heap.Hot;

import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
        for(int s : scoville)
        {
            heap.add(s);
        }
        while(heap.peek() < K)
        {
            if(heap.size() == 1)
                return -1;
            Integer num1 = heap.remove();
            Integer num2 = heap.remove();
            if(num1 < num2)
                heap.add(num1 + num2 * 2);
            else
                heap.add(num1 * 2 + num2);
            answer++;
        }
        return answer;
    }
}
