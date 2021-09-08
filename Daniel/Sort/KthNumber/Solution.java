package Sort.KthNumber;

import java.util.Arrays;

public class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int c = 0; c<commands.length; c++)
        {
            int i = commands[c][0];
            int j = commands[c][1];
            int k = commands[c][2];

            int[] temp = new int[j-i+1];
            for(int t = 0; t < (j-i+1); t++)
            {
                temp[t] = array[t+i-1];
            }
            Arrays.sort(temp);
            answer[c] = temp[k-1];
        }
        return answer;
    }
}
