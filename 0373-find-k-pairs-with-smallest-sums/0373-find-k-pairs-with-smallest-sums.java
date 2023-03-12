class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        Queue<int[]> minHeap = new PriorityQueue<>((a,b)->(a[0]+a[1]) - (b[0] + b[1]));
        
        for(int i = 0 ; i < nums1.length && minHeap.size() <= k ; i++)
            minHeap.add(new int[]{nums1[i],nums2[0],0});
        List<List<Integer>> ans = new ArrayList<>();
        while(k > 0 && !minHeap.isEmpty()){
            int[] tmp = minHeap.poll();
            ans.add(List.of(tmp[0],tmp[1]));
            int idx = tmp[2] + 1;
            if(idx < nums2.length){
                minHeap.add(new int[]{tmp[0],nums2[idx],idx});
            }
            k--;
        }
        return ans;
    }
}