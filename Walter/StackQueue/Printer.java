import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;

        Queue<Map.Entry<Integer, Integer>> indexAndPriorities = new LinkedList<>();
        Queue<Map.Entry<Integer, Integer>> printedIndexAndPriorities = new LinkedList<>();

        for (int i = 0; i < priorities.length; i++) {
            indexAndPriorities.offer(new AbstractMap.SimpleEntry<>(i, priorities[i]));
        }
        
        while (!indexAndPriorities.isEmpty()) {
            Map.Entry<Integer, Integer> indexPriority = indexAndPriorities.poll();

            if (indexAndPriorities.stream().anyMatch(entry -> entry.getValue() > indexPriority.getValue())) {
                indexAndPriorities.offer(indexPriority);
            } else {
                printedIndexAndPriorities.offer(indexPriority);
            }
        }
        
        int index = 0;

        for (Map.Entry<Integer, Integer> indexAndPriority : printedIndexAndPriorities) {
            if (indexAndPriority.getKey() == location) {
                answer = index + 1;
                break;
            }
            index++;
        }

        return answer;
    }
}
