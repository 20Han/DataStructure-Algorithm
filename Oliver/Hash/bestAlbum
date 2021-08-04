import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

class Solution {
        public int[] solution(String[] genres, int[] plays) {
            HashMap<String, Integer> lengthHashMap = new HashMap<>();
            HashMap<String, HashMap<Integer, Integer>> identityHashMap = new HashMap<>();

            for(int i = 0; i<genres.length; i++){
                if(lengthHashMap.containsKey(genres[i]))
                    lengthHashMap.put(genres[i], lengthHashMap.get(genres[i]) + plays[i]);
                else
                    lengthHashMap.put(genres[i], plays[i]);

                if(identityHashMap.containsKey(genres[i])) {
                    identityHashMap.get(genres[i]).put(i, plays[i]);
                }
                else{
                    HashMap<Integer, Integer> hashMap = new HashMap<>();
                    hashMap.put(i, plays[i]);
                    identityHashMap.put(genres[i], hashMap);
                }
            }

            ArrayList<Integer> answerArrayList = new ArrayList<>();

            ArrayList<String> lengthHashMapKey = new ArrayList<>(lengthHashMap.keySet());

            Collections.sort(lengthHashMapKey, (s1, s2) -> lengthHashMap.get(s2) - lengthHashMap.get(s1));

            for(String genre : lengthHashMapKey) {
                HashMap<Integer, Integer> identities = identityHashMap.get(genre);

                ArrayList<Integer> identitiesHashMapKey = new ArrayList<>(identities.keySet());

                Collections.sort(identitiesHashMapKey, (i1, i2) -> {
                    if(identities.get(i1).equals(identities.get(i2))){
                        return i1 - i2;
                    } else {
                        return identities.get(i2)  - identities.get(i1);
                    }
                });

                if(identities.size() == 1)
                    answerArrayList.add(identitiesHashMapKey.get(0));
                else {
                    answerArrayList.add(identitiesHashMapKey.get(0));
                    answerArrayList.add(identitiesHashMapKey.get(1));
                }
            }

            int[] answer = answerArrayList.stream().mapToInt(i->i).toArray();

            return answer;
        }
    }
