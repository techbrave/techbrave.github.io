class SnapHashMap {
    public void put(int key, int value); 

    public int get(int key); 

    // return snap id
    public int snap() {

    }

    public int getWithSnap(int key, int snapId) {

    }

    // for every key, value pair, do we need to snap with snap ID
    // key, (value, map<Integer, Integer> //snapID+value)
}