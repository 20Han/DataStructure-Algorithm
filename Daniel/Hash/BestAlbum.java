import java.util.HashMap;

public class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<String, Integer>(100000);
        for(int i=0; i<completion.length; i++)
        {
            if(map.containsKey(completion[i]))
            {
                var count = map.get(completion[i]);
                map.put(completion[i], count+1);
            }
            else
            {
                map.put(completion[i], 1);
            }
        }
        for(int i=0; i<participant.length; i++)
        {
            if(!map.containsKey(participant[i]))
                return participant[i];
            var count = map.get(participant[i]);
            if(count == 0)
                return participant[i];
            map.put(participant[i], count-1);
        }
        return "";
    }
}
