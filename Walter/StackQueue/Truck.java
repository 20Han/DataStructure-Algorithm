import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        Queue<Integer> bridge = new LinkedList<>();
        Queue<Integer> truckWeightsQueue = Arrays.stream(truck_weights).boxed().collect(Collectors.toCollection(LinkedList::new));

        while (bridge.size() < bridge_length) {
            bridge.offer(0);
        }

        int second = 0;
        int currentWeightOfTrucksOnTheBridge = 0;

        while (!bridge.isEmpty()) {
            currentWeightOfTrucksOnTheBridge -= bridge.poll();

            if (truckWeightsQueue.peek() != null && currentWeightOfTrucksOnTheBridge + truckWeightsQueue.peek() <= weight) {
                currentWeightOfTrucksOnTheBridge += truckWeightsQueue.peek();
                bridge.offer(truckWeightsQueue.poll());
            } else {
                if (!truckWeightsQueue.isEmpty())
                    bridge.offer(0);
            }

            second++;
        }

        answer = second;
        
        return answer;
    }
}
