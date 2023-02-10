class Solution {
    public int minSwapsCouples(int[] row) {
        int n = row.length;
		// index of each num in row
        int[] pos = new int[n];
        
        for(int i=0; i<n; i++)
            pos[row[i]] = i;
        
        int ans = 0;
        
		// iterate for each pair (skipping next element)
        for(int i=0; i<n; i += 2) {
			// if curr num is even? pair should be next odd num else it should be prev even num
            int actualPair = row[i] + (row[i] % 2 == 0 ? 1 : -1);
            int curPair = row[i+1];
            
            if( curPair != actualPair ) {
				// swap cur pair with actual pair (use pos arr to get pos of actual pair)
                swap(row, i+1, pos[actualPair]);
				
				// update pos arr to update indices of swapped nums
                swap(pos, curPair, actualPair);
				
                ans++;
            }
        }
        return ans;
    }
    
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}