package CustomTree;

import java.util.LinkedList;
import java.util.Queue;

public class Tree {

    private Node root;

    public Tree() {
        this.root = null;
    }

    private Node insertNode(Node currentNode, Node node) {
        if (currentNode == null) {
            currentNode = node;
        } else if (currentNode.equals(node)) {
            return currentNode;
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

    public void deleteNode(Node node) {
        this.root = deleteNode(this.root, node);
    }

    public Node deleteNode(Node currentNode, Node node) {
        try {
            if (currentNode.equals(node)) {
                if (currentNode.getLeftNode() == null && currentNode.getRightNode() == null) {
                    return null;
                }
                if (currentNode.getRightNode() == null) {
                    return currentNode.getLeftNode();
                }
                if (currentNode.getLeftNode() == null) {
                    return currentNode.getRightNode();
                }
            } else if (currentNode.getData() < node.getData()) {
                currentNode.setRightNode(deleteNode(currentNode.getRightNode(), node));
            }
            currentNode.setLeftNode(deleteNode(currentNode.getLeftNode(), node));

        } catch (NullPointerException e) { }

        return currentNode;
    }

    public boolean isNodePresent(Node root, Node target) {
        try {
            if (root.equals(target)) {
                return true;
            } else if (root.getData() < target.getData()) {
                return isNodePresent(root.getRightNode(), target);
            } else {
                return isNodePresent(root.getLeftNode(), target);
            }
        } catch (NullPointerException e) {
            return false;
        }
    }

    public boolean isNodePresent(Node node) {
        return isNodePresent(this.root, node);
    }

    public void inorder() {
        System.out.print("In-Order Traversal :> ");
        inorder_traversal(this.root);
        System.out.println();
    }

    public void inorder_traversal(Node node) {
        if (node != null) {
            inorder_traversal(node.getLeftNode());
            System.out.print(node.getData() + " -> ");
            inorder_traversal(node.getRightNode());
        }
    }

    public void postOrder() {
        System.out.print("Post-Order Traversal :> ");
        postOrder_traversal(this.root);
        System.out.println();
    }

    public void postOrder_traversal(Node node) {
        if (node != null) {
            postOrder_traversal(node.getLeftNode());
            postOrder_traversal(node.getRightNode());
            System.out.print(node.getData() + " -> ");
        }
    }

    public void preOrder() {
        System.out.print("Pre-Order Traversal :> ");
        preOrder_traversal(this.root);
        System.out.println();
    }

    public void preOrder_traversal(Node node) {
        if (node != null) {
            System.out.print(node.getData() + " -> ");
            preOrder_traversal(node.getLeftNode());
            preOrder_traversal(node.getRightNode());
        }
    }

    public void bfs() {
        System.out.print("BFS Traversal :> ");
        bfs(this.root);
        System.out.println();
    }

    public void bfs(Node node) {
        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.add(node);

        while (!nodeQueue.isEmpty()) {
            Node newNode = nodeQueue.remove();
            System.out.print(newNode.getData() + " -> ");

            if (newNode.getLeftNode() != null) {
                nodeQueue.add(newNode.getLeftNode());
            }
            if (newNode.getRightNode() != null) {
                nodeQueue.add(newNode.getRightNode());
            }
        }
    }

    public void height() {
        System.out.println("The height of the tree is :> " + height(this.root));
    }

    public int height(Node node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = height(node.getLeftNode());
        int rightHeight = height(node.getRightNode());

        return leftHeight >= rightHeight ? leftHeight + 1 : rightHeight + 1;
    }

    public boolean isBalanced() {
        return helperBalanced(this.root) != -1;
    }

    public int helperBalanced(Node root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = helperBalanced(root.getLeftNode());
        int rightHeight = helperBalanced(root.getRightNode());

        if (leftHeight == -1 || rightHeight == -1) {
            return -1;
        }

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        return leftHeight >= rightHeight ? leftHeight + 1 : rightHeight + 1;
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
        tree.insertNode(node7);
        tree.insertNode(new Node(-9));
        tree.insertNode(new Node(-6));
        tree.insertNode(new Node(-2));
        tree.insertNode(new Node(-11));
        tree.insertNode(node3);
        tree.insertNode(new Node(-7));
        tree.deleteNode(node78);
        System.out.println(tree.isNodePresent(node5));
        tree.inorder();
        tree.postOrder();
        tree.preOrder();
        tree.bfs();
        tree.height();
        System.out.println(tree.isBalanced());
    }
}
