import java.util.HashMap;

 class Solution {
        public int solution(String[][] clothes) {
            int answer = 1;
            HashMap<String, Integer> hashMap = new HashMap<>();

            for(String[] cloth : clothes){
                String type = cloth[1];
                if(!hashMap.containsKey(type))
                    hashMap.put(type, 1);
                else
                    hashMap.put(type, hashMap.get(type) + 1);
            }

            for(int value : hashMap.values()){
                answer *= (value + 1);
            }

            //모두 선택 안한 케이스
            answer--;

            return answer;
        }
    }
