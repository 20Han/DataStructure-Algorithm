package StackQueue.Stock;

public class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for(int i=0; i< prices.length-1; i++)
        {
            Integer t = 0;
            for(int j=i; j< prices.length-1; j++)
            {
                if(prices[i] <= prices[j])
                    t++;
                else
                    break;
            }
            answer[i] = t;
        }
        answer[prices.length-1] = 0;
        return answer;
    }
}
