package ExhaustiveSearch.PrimeNumber;

import java.util.ArrayList;
import java.util.HashSet;

public class Solution {
    public int solution(String numbers) {
        // 숫자들 분리
        int[] numberArray = new int[numbers.length()];
        boolean[] checkArray = new boolean[numbers.length()];
        for(int i=0; i<numbers.length(); i++)
        {
            numberArray[i] = Character.getNumericValue(numbers.charAt(i));
        }
        // 숫자 조합 만들기
        HashSet<Integer> hash = new HashSet<Integer>();
        for(int i=0; i< numberArray.length; i++)
        {
            if(numberArray[i] == 0)
                continue;
            boolean[] tempCheckArray = checkArray.clone();
            tempCheckArray[i] = true;
            hash.add(numberArray[i]);
            permutate(hash, numberArray[i], 2, numberArray, tempCheckArray);
        }
        ArrayList<Integer> combination = new ArrayList<Integer>(hash);


        // 조합 중 소수 찾기
        int count = 0;
        for(int i=0; i<combination.size(); i++)
        {
            if(checkPrime(combination.get(i)))
            {
                count++;
            }
        }
        return count;
    }
    private void permutate(HashSet<Integer> hash, int curr, int position, int[] numberArray, boolean[] checkArray)
    {
        if(position > numberArray.length)
            return;
        for(int i=0; i< numberArray.length; i++)
        {
            if(checkArray[i] == false)
            {
                // 자릿수에 맞게 10의 거듭제곱 곱하기
                int num = numberArray[i];
                boolean[] tempCheckArray = checkArray.clone();
                tempCheckArray[i] = true;
                int tempCurr = curr*10 + num;
                hash.add(tempCurr);
                permutate(hash, tempCurr, position+1, numberArray, tempCheckArray);
            }
        }
    }
    private boolean[] cleanArray(boolean[] arr)
    {
        for(int i=0; i< arr.length; i++)
        {
            arr[i] = false;
        }
        return arr;
    }
    private boolean checkPrime(int num)
    {
        if(num == 1)
            return false;
        boolean isPrime = true;
        for(int i=2; i<num; i++)
        {
            if(i*i > num) break;
            if(num%i == 0)
                isPrime = false;
        }
        return isPrime;
    }
}
