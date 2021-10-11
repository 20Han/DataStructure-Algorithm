package Greedy.GymSuit;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        System.out.println(n + " " + lost[0] + " " + reserve[0]);
        Arrays.sort(lost);
        Arrays.sort(reserve);
        ArrayList<Integer> lost_list = new ArrayList<Integer>();
        ArrayList<Integer> reserve_list = new ArrayList<Integer>();
        // lost array to arraylist
        for(int i=0; i<lost.length; i++)
        {
            lost_list.add(lost[i]);
        }
        // reserve array to arraylist
        for(int i=0; i< reserve.length; i++)
        {
            reserve_list.add(reserve[i]);
        }
        ArrayList<Integer> removed_idx = new ArrayList<Integer>();
        for(int i=0; i< lost_list.size(); i++)
        {
            int lost_temp = lost_list.get(i);
            for(int j=0; j<reserve_list.size(); j++)
            {
                int reserve_temp = reserve_list.get(j);
                if(lost_temp == reserve_temp)
                {
                    removed_idx.add(lost_temp);
                    break;
                }
            }
        }
        for(int i=0; i<removed_idx.size(); i++)
        {
            Integer idx = removed_idx.get(i);
            lost_list.remove(idx);
            reserve_list.remove(idx);
        }
        int answer = n-lost_list.size();
        for(int i=0; i<reserve_list.size(); i++)
        {
            int temp_reserve = reserve_list.get(i);
            for(int j=0; j< lost_list.size(); j++)
            {
                int lost_temp = lost_list.get(j);
                if(lost_temp == -10)
                    continue;
                if(lost_temp > temp_reserve+1)
                    break;
                if(lost_temp == temp_reserve-1)
                {
                    answer++;
                    // set lost value to meaningless number
                    lost_list.set(j, -10);
                    break;
                }
                if(lost_temp == temp_reserve+1)
                {
                    answer++;
                    lost_list.set(j, -10);
                    break;
                }
            }

        }
        return answer;
    }
}
