package Greedy.SpeedCamera;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

public class Solution {
    public int solution(int[][] routes) {
        // routes 인덱싱
        for(int i=0; i< routes.length; i++)
        {
            routes[i] = new int[] {routes[i][0], routes[i][1], i};
        }
        // 우측 끝을 기준으로 오름차순 정렬
        Arrays.sort(routes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        // 좌측 끝을 기준으로 오름차순 정렬
        int[][] copiedRoutes = routes.clone();
        Arrays.sort(copiedRoutes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        HashSet<Integer> checked = new HashSet<Integer>();
        int routesCount = 0;
        int answer = 0;
        for(int i=0; i<routes.length; i++)
        {
            if(checked.contains(routes[i][2]))
                continue;
            for(int j=routesCount; j<routes.length; j++)
            {
                if(copiedRoutes[j][0] <= routes[i][1])
                {
                    checked.add(Integer.valueOf(copiedRoutes[j][2]));
                    routesCount++;
                }
                else
                    break;
            }
            answer++;
        }
        return answer;
    }
}
