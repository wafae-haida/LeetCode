class RandomizedSet {
    List<Integer> list;
    Map<Integer,Integer> map;
    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }
    
    public boolean insert(int val) {
        if(list.contains(val))
            return false;
        map.put(val,list.size());
        list.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if(!list.contains(val))
            return false;
        int idx = map.get(val);
        if(idx < list.size() - 1){
            int last_val = list.get(list.size() - 1);
            list.set(idx,last_val);
            map.put(last_val,idx);
        }
        map.remove(val);
        list.remove(list.size() - 1);
        return true;
    }
    
    public int getRandom() {
        Random rand = new Random();
        int idx = rand.nextInt(list.size());
        return list.get(idx);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */