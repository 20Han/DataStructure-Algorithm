import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = {};
        Queue<Integer> pricesQueue = Arrays.stream(prices).boxed().collect(Collectors.toCollection(LinkedList::new));
        Queue<Integer> answerQueue = new LinkedList<>();

        int currentPrice = 0;

        for (int i = 0; i < prices.length; i++) {
            int count = 0;

            if (pricesQueue.peek() != null)
                currentPrice = pricesQueue.poll();

            for (Integer nextPrice : pricesQueue) {

                count++;
                if (nextPrice < currentPrice) {
                    break;
                }
            }
            answerQueue.offer(count);
        }

        answer = answerQueue.stream().mapToInt(i -> i).toArray();

        return answer;
    }
}
