import java.util.*;

class Solution {
    
    public static class Job implements Comparable<Job> {
        public final int requestedTime;
        public final int length;
        public int fromRequestToEnd;
        public Job prevJob;

        public Job(int[] job) {
            this.requestedTime = job[0];
            this.length = job[1];
        }

        public void calculateFromRequestToEnd() {
            if (prevJob == null || prevJob.getEndTime() <= requestedTime)
                fromRequestToEnd = length;
            else {
                fromRequestToEnd = prevJob.requestedTime + prevJob.fromRequestToEnd 
                    + length - requestedTime;
            }
        }
        
        public int getEndTime() {
            return fromRequestToEnd + requestedTime;
        }

        @Override
        public int compareTo(Job that) {
            if (this.requestedTime == that.requestedTime)
                return Integer.compare(this.length, that.length);
            return Integer.compare(this.requestedTime, that.requestedTime);
        }
    }
    
    public int solution(int[][] jobs) {
        int answer = 0;

        PriorityQueue<Job> jobPriorityQueue = new PriorityQueue<>();

        for (int[] job : jobs) {
            jobPriorityQueue.offer(new Job(job));
        }
        PriorityQueue<Job> queueOfJobWaitingPrevJobFinish = new PriorityQueue<>(new Comparator<Job>() {
            @Override
            public int compare(Job o1, Job o2) {
                return Integer.compare(o1.length, o2.length);
            }
        });

        Job lastProcessedJob = null;

        while (!jobPriorityQueue.isEmpty() || !queueOfJobWaitingPrevJobFinish.isEmpty()) {

            if (lastProcessedJob == null) {
                lastProcessedJob = jobPriorityQueue.poll();
                lastProcessedJob.calculateFromRequestToEnd();
            }
            else {
                if (jobPriorityQueue.peek() != null && lastProcessedJob.getEndTime() > jobPriorityQueue.peek().requestedTime) {
                    queueOfJobWaitingPrevJobFinish.offer(jobPriorityQueue.poll());
                } else if (!queueOfJobWaitingPrevJobFinish.isEmpty()){
                    Job currentJob = queueOfJobWaitingPrevJobFinish.poll();
                    currentJob.prevJob = lastProcessedJob;
                    lastProcessedJob = currentJob;
                    lastProcessedJob.calculateFromRequestToEnd();
                } else if (!jobPriorityQueue.isEmpty()) {
                    Job currentJob = jobPriorityQueue.poll();
                    currentJob.prevJob = lastProcessedJob;
                    lastProcessedJob = currentJob;
                    lastProcessedJob.calculateFromRequestToEnd();
                }
            }
        }

        while (lastProcessedJob.prevJob != null) {
            answer += lastProcessedJob.fromRequestToEnd;
            lastProcessedJob = lastProcessedJob.prevJob;
        }
        answer += lastProcessedJob.fromRequestToEnd;

        answer /= jobs.length;

        return answer;
    }
}
