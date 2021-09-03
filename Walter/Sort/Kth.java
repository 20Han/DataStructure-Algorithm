import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            answer[i] = getResult(array, commands[i][0], commands[i][1], commands[i][2]);
        }

        return answer;
    }
    
    private int getResult(int[] array, int fromIndex, int toIndex, int targetIndex) {
        int[] subarray = new int[toIndex - fromIndex + 1];

        for (int i = fromIndex - 1; i < toIndex; i++) {
            subarray[i - fromIndex + 1] = array[i];
        }

        Arrays.sort(subarray);

        return subarray[targetIndex - 1];
    }
}
