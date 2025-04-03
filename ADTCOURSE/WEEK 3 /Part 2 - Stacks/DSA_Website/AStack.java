package DSA_Website;

public class AStack<T> {
    private T[] stackArray; // Array holding stack
    private static final int DEFAULT_SIZE = 10;
    private int maxSize; // Maximum size of the stack
    private int top; // First free position at top

    // Constructors
    @SuppressWarnings("unchecked")
    AStack(int size) {
        maxSize = size;
        top = 0;
        stackArray = (T[]) new Object[size]; // create stackArray
    }

    AStack() { this(DEFAULT_SIZE); }
    
    // Reinitialize the stack
    public void clear() { top = 0; }

    // Pushing "it" onto the stack
    public boolean push(T it) {
        if (top >= maxSize) { return false; }
        stackArray[top++] = it;
        return true;
    }

    // Removing the first element from the list
    public T pop() {
        if (top == 0) { return null; }
        return stackArray[--top];
    }

    // Return the top element
    public T topValue() {
        if (top == 0) {return null;}
        return stackArray[top-1];
    }
    
    // Return the length of the stack
    public int length() {
        return top;
    }
    
    // See if the stack is empty or not
    public boolean isEmpty() { return (top == 0); }
}
