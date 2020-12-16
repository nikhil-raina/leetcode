package CustomGraph;

import java.util.*;

public class Graph {

    private Map<Node, List<Node>> map;

    public Graph() {
        this.map = new HashMap<>();
    }

    /**
     * Creates a bi-directed graph
     * @param start starting Node
     * @param end ending node
     */
    public void insert(Node start, Node end) {
        if (start.equals(end)) {
            System.out.println("Node cant be an edge to itself");
        } else {
            if (!this.map.containsKey(start)) {
                this.map.put(start, new LinkedList<>());
            }
            if (!this.map.containsKey(end)) {
                this.map.put(end, new LinkedList<>());
            }
            if (!isPresent(start, end)) {
                this.map.get(start).add(end);
                this.map.get(end).add(start);
            } else {
                System.out.println("Node already an edge");
            }
        }
    }

    public boolean isPresent(Node start, Node end) {
        return this.map.get(start).contains(end);
    }

    public List<Node> getEdges(Node node) {
        return this.map.get(node);
    }

    public void bfs(Node root) {
        Queue<Node> queue = new LinkedList<>();
        Set<Node> visited = new HashSet<>();
        queue.add(root);
        visited.add(root);
        System.out.print("BFS :> ");
        while (!queue.isEmpty()) {
            Node currentNode = queue.remove();
            System.out.print(currentNode.getData() + " -> ");
            for (Node neighbor : this.getEdges(currentNode)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }

    public void dfs(Node root) {
        Stack<Node> stack = new Stack<>();
        Set<Node> visited = new HashSet<>();
        stack.add(root);
        visited.add(root);
        System.out.print("DFS :> ");
        while (!stack.isEmpty()) {
            Node currentNode = stack.pop();
            System.out.print(currentNode.getData() + " -> ");
            for (Node neighbor : this.getEdges(currentNode)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    stack.add(neighbor);
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        Node node1 = new Node(12);
        Node node2 = new Node(12);
        Node node3 = new Node(1);
        Node node4 = new Node(2);
        Node node5 = new Node(5);
        Node node6 = new Node(88);
        Node node7 = new Node(121);
        graph.insert(node1, node2);
        graph.insert(node1, node3);
        graph.insert(node3, node5);
        graph.insert(node4, node5);
        graph.insert(node6, node7);
        graph.insert(node7, node1);
        graph.bfs(node1);
        graph.dfs(node1);

    }
}
