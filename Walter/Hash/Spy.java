import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;

        HashMap<String, Integer> categoriesWithCount = new HashMap<>();

        for (String[] clothe : clothes) {
            Integer count = categoriesWithCount.get(clothe[1]);

            if (count == null) {
                count = 0;
            }
            categoriesWithCount.put(clothe[1], ++count);
        }

        answer = categoriesWithCount.values().stream().map(count -> count + 1).reduce((x, y) -> x * y).orElse(0) - 1;
        return answer;
    }
}
