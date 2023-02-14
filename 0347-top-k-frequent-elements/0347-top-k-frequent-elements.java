/*
[1,2,5,3,0,0,2],k=2
-,nums.length<k

{[1,1],[2,2],[0,2],[5,1],[3,1]}
rank=2
*/
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> dic = new HashMap<>();
        int[] ans =new int[k];
        int i=0;
        for(int num :nums)
            dic.put(num,dic.getOrDefault(num,0)+1);
        Queue<Integer> maxHeap= new PriorityQueue<>((a,b)->Integer.compare(dic.get(b),dic.get(a)));
        for(int key:dic.keySet())
            maxHeap.add(key);
        while(k>0){
            ans[i++]=maxHeap.poll();
            k--;
        }   
       
        return ans;
    }
}