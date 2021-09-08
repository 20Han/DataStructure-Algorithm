import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            answer[i] = getResult(array, commands[i][0], commands[i][1], commands[i][2]);
        }

        return answer;
    }
    
    private int getResult(int[] array, int fromIndex, int toIndex, int targetIndex) {
        int[] subarray = new int[toIndex - fromIndex + 1];

        for (int i = fromIndex - 1; i < toIndex; i++) {
            subarray[i - fromIndex + 1] = array[i];
        }

        quickSort(subarray, 0, subarray.length - 1);

        return subarray[targetIndex - 1];
    }
    
    public void quickSort(int[] arr, int beginIndex, int endIndex) {
        if (beginIndex < endIndex) {
            int partitionIndex = partition(arr, beginIndex, endIndex);

            quickSort(arr, beginIndex, partitionIndex - 1);
            quickSort(arr, partitionIndex, endIndex);
        }
    }

    private int partition(int[] arr, int beginIndex, int endIndex) {
        //select pivot as last element.
        int pivotValue = arr[endIndex];
        //set i as beginIndex - 1, so j can always be higher than i.
        int i = beginIndex - 1;

        //j cannot be endIndex because endIndex is pivotIndex.
        for (int j = beginIndex; j < endIndex; j++) {

            //j-th index is lower than pivotValue.
            if (arr[j] <= pivotValue) {
                //increment i first because initial value of i was beginIndex - 1.
                i++;

                //i-th element should always be lower than pivotValue.
                //So swapping i-th element and j-th element forces value which is lower than pivotValue to always go left.
                swap(arr, i, j);
            }
        }

        //elements equal or lower than i-th index are all smaller than the pivotValue.
        //so we have to insert pivotValue to i+1 th index.
        swap(arr, i + 1, endIndex);

        //return index of pivotValue.
        return i + 1;
    }

    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
