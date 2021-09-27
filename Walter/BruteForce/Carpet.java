class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        
        int area = brown + yellow;

        for (int width = (int) Math.ceil(Math.sqrt(area)); width < area; width++) {
            if (area % width == 0) {
                int height = area / width;

                if ((width - 2) * (height - 2) == yellow) {
                    answer = new int[]{width, height};
                    break;
                }
            }
        }
        
        return answer;
    }
}
