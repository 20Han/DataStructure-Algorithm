package DynamicProgramming.Stealing;

public class Solution {
    public int solution(int[] money) {
        int answer = Math.max(findMaxWithStart(money, 0), findMaxWithStart(money, 1));
        answer = Math.max(answer, findMaxWithStart(money,2));
        return answer;
    }
    private int findMaxWithStart(int[] money, int start)
    {
        int[] sum = new int[money.length];
        sum[start] = money[start];
        for(int i = start+2; i<money.length; i++)
        {
            int idx1 = (i+money.length-3)% money.length;
            int idx2 = (i+money.length-2)% money.length;
            int operand = Math.max(sum[idx1], sum[idx2]);
            sum[i] = money[i] + operand;
        }
        int max = 0;
        for(int i= money.length-3+start; i<money.length-1+start; i++)
        {
            if(max < sum[i%money.length])
                max = sum[i%money.length];
        }
        return max;
    }
}
