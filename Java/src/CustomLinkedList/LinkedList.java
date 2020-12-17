package CustomLinkedList;

public class LinkedList <T>{

    private Node<T> head;
    private int size;

    public LinkedList(T data) {
        this.head = new Node<T>(data);
        this.size = 1;
    }

    public void add(T data) {
        if (this.head == null) {
            this.head = new Node<T>(data);
        }
        Node<T> newNode = new Node<T>(data);
        Node last = this.head;
        while (last.getNext() != null){
            last = last.getNext();
        }
        last.setNext(newNode);
        this.size++;
    }

    public T remove(int index) {
        if (this.size > index) {
            Node temp = this.head;
            Node previous = temp;
            for (int indexCounter = 0; indexCounter != index; indexCounter++) {
                previous = temp;
                temp = temp.getNext();
            }
            previous.setNext(temp.getNext());
            this.size--;
            return (T) temp.getData();

        } else {
            System.out.println("Index is greater than the List's size");
            return null;
        }
    }

    // a -> b -> c -> d -> null
    // d -> c -> b -> a -> null
    public void reverse() {
        Node<T> previous = null;
        Node<T> current = this.head;
        Node<T> next;
        while (current != null) {
            next = current.getNext();
            current.setNext(previous);
            previous = current;
            current = next;
        }
        this.head = previous;
    }

    @Override
    public String toString() {
        String result = "";
        Node node = this.head;
        while (node != null) {
            result = result + node.getData() + " -> ";
            node = node.getNext();
        }
        return "LinkedList{" +
                "head= " + result +
                ", size=" + size +
                '}';
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>(1);
        list.add(2);
        list.add(3);
        list.add(6);
        list.add(9);
        System.out.println(list.toString());
        System.out.println(list.remove(3));
        list.reverse();
        System.out.println(list.toString());
    }
}
