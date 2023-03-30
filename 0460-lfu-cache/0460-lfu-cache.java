class LFUCache {
    E[] map=new E[100_001];
    LinkedHashSet<E>[] freqBuckets= new LinkedHashSet[10_001];
    int lf=0,capacity;
    boolean block=false;

    public LFUCache(int capacity) {
        this.capacity=capacity;
        if(capacity==0) block=true;
    }
    
    public int get(int key) {
        if(block) return -1;
        E v=map[key];
        if(v==null) return -1;
        updateFreq(v);
        return v.value;
    }
    
    public void put(int key, int value) {
        if(block) return;
        E v=map[key];
        if(v==null) {
            if(capacity==0) {
                E r=freqBuckets[lf].iterator().next();
                freqBuckets[lf].remove(r);
                map[r.key]=null;
                capacity++;
            }
            v=new E(key,value);
            capacity--;
        } else v.value=value;
        updateFreq(v);
        map[key]=v;
    }

    private void updateFreq(E keyE) {
        if(keyE.f==0||(keyE.f==lf&&freqBuckets[keyE.f].size()==1)) lf=keyE.f+1;
        if(keyE.f++!=0) freqBuckets[keyE.f-1].remove(keyE);
        if(freqBuckets[keyE.f]==null) freqBuckets[keyE.f]=new LinkedHashSet<>();
        freqBuckets[keyE.f].add(keyE);
    }

    class E {
        int f=0,key,value;
        public E(int key, int value) {
            this.key=key;
            this.value=value;
        }
    }
}