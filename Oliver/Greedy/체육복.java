import java.util.Arrays;
import java.util.stream.IntStream;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;

        Arrays.sort(lost);
        Arrays.sort(reserve);

        int[] filteredReserve = IntStream.of(reserve).filter(i -> IntStream.of(lost).noneMatch(x -> x==i)).toArray();
        int[] filteredLost = IntStream.of(lost).filter(i -> IntStream.of(reserve).noneMatch(x -> x==i)).toArray();
        answer += reserve.length - filteredReserve.length;

        boolean[] visit = new boolean[filteredReserve.length];

        answer += Arrays.stream(filteredLost).filter(i -> canReserved(i, filteredReserve, visit)).count();

        return answer;
    }
    
    public boolean canReserved(int n, int[] reserve, boolean[] visit){
        for(int i = 0; i < reserve.length; i++){
            if(reserve[i] == n-1 && !visit[i]) {
                visit[i] = true;
                return true;
            }
            if(reserve[i] == n && !visit[i]) {
                visit[i] = true;
                return true;
            }if(reserve[i] == n+1 && !visit[i]) {
                visit[i] = true;
                return true;
            }
        }

        return false;
    }
}
