import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        List<Integer> list = new ArrayList<>();

        for (int citation : citations) {
            if (citation == 0)
                continue;

            list.add(citation);
        }

        list.sort(((o1, o2) -> o2 - o1));

        List<Integer> candidates = new ArrayList<>();
        
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) >= i + 1) {
                candidates.add(i + 1);
            }
        }

        answer = candidates.stream().max(Comparator.naturalOrder()).orElse(0);
        
        return answer;
    }
}
