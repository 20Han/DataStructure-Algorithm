import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        int idx = 0;
        for(int[] command : commands){
            int i = command[0];
            int j = command[1];
            int k = command[2];
            answer[idx] = Arrays
                    .stream(array)
                    .skip(i - 1)
                    .limit(j - i + 1)
                    .sorted()
                    .toArray()[k-1];
            idx++;
        }

        return answer;
    }
}
