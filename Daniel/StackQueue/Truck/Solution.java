package StackQueue.Truck;

import StackQueue.MyQueue.MyQueue;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = new int[]{7,4,5,6};


        MyQueue<Integer> source = new MyQueue<Integer>();
        MyQueue<ArrayList<Integer>> bridge = new MyQueue<ArrayList<Integer>>();
        for(int i=0; i<truck_weights.length; i++)
        {
            source.add(truck_weights[i]);
        }
        int weight_sum = 0;
        int t = 0;
        while(!bridge.isEmpty() || !source.isEmpty())
        {
            t++;
            if(bridge.peek() != null && bridge.peek().get(1) == t)
            {
                weight_sum -= bridge.remove().get(0);
            }
            if(source.peek() != null && (weight_sum + source.peek() <= weight))
            {
                bridge.add(new ArrayList<Integer>(Arrays.asList(source.peek(), t+bridge_length)));
                weight_sum += source.remove();
            }
        }

        System.out.println(t);
        return;
    }
}
