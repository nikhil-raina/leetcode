package SnapShots;

import java.util.HashMap;
import java.util.Map;

public class Snapshot {
    private HashMap<Integer, Integer> currentDataStore;
    private HashMap<Integer, HashMap<Integer, Integer>> snapShots;
    private int snapID;

    public Snapshot() {
        this.currentDataStore = new HashMap<>();
        this.snapShots = new HashMap<>();
        this.snapID = 0;
    }

    public void put(int key, int val) {
        this.currentDataStore.put(key, val);
    }

    public int takeSnapshot() {
        HashMap<Integer, Integer> currentSnapshot = new HashMap<>();
        int currentSnapId;
        for(Map.Entry<Integer,Integer> entry: this.currentDataStore.entrySet()) {
            currentSnapshot.put(entry.getKey(),entry.getValue());
        }
        snapShots.put(snapID, currentSnapshot);
        currentSnapId = snapID;
        snapID++;
        return currentSnapId;
    }

    public int get(int key, int snapShot) {
        if (this.snapShots.containsKey(snapShot)) {
            if (this.snapShots.get(snapShot).containsKey(key)) {
                return this.snapShots.get(snapShot).get(key);
            }
        }
        return -1;
    }

    public void deleteSnapshot(int snapShotId) {
        this.snapShots.remove(snapShotId);
    }

    public static void main(String[] args) {
        Snapshot snapShotObject  = new Snapshot();
        int snapId1;
        int snapId2;
        snapShotObject.put(1,10);
        snapShotObject.put(2,13);
        snapShotObject.put(3,17);
        snapShotObject.put(4,19);
        snapShotObject.put(5,100);
        snapId1 = snapShotObject.takeSnapshot();
        snapShotObject.put(1,100);
        snapShotObject.put(2,131);
        snapShotObject.put(3,171);
        snapShotObject.put(4,191);
        snapShotObject.put(5,200);

        snapId2 = snapShotObject.takeSnapshot();
        System.out.println("SanpId: "+snapId1+" Key: 1 "+"Value: "+snapShotObject.get(1, snapId1));
        System.out.println("SanpId: "+snapId2+" Key: 1 "+"Value: "+snapShotObject.get(1, snapId2));

        System.out.println("SanpId: "+snapId1+" Key: 2 "+"Value: "+snapShotObject.get(2, snapId1));
        System.out.println("SanpId: "+snapId2+" Key: 2 "+"Value: "+snapShotObject.get(2, snapId2));

        snapShotObject.deleteSnapshot(snapId1);
        System.out.println("SanpId: "+snapId1+" Key: 1 "+"Value: "+snapShotObject.get(1, snapId1));
    }
}
