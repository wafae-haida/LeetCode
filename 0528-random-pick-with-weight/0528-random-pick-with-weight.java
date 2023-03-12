class Solution {
    int[] prefixSum;
    Random rand;
    
    public Solution(int[] w) {
        prefixSum = new int[w.length];
        prefixSum[0] = w[0];
        for (int i = 1; i < w.length; i++) {
            prefixSum[i] = prefixSum[i-1] + w[i];
        }
        rand = new Random();
    }
    
    public int pickIndex() {
        int target = rand.nextInt(prefixSum[prefixSum.length-1]) + 1;
        int left = 0, right = prefixSum.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (prefixSum[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}


/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */