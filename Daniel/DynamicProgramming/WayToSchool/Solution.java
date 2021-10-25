package DynamicProgramming.WayToSchool;

public class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] grid = new int[m+1][n+1];
        for(int i=0; i< puddles.length; i++)
        {
            grid[puddles[i][0]][puddles[i][1]] = -1;
        }
        for(int i=1; i<=m; i++)
        {
            if(grid[i][1] == -1)
                break;
            grid[i][1] = 1;
        }
        for(int i=1; i<=n; i++)
        {
            if(grid[1][i] == -1)
                break;
            grid[1][i] = 1;
        }
        for(int i=2; i<=m; i++)
        {
            for(int j=2; j<=n; j++)
            {
                if(grid[i][j] == -1)
                    continue;
                int left = Math.max(grid[i - 1][j], 0);
                int up = Math.max(grid[i][j - 1], 0);
                grid[i][j] = (left + up) % 1000000007;
            }
        }
        return grid[m][n]%1000000007;
    }
}

