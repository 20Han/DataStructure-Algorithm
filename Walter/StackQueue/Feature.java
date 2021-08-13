import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};

        Queue<Integer> progressesQueue = new LinkedList<>();
        Queue<Integer> speedsQueue = new LinkedList<>();
        Queue<Integer> answerQueue = new LinkedList<>();

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

        answer = answerQueue.stream().mapToInt(Integer::intValue).toArray();

        return answer;
    }
}
