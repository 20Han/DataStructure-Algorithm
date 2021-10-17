package Greedy.ConnectingLands;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int solution(int n, int[][] costs) {
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });
        int[] group = new int[n];
        for(int i=0; i<n; i++)
        {
            group[i] = i;
        }
        int answer = 0;
        int costsIdx = 0;
        while(!isUnited(group))
        {
            int[] costInfo = costs[costsIdx];
            int land1 = costInfo[0];
            int land2 = costInfo[1];
            int cost = costInfo[2];
            if(group[land1] != group[land2])
            {
                union(group, land1, land2);
                answer += cost;
                costsIdx++;
            }
            else
            {
                costsIdx++;
                continue;
            }
        }
        return answer;
    }
    private void union(int[] group, int idx1, int idx2)
    {
        int parentSet = Math.min(group[idx1], group[idx2]);
        int childSet = Math.max(group[idx1], group[idx2]);
        for(int i=0; i< group.length; i++)
        {
            if(group[i] == childSet)
                group[i] = parentSet;
        }
    }
    private boolean isUnited(int[] group)
    {
        for(int i=0; i< group.length; i++)
        {
            if(group[i] != 0)
                return false;
        }
        return true;
    }
}
