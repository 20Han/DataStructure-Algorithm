package Greedy.BiggestNumber;

public class Solution {
    public String solution(String number, int k) {
        String answer = "";
        int length = number.length() - k;
        int left = 0; // 선택 가능한 문자들 중 가장 왼쪽 index
        for(int i=0; i<length; i++)
        {
            int right = k+i; // 선택 가능한 문자들 중 가장 오른쪽 index
            int biggestIdx = left;
            int biggestNum = -1;
            for(int j=left; j<=right; j++)
            {
                int currNum = Character.getNumericValue(number.charAt(j));
                if(biggestNum < currNum)
                {
                    biggestIdx = j;
                    biggestNum = currNum;
                    if(currNum == 9)
                        break;
                }
            }
            answer = answer + Integer.toString(biggestNum);
            left = biggestIdx + 1;
        }

        return answer;
    }
}
