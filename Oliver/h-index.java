import java.util.Arrays;
import java.util.Collections;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int total = citations.length;

        Arrays.sort(citations);

        for(int i = total - 1; i >= 0; i--) {
            if(total - i > citations[i]) {
                break;
            }
            
            answer = total - i;
        }
        
        return answer;
    }
}
