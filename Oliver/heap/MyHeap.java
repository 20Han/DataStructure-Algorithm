import java.util.Comparator;
import java.util.stream.IntStream;

class Solution {
    public static void main(String[] args) {
        Heap<Integer> heap = new Heap<>((i1, i2) -> i1 - i2); // maxheap

        heap.add(1);
        heap.add(5);
        heap.add(3);
        heap.add(-1);
        heap.add(-2);
        heap.add(-3);
        heap.add(-4);
        heap.add(9);
        heap.add(3);

        System.out.println(heap.poll());
        System.out.println(heap.poll());
        System.out.println(heap.poll());
        System.out.println(heap.poll());
        System.out.println(heap.poll());
        System.out.println(heap.poll());
        System.out.println(heap.poll());
        System.out.println(heap.poll());
        System.out.println(heap.poll());
        System.out.println(heap.poll());
        System.out.println(heap.poll());
    }
}

class Heap<T>{
    int capacity = 4;
    int lastIndex = 0;
    private T[] arr;
    private Comparator<T> comparator;

    Heap(Comparator<T> comparator) {
        arr = (T[])(new Object[capacity]);
        this.comparator = comparator;
    }

    public T poll(){
        if(lastIndex == 0)
            return null;

       T ret = arr[1];
       arr[1] = arr[lastIndex];
       arr[lastIndex] = null;
       lastIndex--;

       int i = 1;
       while(
               2 * i <= lastIndex  && comparator.compare(arr[i], arr[2 * i]) <= 0
                       || 2 * i + 1 <= lastIndex && comparator.compare(arr[i], arr[2 * i + 1]) <= 0
       ) {
           if(2 * i + 1 > lastIndex ||
                   comparator.compare(arr[2 * i], arr[2 * i + 1]) >= 0) {
               swap(i, 2 * i);
               i = 2 * i;
           }
           else {
               swap(i, 2 * i + 1);
               i = 2 * i +1;
           }
       }

       return ret;
    }

    public void add(T value){
        if(lastIndex == capacity - 1)
            extendArr();

        arr[++lastIndex] = value;

        int insertIndex = lastIndex;

        while(insertIndex != 1 && comparator.compare(arr[insertIndex / 2], value) <= 0){
            swap(insertIndex/2, insertIndex);
            insertIndex /= 2;
        }
    }

    public int size(){
        return lastIndex;
    }

    public boolean isEmpty(){
        return lastIndex == 0;
    }

    public T peek(){
        if(lastIndex == 0)
            return null;
        else
            return arr[1];
    }

    private void swap(int i, int j){
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void extendArr(){
        capacity *= 2;
        T[] tempArr = arr.clone();
        arr = (T[])(new Object[capacity]);
        IntStream.range(0, capacity/2).forEach(i -> arr[i] = tempArr[i]);
    }
}
