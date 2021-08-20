import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    class Pair{
        int start;
        int length;

        Pair(int start, int length){
            this.start = start;
            this.length = length;
        }
    }
    
    public int solution(int[][] jobs) {
        int answer = 0;

        Arrays.sort(jobs, (a,b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> p1.length - p2.length);

        int time = 0;
        int i = 0;



        while(i < jobs.length || !pq.isEmpty()){
            if(pq.isEmpty()){
                time = Math.max(jobs[i][0],time);
            }

            while(i < jobs.length && jobs[i][0] <= time){
                pq.add(new Pair(jobs[i][0], jobs[i][1]));
                i++;
            }

            Pair pair = pq.poll();

            time += pair.length;
            answer += time - pair.start;
        }

        return answer / jobs.length;
    }
}
