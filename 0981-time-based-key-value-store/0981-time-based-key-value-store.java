class TimeMap {
    Map<String,TreeMap<Integer,String>> store;
    public TimeMap() {
        store = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        store.computeIfAbsent(key,k->new TreeMap<>()).put(timestamp,value);
    }
    
    public String get(String key, int timestamp) {
        if(!store.containsKey(key))
            return "";
        TreeMap<Integer,String> treemap = store.get(key);
        Integer time = treemap.floorKey(timestamp);
        return time == null? "":treemap.get(time);
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */