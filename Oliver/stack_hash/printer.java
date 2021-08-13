import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    class Pair {
            int p;
            int l;
            Pair(int p, int l){
                this.p = p;
                this.l = l;
            }
        }
    
    public int solution(int[] priorities, int location) {
            PriorityQueue<Integer> prioritiesQueue = new PriorityQueue<>(Collections.reverseOrder());
            Queue<Pair> queue = new LinkedList<>();
            for(int i =0 ; i < priorities.length; i++) {
                prioritiesQueue.add(priorities[i]);
                queue.add(new Pair(priorities[i], i));
            }

            int count = 0;
            int max = prioritiesQueue.poll();

            while(true){
                Pair pair = queue.poll();
                if(pair.p == max) {
                    count++;
                    if(pair.l == location)
                        return count;
                    else {
                        max = prioritiesQueue.poll();
                    }
               } else{
                    queue.add(pair);
               }
           }
   }
}
