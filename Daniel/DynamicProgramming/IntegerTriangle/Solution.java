package DynamicProgramming.IntegerTriangle;

public class Solution {
    public int solution(int[][] triangle) {
        for(int i=1; i< triangle.length; i++)
        {
            for(int j=0; j<=i; j++)
            {
                int left = j == 0 ? 0 : triangle[i-1][j-1];
                int right = (j == i) ? 0 : triangle[i-1][j];
                triangle[i][j] = Math.max(left, right) + triangle[i][j];
            }
        }
        int max = 0;
        int length = triangle.length;
        for(int i=0; i<length; i++)
        {
            if(max < triangle[length-1][i])
                max = triangle[length-1][i];
        }
        return max;
    }
}
