package DSA_Website;

// A re-implementation of AStack

public class MyStack<T> {
    private T[] stackArray;
    private int topIndex;
    private static final int defaultMaxSize = 10;
    private int maxSize;

    @SuppressWarnings("unchecked")
    public MyStack(int size) {
        maxSize = size;
        stackArray = (T[]) new Object[size];
    }
    public MyStack() {
        this(defaultMaxSize);
    }

    public void clear() {
        topIndex = 0;
    }
    public boolean push(T element) {
        if (topIndex >= maxSize) {
            return false;
        }
        stackArray[topIndex++] = element;
        return true;
    }

    public T pop() {
        if (topIndex == 0) {
            return null;
        }
        return stackArray[--topIndex];
    }

    public boolean isEmpty() {
        return (topIndex == 0);
    }
    public int length() { return topIndex; }
}
