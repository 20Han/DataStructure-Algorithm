import java.util.Arrays;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        for(int i=0; i< lost.length; i++)
        {
            int curr_lost = lost[i];
            for(int j=0; j< reserve.length; j++)
            {
                if(curr_lost == reserve[j])
                {
                    lost[i] = -1;
                    reserve[j] = -1;
                    break;
                }
            }
        }
        Arrays.sort(lost);
        Arrays.sort(reserve);
        for(int i=0; i<lost.length; i++)
        {
            int curr_lost = lost[i];
            if(curr_lost == -1)
                continue;
            boolean is_rent = false;
            for(int j=0; j< reserve.length; j++)
            {
                if(reserve[j] == curr_lost+1 || reserve[j] == curr_lost-1)
                {
                    reserve[j] = -1;
                    is_rent = true;
                    break;
                }
            }
            if(!is_rent)
                answer--;
        }
        return answer;
    }
}
