package CustomMap;

import java.util.ArrayList;
import java.util.List;

public class Map <K, V> {
    private EntryNode<K, V>[] map;
    private int size;
    private int capacity;
    private static final int startSize = 12;

    public Map () {
        this.map = new EntryNode[startSize];
        this.capacity = startSize;
        this.size = 0;
    }

    public Map (int capacity) {
        this.map = new EntryNode[capacity];
        this.capacity = capacity;
        this.size = 0;

    }

    public int getCapacity() {
        return this.capacity;
    }

    public int index (K key) {
        return key.hashCode() % getCapacity();
    }

    public int getSize() {
        return size;
    }

    public void put (K key, V value) {
        if (key != null) {
            autoIncrease();
            for (int startIndex = index(key); startIndex < getCapacity(); startIndex++) {
                if (this.map[startIndex] == null) {
                    this.map[startIndex] = new EntryNode<>(key, value);
                }
            }
            size++;
        } else {
            System.out.println("Key cant be null");
        }
    }

    public void update(K key, V value) {
        int bucketIndex = index(key);
        if (this.map[bucketIndex] != null){
            this.map[bucketIndex].setValue(value);
        } else {
            System.out.println("Cant update value for null key");
        }
    }

    private void put(EntryNode<K, V> node) {
        this.put(node.getKey(), node.getValue());
    }

    public List<EntryNode<K, V>> getContents() {
        List<EntryNode<K, V>> contents = new ArrayList<>();
        for (int contentCounter = 0; contentCounter < getCapacity(); contentCounter++) {
            if (this.map[contentCounter] != null) {
                contents.add(this.map[contentCounter]);
                if (contents.size() == getSize())
                    break;
            }
        }
        return contents;
    }

    public void autoIncrease() {
        if (getCapacity() - size <= 5) {
            this.capacity = getCapacity() * 2;
            Map<K, V> tempMap = new Map<K, V>(getCapacity());
            for(EntryNode<K, V> node : this.getContents()) {
                tempMap.put(node);
            }
        }
    }

}
