import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> scovilleQueue = new PriorityQueue<>();

        for (int i : scoville) {
            scovilleQueue.offer(i);
        }

        while (scovilleQueue.peek() != null && scovilleQueue.peek() < K) {

            Integer first = scovilleQueue.poll();
            Integer second = scovilleQueue.poll();

            if (second == null)
                return -1;

            Integer newScoville = first + (second * 2);
            scovilleQueue.offer(newScoville);

            answer++;
        }
        
        return answer;
    }
}
