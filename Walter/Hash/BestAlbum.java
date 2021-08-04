import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        
        Map<String, Integer> genresPlaySum = new HashMap<>();
        
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            Integer sum = genresPlaySum.get(genre);
            
            if (sum == null)
                sum = 0;
            
            genresPlaySum.put(genre, sum + plays[i]);
        }
        
        genresPlaySum = sortMapByValue(genresPlaySum);
                
        Map<String, Map<Integer, List<Integer>>> genresPlaysIndex = new LinkedHashMap<>();
        
        for (Map.Entry<String, Integer> genresPlaySumEntry: genresPlaySum.entrySet()) {
            
            Map<Integer, List<Integer>> playsIndexes = new LinkedHashMap<>();
            
            for (int i = 0; i < genres.length; i++) {
                
                if (genres[i].equals(genresPlaySumEntry.getKey())) {
                    List<Integer> indexes = playsIndexes.get(plays[i]);
                    
                    if (indexes == null)
                        indexes = new ArrayList<>();
                    
                    indexes.add(i);
                    
                    indexes.sort(null);
                    
                    playsIndexes.put(plays[i], indexes);
                }
            }
            
            genresPlaysIndex.put(genresPlaySumEntry.getKey(), playsIndexes);
        }
        
        Map<String, Map<Integer, List<Integer>>> sortedGenresPlaysIndex = new LinkedHashMap<>();
        
        for(Map.Entry<String, Map<Integer, List<Integer>>> genresPlaysIndexEntry: genresPlaysIndex.entrySet()) {
            Map<Integer, List<Integer>> sortedPlaysIndex = sortMapByKey(genresPlaysIndexEntry.getValue());
            sortedGenresPlaysIndex.put(genresPlaysIndexEntry.getKey(), sortedPlaysIndex);
        }
                
        ArrayList<Integer> indexList = new ArrayList<>();
        
        for(Map.Entry<String, Map<Integer, List<Integer>>> finalEntry: sortedGenresPlaysIndex.entrySet()) {
            int count = 0;
            
            for(List<Integer> indexes: finalEntry.getValue().values()) {
                for(Integer index: indexes) {
                    if (count >= 2) break;
                    indexList.add(index);
                    count++;
                }
            }
        }
                
        answer = indexList.stream().mapToInt(i->i).toArray();
        
        return answer;
    }
    
    public <K, V extends Comparable<? super V>> LinkedHashMap<K, V> sortMapByValue(Map<K, V> map) {
        List<Map.Entry<K, V>> entries = new LinkedList<>(map.entrySet());
        Collections.sort(entries, (o1, o2) -> o1.getValue().compareTo(o2.getValue()) * -1 );

        LinkedHashMap<K, V> result = new LinkedHashMap<>();
        for (Map.Entry<K, V> entry : entries) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }
    
    public <K extends Comparable<? super K>, V> LinkedHashMap<K, V> sortMapByKey(Map<K, V> map) {
        List<Map.Entry<K, V>> entries = new LinkedList<>(map.entrySet());
        Collections.sort(entries, (o1, o2) -> o1.getKey().compareTo(o2.getKey()) * -1 );

        LinkedHashMap<K, V> result = new LinkedHashMap<>();
        for (Map.Entry<K, V> entry : entries) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }
}
