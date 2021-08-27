package Heap.DoublyHeap;

import java.util.Collections;
import java.util.PriorityQueue;

public class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {};
        PriorityQueue<Integer> min_heap = new PriorityQueue<Integer>();
        PriorityQueue<Integer> max_heap = new PriorityQueue<Integer>(Collections.reverseOrder());

        int add_count = 0;
        int max_count = 0;
        int min_count = 0;
        for(String op : operations)
        {
            if(op.contains("I"))
            {
                int num = Integer.parseInt(op.split(" ")[1]);
                min_heap.add(num);
                max_heap.add(num);
                add_count++;
            }
            else
            {
                if(max_count + min_count >= add_count)
                {
                    continue;
                }
                if(op.contains("-1"))
                {
                    min_heap.poll();
                    min_count++;
                }
                else
                {
                    max_heap.poll();
                    max_count++;
                }
                if(min_count + max_count == add_count)
                {
                    min_heap = new PriorityQueue<Integer>();
                    max_heap = new PriorityQueue<Integer>(Collections.reverseOrder());
                }
            }
        }
        if(max_count + min_count >= add_count)
            answer = new int[]{0, 0};
        else
            answer = new int[] {max_heap.peek(), min_heap.peek()};
        return answer;
    }
}
