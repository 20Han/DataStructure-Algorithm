import java.util.Arrays;
import java.util.stream.IntStream;

class Solution {
    public int[] solution(int[] answers) {
        int[] supoja1 = new int[]{1,2,3,4,5};
        int p1 = supoja1.length;
        int[] supoja2 = new int[]{2,1,2,3,2,4,2,5};
        int p2 = supoja2.length;
        int[] supoja3 = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int p3 = supoja3.length;

        int[] count = new int[3];

        for(int i = 0 ; i < answers.length; i++){
            if(answers[i] == supoja1[i%p1])
                count[0]++;
            if(answers[i] == supoja2[i%p2])
                count[1]++;
            if(answers[i] == supoja3[i%p3])
                count[2]++;
        }

        int max = Math.max(Math.max(count[0], count[1]), count[2]);

        return IntStream.of(1, 2, 3)
                .filter(i -> count[i-1] == max)
                .toArray();
    }
}
