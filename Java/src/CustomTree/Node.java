package CustomTree;

public class Node {
    private int data;
    private Node leftNode;
    private Node rightNode;

    public Node(int data) {
        this.data = data;
        this.leftNode = null;
        this.rightNode = null;
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public Node getRightNode() {
        return rightNode;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Node) {
            Node newNode = (Node) obj;
            return newNode.data == data;
        }
        return false;
    }
}
