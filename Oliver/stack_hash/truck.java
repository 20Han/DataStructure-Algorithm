import java.util.*;

class Solution {
    class Pair{
            int truckWeight;
            int startTime;

            Pair(int t, int s){
                this.truckWeight = t;
                this.startTime = s;
            }
        }

        public int solution(int bridge_length, int weight, int[] truck_weights) {
            int answer = 0;
            Queue<Pair> queue = new LinkedList<>();
            int totalWeight = 0;

            for(int i = 0; i < truck_weights.length; i++) {
                if(totalWeight + truck_weights[i] <= weight) {
                    answer = answer + 1;
                } else {
                    Pair pair = null;

                    while (totalWeight + truck_weights[i] > weight){
                        pair = queue.poll();
                        totalWeight -= pair.truckWeight;
                    }

                    answer = pair.startTime + bridge_length;
                }

                totalWeight += truck_weights[i];
                queue.add(new Pair(truck_weights[i], answer));
                
                while(queue.peek() != null && queue.peek().startTime + bridge_length <= answer) {
                    totalWeight -= queue.poll().truckWeight;
                }
            }

            //마지막 트럭이 지나는 시간
            answer += bridge_length;

            return answer;
        }
}
