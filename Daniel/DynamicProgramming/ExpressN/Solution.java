package DynamicProgramming.ExpressN;

import java.util.HashSet;

public class Solution {
    public int solution(int N, int number) {
        HashSet<Integer>[] arr = new HashSet[9];
        for(int i=1; i<=8; i++)
        {
            arr[i] = new HashSet<Integer>();
            int allN = N;
            for(int j=2; j<=i; j++)
            {
                allN += N * Math.pow(10, j-1);
            }
            arr[i].add(allN);
            for(int j=1; j<= (i+1)/2; j++)
            {
                if(i == 1)
                    continue;
                HashSet<Integer> hash1 = arr[j];
                HashSet<Integer> hash2 = arr[i-j];
                for(int k : hash1)
                {
                    for(int m : hash2)
                    {
                        arr[i].add(k+m);
                        arr[i].add(k-m);
                        arr[i].add(m-k);
                        arr[i].add(k*m);
                        if(m != 0)
                            arr[i].add(k/m);
                        if(k != 0)
                            arr[i].add(m/k);
                    }
                }
            }
            if(arr[i].contains(Integer.valueOf(number)))
                return i;
        }
        return -1;
    }
}
