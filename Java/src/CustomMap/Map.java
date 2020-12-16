package CustomMap;

import java.util.ArrayList;
import java.util.List;

public class Map <K, V> {
    private ArrayList<EntryNode<K, V>> map;
    private int size;
    private int capacity;
    private static final int startSize = 12;

    public Map () {
        this.map = new ArrayList<>();
        this.capacity = startSize;
        this.size = 0;
    }

    public Map (int capacity) {
        this.map = new ArrayList<>();
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
                if (this.map.get(startIndex) == null) {
                    this.map.add(startIndex, new EntryNode<>(key, value));
                    break;
                }
            }
            size++;
        } else {
            System.out.println("Key cant be null");
        }
    }

    public void update(K key, V value) {
        int bucketIndex = index(key);
        if (this.map.get(bucketIndex) != null){
            this.map.get(bucketIndex).setValue(value);
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
            if (this.map.get(contentCounter) != null) {
                contents.add(this.map.get(contentCounter));
                if (contents.size() == getSize())
                    break;
            }
        }
        return contents;
    }

    @Override
    public String toString() {
        return "Map{" +
                "map=" + map +
                ", size=" + size +
                ", capacity=" + capacity +
                '}';
    }

//    Need to work this part out
    public void autoIncrease() {
//        if (getCapacity() - size <= 5) {
//            this.capacity = getCapacity() * 2;
//            ArrayList<EntryNode<K, V>> tempMap = this.map;
//
//            for(EntryNode<K, V> node : this.getContents()) {
//                tempMap.(node);
//            }
//        }
    }

    public EntryNode<K, V> get(K key) {
        int bucketIndex = index(key);
        if (this.map.get(bucketIndex) != null) {
            return this.map.get(bucketIndex);
        }
        System.out.println("Cant get value from null space");
        return null;
    }

    public void remove(K key) {
        int bucketIndex = index(key);
        if (this.map.get(bucketIndex) != null) {
            this.map.remove(bucketIndex);
        }
        System.out.println("Cant remove node from null space");
    }

    public static void main(String[] args) {
        Map<Integer, String> map = new Map<>();
        map.put(1,"A");
        map.put(2,"Aa");
        map.put(3,"Amm");
        map.put(9,"mm");
        map.put(1,"C");
        map.put(5,"asd");
        map.put(4,"hhh");
        map.put(111,"fghjkl");
        map.put(8838,"7272");
        System.out.println(map.toString());
    }
}
