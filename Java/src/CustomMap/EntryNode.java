package CustomMap;

public class EntryNode <K, V> {
    private K key;
    private V value;


    public EntryNode(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public EntryNode(K key, V value, EntryNode<K, V> nextNode) {
        this.key = key;
        this.value = value;
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

    @Override
    public boolean equals(Object o) {
        if (o instanceof EntryNode) {
            EntryNode<K, V> node = (EntryNode<K, V>) o;
            return this.key.equals(node.getKey()) && this.value.equals(node.getValue());
        }
        return false;
    }

    public void setValue(V value) {
        this.value = value;
    }
}
