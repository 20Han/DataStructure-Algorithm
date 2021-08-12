import java.util.Arrays;
import java.util.EmptyStackException;

public class MyStack<E> {
    private static final int DEFAULT_CAPACITY = 10;
    public static final Object[] EMPTY_ARRAY = {};

    private Object[] array;
    private int size;

    public MyStack() {
        this.array = EMPTY_ARRAY;
        this.size = 0;
    }

    public MyStack(int capacity) {
        this.array = new Object[capacity];
        this.size = 0;
    }

    private void resize() {

        if (Arrays.equals(array, EMPTY_ARRAY)) {
            array = new Object[DEFAULT_CAPACITY];

        } else if (size == array.length) {
            int newSize = array.length * 2;
            array = Arrays.copyOf(array, newSize);

        } else if (size < (array.length / 2)) {
            int newSize = array.length / 2;
            array = Arrays.copyOf(array, Math.max(DEFAULT_CAPACITY, newSize));
        }
    }

    public E push(E element) {
        resize();

        array[size] = element;
        size++;

        return element;
    }

    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        @SuppressWarnings("unchecked")
        E element = (E) array[size - 1];

        array[size - 1] = null;

        size--;
        resize();

        return element;
    }

    @SuppressWarnings("unchecked")
    public E peek() {

        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return (E) array[size - 1];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>();

        for (int i = 0; i < 20; i++) {
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
