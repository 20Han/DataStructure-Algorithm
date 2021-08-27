import java.util.ArrayList;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {};

        ArrayList<Integer> list = new ArrayList<>();

        for (String operation : operations) {
            if (operation.startsWith("I")) {
                int inserted = Integer.parseInt(operation.replace("I ", ""));
                list.add(inserted);
            }
            else if (operation.equals("D 1")) {
                list.stream().max(Integer::compare).ifPresent(list::remove);
            }
            else if (operation.equals("D -1")) {
                list.stream().min(Integer::compare).ifPresent(list::remove);
            }
        }

        if (list.isEmpty()) {
            answer = new int[]{0, 0};
        }
        else {
            answer = new int[]{list.stream().max(Integer::compare).get(), list.stream().min(Integer::compare).get()};
        }

        return answer;
    }
}
