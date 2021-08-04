import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {

        HashMap<String, Integer[]> hash = new HashMap<String, Integer[]>(100);
        for(int i=0; i<genres.length; i++)
        {
            Integer[] play_list = hash.get(genres[i]);
            if(play_list == null)
            {
                hash.put(genres[i], new Integer[]{plays[i], -1,i,-1,plays[i]});
                for (Map.Entry<String, Integer[]> entrySet : hash.entrySet()) {
                    System.out.println(entrySet.getKey() + " : " + Arrays.toString(entrySet.getValue()));
                }
            }
            else
            {
                if(play_list[0] < plays[i])
                {
                    play_list[4] = play_list[4] + plays[i];
                    play_list[1] = play_list[0];
                    play_list[3] = play_list[2];
                    play_list[0] = plays[i];
                    play_list[2] = i;

                }
                else if(play_list[1] < plays[i])
                {
                    play_list[4] = play_list[4] + plays[i];
                    play_list[1] = plays[i];
                    play_list[3] = i;
                }
                else
                {
                    play_list[4] = play_list[4] + plays[i];
                }
                hash.put(genres[i], play_list);
            }
        }
        ArrayList<Integer> result = new ArrayList<>();

        List<HashMap.Entry<String, Integer[]>> list_entries = new ArrayList<HashMap.Entry<String, Integer[]>>(hash.entrySet());
        Collections.sort(list_entries, new Comparator<Map.Entry<String, Integer[]>>() {
            // compare로 값을 비교
            public int compare(Map.Entry<String, Integer[]> obj1, Map.Entry<String, Integer[]> obj2) {
                // 내림 차순 정렬
                return obj2.getValue()[4].compareTo(obj1.getValue()[4]);
            }
        });

        for(Map.Entry<String, Integer[]> entry : list_entries)
        {
            Integer[] temp = entry.getValue();
            result.add(temp[2]);
            if(temp[3] != -1)
                result.add(temp[3]);
        }
        return result.stream().mapToInt(i->i).toArray();
    }
}
