class Solution {
   class pair implements Comparable<pair>{
    int num1;
    int num2;
    int sum;
    int idx;
    pair(int num1,int num2,int sum,int idx){
        this.num1=num1;
        this.num2=num2;
        this.sum=sum;
        this.idx=idx;
    }
    public int compareTo(pair p){
        return this.sum-p.sum;
    }
}

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<pair>pq=new PriorityQueue<>();

        for(int i=0;i<Math.min(k,nums1.length);i++){
                pq.add(new pair(nums1[i],nums2[0],nums1[i]+nums2[0],0));
        }

        List<List<Integer>>list=new ArrayList<>();
        
        while(k-->0 && pq.size()>0){
            List<Integer>l=new ArrayList<>();
            pair p=pq.poll();
            l.add(p.num1);
            l.add(p.num2);
            list.add(l);
            int idx=p.idx;
            if(idx<nums2.length-1){
                pq.add(new pair(p.num1,nums2[idx+1],p.num1+nums2[idx+1],p.idx+1));
            }
        }
        return list;
        }
}
