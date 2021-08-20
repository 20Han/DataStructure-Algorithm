import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int[] solution(String[] operations) {
        final String popMax = "D 1";
        final String popMin = "D -1";

        int[] answer;

        PriorityQueue<Integer> minPq = new PriorityQueue<>();
        PriorityQueue<Integer> maxPq = new PriorityQueue<>(Comparator.reverseOrder());

        for(String op : operations){
            if (op.equals(popMax)) {
                if (!maxPq.isEmpty()) {
                    int max = maxPq.poll();
                    minPq.remove(max);
                }
            } else if(op.equals(popMin)) {

                if(!minPq.isEmpty()){
                    int min = minPq.poll();
                    maxPq.remove(min);
                }
            } else {
                int value = Integer.parseInt(op.split(" ")[1]);
                minPq.add(value);
                maxPq.add(value);
            }
        }

        if (minPq.isEmpty())
            answer = new int[]{0,0};
        else
            answer = new int[]{maxPq.poll(), minPq.poll()};

        return answer;
    }
}
