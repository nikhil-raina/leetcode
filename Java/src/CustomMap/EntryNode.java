package CustomMap;

public class EntryNode <K, V> {
    private K key;
    private V value;

    private EntryNode<K, V> nextNode;

    public EntryNode(K key, V value) {
        this.key = key;
        this.value = value;
        this.nextNode = null;
    }

    public EntryNode(K key, V value, EntryNode<K, V> nextNode) {
        this.key = key;
        this.value = value;
        this.nextNode = nextNode;
    }

    public EntryNode<K, V> getNextNode() {
        return nextNode;
    }

    public void setNextNode(EntryNode<K, V> nextNode) {
        this.nextNode = nextNode;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }
}
