import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;

public class MyPriorityQueue<E extends Comparable<E>> {

    private final Comparator<? super E> comparator;
    private static final int DEFAULT_CAPACITY = 10;

    private int size;
    private Object[] array;

    public  MyPriorityQueue() {
        this(null);
    }

    public MyPriorityQueue(Comparator<? super E> comparator) {
        this.array = new Object[DEFAULT_CAPACITY];
        this.size = 0;
        this.comparator = comparator;
    }

    public MyPriorityQueue(int capacity) {
        this(capacity, null);
    }

    public MyPriorityQueue(int capacity, Comparator<? super E> comparator) {
        this.array = new Object[capacity];
        this.size = 0;
        this.comparator = comparator;
    }

    private int getParent(int index) {
        return index / 2;
    }

    private int getLeftChild(int index) {
        return index * 2;
    }

    private int getRightChild(int index) {
        return index * 2 + 1;
    }

    private void resize(int newCapacity) {

        Object[] newArray = Arrays.copyOf(array, newCapacity);

        this.array = null;
        this.array = newArray;
    }

    public boolean offer(E value) {

        if (size + 1 == array.length) {
            resize(array.length * 2);
        }

        siftUp(size + 1, value);
        size++;

        return true;
    }

    private void siftUp(int index, E target) {
        if (comparator != null) {
            siftUpComparator(index, target, comparator);
        } else {
            siftUpComparable(index, target);
        }
    }

    @SuppressWarnings("unchecked")
    private void siftUpComparator(int index, E target, Comparator<? super E> comparator) {

        while (index > 1) {
            int parentIndex = getParent(index);
            Object parentValue = array[parentIndex];

            if (comparator.compare(target, (E) parentValue) >= 0) {
                break;
            }

            array[index] = parentValue;
            index = parentIndex;
        }

        array[index] = target;
    }

    @SuppressWarnings("unchecked")
    private void siftUpComparable(int index, E target) {

        Comparable<? super E> comparableTarget = (Comparable<? super E>) target;

        while (index > 1) {
            int parentIndex = getParent(index);
            Object parentValue = array[parentIndex];

            if (comparableTarget.compareTo((E) parentValue) >= 0) {
                break;
            }

            array[index] = parentValue;
            index = parentIndex;
        }

        array[index] = target;
    }

    public E poll() {
        if (array[1] == null) {
            return null;
        }

        return remove();
    }

    @SuppressWarnings("unchecked")
    public E remove() {

        if (array[1] == null) {
            throw new NoSuchElementException();
        }

        E result = (E) array[1];
        E target = (E) array[size];

        array[size] = null;
        size--;
        siftDown(1, target);

        return result;
    }

    private void siftDown(int index, E target) {
        if(comparator != null) {
            siftDownComparator(index, target, comparator);
        }
        else {
            siftDownComparable(index, target);
        }
    }

    @SuppressWarnings("unchecked")
    private void siftDownComparator(int index, E target, Comparator<? super E> comparator) {

        array[index] = null;

        int parent = index;
        int childIndex;

        while ((childIndex = getLeftChild(parent)) <= size) {

            int rightChildIndex = getRightChild(parent);
            Object childValue = array[childIndex];

            if (rightChildIndex <= size && comparator.compare((E) childValue, (E) array[rightChildIndex]) > 0) {
                childIndex = rightChildIndex;
                childValue = array[childIndex];
            }

            if (comparator.compare(target, (E) childValue) <= 0) {
                break;
            }

            array[parent] = childValue;
            parent = childIndex;
        }

        array[parent] = target;

        if (array.length > DEFAULT_CAPACITY && size < array.length / 4) {
            resize(Math.max(DEFAULT_CAPACITY, array.length / 2));
        }
    }

    @SuppressWarnings("unchecked")
    private void siftDownComparable(int index, E target) {

        Comparable<? super E> comparableTarget = (Comparable<? super E>) target;

        array[index] = null;

        int parent = index;
        int childIndex;

        while ((childIndex = getLeftChild(parent)) <= size) {

            int rightChildIndex = getRightChild(parent);
            Object childValue = array[childIndex];

            if (rightChildIndex <= size && ((Comparable<? super E>) childValue).compareTo((E) array[rightChildIndex]) > 0) {
                childIndex = rightChildIndex;
                childValue = array[childIndex];
            }

            if (comparableTarget.compareTo((E) childValue) <= 0) {
                break;
            }

            array[parent] = childValue;
            parent = childIndex;
        }

        array[parent] = comparableTarget;

        if (array.length > DEFAULT_CAPACITY && size < array.length / 4) {
            resize(Math.max(DEFAULT_CAPACITY, array.length / 2));
        }
    }

    public int size() {
        return this.size;
    }

    @SuppressWarnings("unchecked")
    public E peek() {
        return (E) array[1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3}, 100));
    }

    public static int solution(int[] scoville, int K) {
        int answer = 0;
        MyPriorityQueue<Integer> scovilleQueue = new MyPriorityQueue<>();

        for (int i : scoville) {
            scovilleQueue.offer(i);
        }

        while (scovilleQueue.peek() != null && scovilleQueue.peek() < K) {

            Integer first = scovilleQueue.poll();
            Integer second = scovilleQueue.poll();

            if (second == null || (scovilleQueue.size == 1 && scovilleQueue.peek() < K))
                return -1;

            Integer newScoville = first + (second * 2);
            scovilleQueue.offer(newScoville);

            answer++;
        }

        return answer;
    }
}
