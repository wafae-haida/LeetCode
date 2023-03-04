class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> heap = new PriorityQueue<>();
        for(int i = 0 ; i < k; i++){
            heap.add(nums[i]);
        }
        for(int i = k ; i < nums.length ; i++){
            if(heap.peek() < nums[i]){
                heap.poll();
                heap.add(nums[i]);
            }
        }
        return heap.peek();
    }
}