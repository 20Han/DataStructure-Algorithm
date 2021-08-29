package Heap.MyHeap;

import java.util.Comparator;

public class MyHeap<T> {
    private final Comparator<? super T> comparator;
    private static final int DEFAULT_CAPACITY = 16;
    private int size;
    private Object[] array;
    public MyHeap(Comparator<? super T> comparator)
    {
        this.comparator = comparator;
        this.array = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }
    private void resize(int capacity)
    {
        Object[] new_array = new Object[capacity];
        for(int i=1; i<=size; i++)
        {
            new_array[i] = array[i];
        }
        this.array = null;
        this.array = new_array;
    }
    public void add(T element)
    {
        if(size+1 == array.length)
            resize(array.length*2);
        siftUp(++size, element);
    }
    private void siftUp(int idx, T element)
    {
        while(idx > 1)
        {
            int parent_idx = idx/2;
            T parent = (T)array[parent_idx];
            if(comparator.compare(element, parent) >= 0)
                break;
            array[idx] = parent;
            idx = parent_idx;
        }
        array[idx] = element;
    }
    public T remove()
    {
        if(array[1] == null)
            return null;
        T result = (T)array[1];
        array[1] = array[size];
        array[size] = null;
        size--;
        siftDown(1, (T)array[1]);
        return result;
    }
    private void siftDown(int idx, T element)
    {
        while(idx <= size/2)
        {
            T min_child;
            T left_child = (T)array[2*idx];
            T right_child = (T)array[2*idx+1];
            boolean is_min_left = true;
            if(right_child == null)
                min_child = left_child;
            else
            {
                if(comparator.compare(left_child, right_child) <= 0)
                    min_child = left_child;
                else
                {
                     min_child = right_child;
                     is_min_left = false;
                }
            }
            if(comparator.compare(element, min_child) <= 0)
                break;
            array[idx] = min_child;
            if(is_min_left)
                idx = 2*idx;
            else
                idx = 2*idx + 1;
        }
        array[idx] = element;
        if(array.length > DEFAULT_CAPACITY && size < array.length/2)
            resize(array.length/2);
    }
    public T peek()
    {
        return (T)array[1];
    }

    public int size()
    {
        return size;
    }
    public boolean isEmpty()
    {
        return array[1] == null;
    }

    public static void main(String[] args)
    {
        MyHeap<Integer> heap = new MyHeap<Integer>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1.compareTo(o2);
        }
        });
        heap.add(3);
        heap.add(4);
        heap.add(6);
        heap.add(5);
        System.out.println(heap.size());
        System.out.println(heap.remove().toString());
        System.out.println(heap.remove().toString());
        System.out.println(heap.peek().toString());
        System.out.println(heap.remove().toString());
        System.out.println(heap.isEmpty());
        System.out.println(heap.remove().toString());
        System.out.println(heap.isEmpty());
    }
}
