class Solution {
    public int[] solution(int brown, int yellow) {
        //전체크기 : w * h = browb + yellow
        //가로 세로 길이 합 : w + h = (brown + 4) / 2

        for(int w = 1; w < brown; w++) {
            int h = (brown + 4) / 2 - w;
            if(w * h == brown + yellow)
                return new int[]{h,w};
        }

        return new int[]{-1,-1};
    }
}
