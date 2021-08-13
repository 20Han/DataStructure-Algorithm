class Stack<T> {
    int capacity = 2;
    int startIndex = 0;
    int endIndex = 0;

    //full -> startIndex == endIndex && arr[startIndex] != null
    //empty -> startIndex == endIndex && arr[startIndex] == null

    private T[] arr;

    public Stack(){
        arr = (T[])(new Object[capacity]);
    }

    public void push(T element) {
        if(startIndex == endIndex && arr[startIndex] != null) {
            extendArr();
        }

        arr[endIndex] = element;

        endIndex++;
        endIndex %= capacity;
    }

    public T poll() {
        if(startIndex == endIndex && arr[(endIndex + capacity - 1) % capacity] == null)
            return null;

        T ret = arr[(endIndex + capacity - 1) % capacity];
        endIndex += capacity - 1; // equal to endIndex-- at remain
        endIndex %= capacity;
        return ret;
    }

    private void extendArr(){
        capacity *= 2;
        T[] tempArr = arr.clone();
        arr = (T[])(new Object[capacity]);
        IntStream.range(startIndex, startIndex + capacity/2).forEach(i -> arr[i] = tempArr[i % (capacity/2)]);
        endIndex = startIndex + capacity/2;
    }
}
