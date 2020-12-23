package CustomStack;

import java.util.Arrays;

public class Stack <T>{
    private Object[] stack;
    private int height;
    private static final int startSize = 10;
    private static int maxSize = startSize;

    public Stack() {
        this.stack = new Object[startSize];
        this.height = 0;
    }

    private void autoIncrease() {
        if (maxSize - getHeight() <= 5) {
            maxSize = maxSize * 2;
            Object[] tempStack = new Object[maxSize];
            for (int stackCounter = 0; stackCounter < getHeight(); stackCounter++) {
                tempStack[stackCounter] = this.stack[stackCounter];
            }
            this.stack = tempStack;
        }
    }

    public void push(T element) {
        autoIncrease();
        this.stack[this.height++] = element;
    }

    public T pop() {
        Object element = this.stack[getHeight() - 1];
        this.stack[getHeight() - 1] = null;
        this.height--;
        return (T) element;
    }

    public T peak() {
        return (T) this.stack[getHeight() - 1];
    }

    @Override
    public String toString() {
        return "Stack{" +
                "stack=" + Arrays.toString(stack) +
                ", height=" + height +
                '}';
    }

    public int getHeight() {
        return height;
    }

    public T[] getContents() {
        return (T[]) this.stack;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(4);
        stack.push(12);
        stack.push(211);
        stack.push(45);
        stack.push(2);
        stack.push(123);
        stack.push(11);
        System.out.println(stack.toString());
        System.out.println(stack.pop());
        System.out.println(stack.toString());
        System.out.println(stack.getHeight());
        System.out.println(stack.peak());
    }
}
