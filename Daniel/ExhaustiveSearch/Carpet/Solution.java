package ExhaustiveSearch.carpet;

public class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        int total = brown+yellow;
        int w, h;
        for(int i=1; i<=yellow; i++)
        {
            if(i*i > yellow)
                break;
            if(yellow%i != 0)
                continue;
            h = i+2;
            w = (yellow/i) + 2;
            if(w * h == total)
            {
                answer = new int[]{w, h};
                break;
            }
        }
        return answer;
    }
}
