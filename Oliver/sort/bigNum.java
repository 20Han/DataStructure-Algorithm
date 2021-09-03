import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        Comparator<Integer> comparator = (i1, i2) -> {
            String s1 = i1.toString();
            String s2 = i2.toString();

            return (s2+s1).compareTo(s1+s2);
        };

        for(int i : Arrays.stream(numbers).
                boxed().
                sorted(comparator).
                mapToInt(i -> i).
                toArray()){
            answer += i;
        }

        if(answer.startsWith("0"))
            return "0";

        return answer;
    }
}
