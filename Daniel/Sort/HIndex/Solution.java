package Sort.HIndex;

import java.util.Arrays;

public class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        for(int i= 0; i<citations.length; i++)
        {
            if(citations[citations.length-1-i] < i+1)
                break;
            answer++;
        }
        return answer;
    }
}
