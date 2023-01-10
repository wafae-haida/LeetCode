class Solution {
    public int maximumRemovals(String s, String p, int[] removable) {
        int left = 0;
        int right = removable.length - 1;
        while (left <= right) {
            int mid = left + right >> 1;
            StringBuffer buffer = new StringBuffer(s);
			// replace the removeable[i] with ' ' so that we can delete it
            for (int i = 0; i <= mid; i++) {
                buffer.setCharAt(removable[i], ' ');
            }
			// find out the maximum element using binary search here
            if (!isSubsequence(buffer.toString(), p)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right + 1;
    }
	
	// check if p is the subsequence of s
    private boolean isSubsequence(String s, String p) {
        int n = p.length();
        int m = s.length();
        int i = 0;
        int j = 0;
        while (i < n && j < m) {
            if (p.charAt(i) == s.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == n;
    }
}
