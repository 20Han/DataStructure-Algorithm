import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
        public int[] solution(int[] progresses, int[] speeds) {
            Queue<Integer> remain = new LinkedList<>();

            for (int i = 0; i < progresses.length; i++) {
                int remainDay = (100 - progresses[i]) / speeds[i] + ((100 - progresses[i]) % speeds[i] == 0 ? 0 : 1);
                remain.add(remainDay);
            }

            ArrayList<Integer> answerList = new ArrayList<>();

            while(!remain.isEmpty()) {
                int count = 1;
                int first = remain.poll();

                while(!remain.isEmpty() && remain.peek() <= first) {
                    remain.poll();
                    count++;
                }

                answerList.add(count);
            }

            int[] answer = answerList.stream().mapToInt(i -> i).toArray();
            return answer;
        }
    }
