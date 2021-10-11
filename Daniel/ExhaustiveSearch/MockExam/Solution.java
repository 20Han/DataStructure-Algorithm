package ExhaustiveSearch.MockExam;

import java.util.ArrayList;

public class Solution {
    public int[] solution(int[] answers) {
        int[] man1 = new int[] {1,2,3,4,5};
        int[] man2 = new int[] {2,1,2,3,2,4,2,5};
        int[] man3 = new int[] {3,3,1,1,2,2,4,4,5,5};
        int score1 = 0;
        int score2 = 0;
        int score3 = 0;
        for(int i=0; i<answers.length; i++)
        {
            if(answers[i] == man1[i%man1.length])
                score1++;
            if(answers[i] == man2[i%man2.length])
                score2++;
            if(answers[i] == man3[i%man3.length])
                score3++;
        }
        int max = Math.max(score1, score2);
        max = Math.max(max, score3);
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(max == score1) list.add(1);
        if(max == score2) list.add(2);
        if(max == score3) list.add(3);
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++)
        {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
