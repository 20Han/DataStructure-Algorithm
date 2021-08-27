package Heap.DiskController;

import java.util.*;

class Solution {
    class Node implements Comparable<Node>
    {
        int request;
        int task;

        Node(int request, int task)
        {
            this.request = request;
            this.task = task;
        }

        @Override
        public int compareTo(Node o) {
            if (this.request > o.request)
                return 1;
            else if (this.request < o.request)
                return -1;
            else
                return 0;
        }
    }
    public int solution(int[][] jobs) {
        int answer = 0;
        ArrayList<Node> tasks = new ArrayList<Node>();
        for(int[] job : jobs)
        {
            tasks.add(new Node(job[0], job[1]));
        }
        Collections.sort(tasks);
        int t = 0;
        int count = 0;
        while(count < jobs.length)
        {
            int idx = -1;
            int min_task = 1001;
            for(int i=0; i<jobs.length; i++)
            {
                Node curr = tasks.get(i);
                if(curr == null)
                    continue;
                if(curr.request > t)
                    break;
                if(curr.task <= min_task)
                {
                    idx = i;
                    min_task = curr.task;
                }
            }
            if(idx == -1)
            {
                t++;
                continue;
            }
            Node target = tasks.get(idx);
            t += target.task;
            count++;
            answer += (t - target.request);
            tasks.set(idx, null);
        }
        answer = answer / jobs.length;
        return answer;
    }
}
