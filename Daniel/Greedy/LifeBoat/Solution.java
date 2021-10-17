package Greedy.Lifeboat;

import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int person : people)
        {
            list.add(person);
        }
        Collections.sort(list, Collections.reverseOrder());
        int left = 0;
        int right = list.size() - 1;
        while(left <= right)
        {
            int size = list.size();
            int first = list.get(left);
            left++;
            if(left > right)
            {
                answer++;
                break;
            }
            int last = list.get(right);
            if(last + first <= limit)
            {
                right--;
            }
            answer++;
        }
        return answer;
    }
}
