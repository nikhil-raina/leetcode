package CustomTree;

public class Tree {

    private Node root;

    public Tree() {
        this.root = null;
    }

    private Node insertNode(Node currentNode, Node node) {
        if (currentNode == null) {
            currentNode = node;
        } else if (currentNode.equals(node)) {
            return null;
        } else if (currentNode.getData() < node.getData()) {
            currentNode.setRightNode(insertNode(currentNode.getRightNode(), node));
        } else {
            currentNode.setLeftNode(insertNode(currentNode.getLeftNode(), node));
        }
        return currentNode;
    }

    public void insertNode(Node node) {
        this.root = insertNode(this.root, node);
    }


    public static void main(String[] args) {
        Tree tree = new Tree();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node nodeDuplicate = new Node(4);
        Node node78 = new Node(78);
        tree.insertNode(node1);
        tree.insertNode(node2);
        tree.insertNode(node78);
        tree.insertNode(node4);
        tree.insertNode(nodeDuplicate);
    }
}
