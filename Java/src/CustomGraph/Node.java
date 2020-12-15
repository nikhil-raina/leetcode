package CustomGraph;

import java.util.Objects;

public class Node {
    private int data;

    public Node(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof  Node) {
            Node node = (Node) o;
            return this.data == node.data;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.data);
    }
}
