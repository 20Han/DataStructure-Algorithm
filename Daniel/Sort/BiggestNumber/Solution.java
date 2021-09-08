package Sort.BiggestNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Solution {
    public String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();
        ArrayList<String> list = new ArrayList<String>();
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String num1 = o1+o2;
                String num2 = o2+o1;
                return num2.compareTo(num1);
            }
        };
        for(int num : numbers)
        {
            list.add(Integer.toString(num));
        }
        Collections.sort(list, comparator);
        if(list.get(0).equals("0"))
            return "0";
        for(String num : list)
        {
            answer.append(num);
        }
        return answer.toString();
    }
}
