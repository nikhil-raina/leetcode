package CustomQueue;

import java.util.Arrays;

public class Queue <T>{

    private Object[] queue;
    private static final int startSize = 10;
    private static int maxSize = startSize;
    private static int head;
    private static int tail;

    public Queue() {
        this.queue = new Object[startSize];
        head = 0;
        tail = 0;
    }

    public void enqueue(T element) {
        autoIncrement();
        this.queue[tail++] = element;
    }

    private void autoIncrement() {
        if (maxSize - tail <= 5) {
            maxSize = maxSize * 2;
            Object[] tempQueue = new Object[maxSize];
            for (int queueCounter = head; queueCounter < tail; queueCounter++) {
                tempQueue[queueCounter] = this.queue[queueCounter];
            }
            this.queue = tempQueue;
        }
    }

    public T dequeue() {
        if(head == tail) {
            System.out.println("Queue is Empty");
            head = 0;
            tail = 0;
            return null;
        }
        Object element = this.queue[head++];
        this.queue[head - 1] = null;
        if(head == tail) {
            head = 0;
            tail = 0;
        }
        return (T) element;
    }

    public static int getHead() {
        return head;
    }

    public static int getTail() {
        return tail;
    }

    public int getHeight() {
        return getTail() - getHead();
    }

    @Override
    public String toString() {
        return "Queue{" +
                "queue=" + Arrays.toString(queue) +
                '}';
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(1);
        queue.enqueue(19);
        queue.enqueue(11);
        queue.enqueue(14);
        queue.enqueue(17);
        System.out.println(queue.toString());
        assert queue.getHeight() == 5;
        queue.enqueue(12);
        queue.enqueue(4);
        assert queue.getHeight() == 7;
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.toString());
        assert queue.getHeight() == 5;
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        assert queue.getHeight() == 0;
        queue.dequeue();
        assert getTail() == 0;
        assert getHead() == 0;
        queue.dequeue();
        assert getTail() == 0: "Tail doesnt match";
        assert getHead() == 0: "Head doesnt match";
        queue.enqueue(99);
        assert queue.getHeight() == 1: "Size doesnt match";
        assert getTail() == 1;
        assert getHead() == 0;
        System.out.println(queue.toString());
    }
}
