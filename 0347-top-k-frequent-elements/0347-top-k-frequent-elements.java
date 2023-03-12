class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> dic = new HashMap<>();
        Queue<Integer> minHeap = new PriorityQueue<>((a,b)->dic.get(a) - dic.get(b));
        for(int num : nums)
            dic.put(num,dic.getOrDefault(num,0) + 1);
        for (int num : dic.keySet()) {
            minHeap.add(num);
            if (minHeap.size() > k) 
                minHeap.poll();
        }
        int[] ans = new int[k];
        int i = 0;
        while(!minHeap.isEmpty()){
            ans[i++] = minHeap.poll();
        }
        return ans;
    }
}