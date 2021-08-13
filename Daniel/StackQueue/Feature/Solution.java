package StackQueue.Feature;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i=0; i<progresses.length; i++)
        {
            Integer days;
            if((100-progresses[i]) % speeds[i] == 0) // 정확히 나뉘어지면 몫을 그대로 사용
                days = (100-progresses[i]) / speeds[i];
            else
                days = ((100-progresses[i]) / speeds[i]) + 1; // 나머지가 있으면 몫 + 1
            queue.add(days);
        }
        int deploy_days = queue.peek();
        int number_of_tasks = 0;
        ArrayList<Integer> answer_list = new ArrayList<Integer>();
        for(int i=0; i<progresses.length; i++)
        {
            Integer current_target_days = queue.poll();
            if(current_target_days == null)
               continue;
            if(deploy_days >= current_target_days) // 현재 Task는 지금 함께 배포됨을 의미
            {
                number_of_tasks++;
            }
            else // 현재 Task는 지금 days보다 더 이후에 배포되어야 함을 의미
            {
                answer_list.add(number_of_tasks); // 지금 배포 과정에 들어갈 task 수 추가
                deploy_days = current_target_days; // 다음 배포 날짜 지정
                number_of_tasks = 1; // 현재 Task가 들어갔으므로 1개로 다시 시작
            }
        }
        answer_list.add(number_of_tasks); // 마지막에 쌓인 Tasks 배포
        answer = answer_list.stream().mapToInt(i->i).toArray();
        return answer;
    }
}
