import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";

        List<Integer> list = new ArrayList<>();

        for (int number : numbers) {
            list.add(number);
        }

        Comparator<Integer> comparator = new Comparator<>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                Integer firstCase = Integer.parseInt(o1.toString() + o2.toString());
                Integer secondCase = Integer.parseInt(o2.toString() + o1.toString());

                if (firstCase > secondCase) {
                    return -1;
                } else if (firstCase.equals(secondCase)){
                    return 0;
                } else return 1;
            }
        };

        list.sort(comparator);

        answer = list.stream().map(String::valueOf).reduce((x, y) -> x + y).get();

        while (answer.startsWith("0") && answer.length() > 1) {
            answer = answer.substring(1);
        }
        
        return answer;
    }
}
