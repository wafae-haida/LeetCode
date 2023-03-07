class SnapshotArray {
    Map<Integer, Map<Integer,Integer>> dic;
    int snap_id = 0;
    public SnapshotArray(int length) {
       dic = new HashMap<>();
    }
    
    public void set(int index, int val) {
        Map<Integer,Integer> map = dic.get(index);
        if(map == null)
            map = new HashMap<>();
        map.put(snap_id,val);
        dic.put(index,map);
    }
    
    public int snap() {
        snap_id++;
        return snap_id - 1;
    }
    
    public int get(int index, int snap_id) {
        Map<Integer,Integer> map = dic.get(index);
        if(map == null)
            return 0;
        Integer value = map.get(snap_id);
        if(value != null)
            return value;
        int resId = Integer.MIN_VALUE;
        int resValue = 0;
        for(Map.Entry<Integer,Integer> m : map.entrySet()){
            if(resId < m.getKey() && m.getKey() < snap_id){
                resId = m.getKey();
                resValue =  m.getValue();
            }
                
        }
        return resValue;
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */