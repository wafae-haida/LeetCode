class Solution {
    public List<Integer> findAnagrams(String a, String b) {
       		List<Integer> ans = new ArrayList<Integer> ();
		// If len of b is more than len of a, then there could be no anagram of b in a
		if (b.length() > a.length()) return ans;
		// Hash map for count of a
		HashMap<Character, Integer> countA = new HashMap<>();
		// Hash map for count of b
		HashMap<Character, Integer> countB = new HashMap<>();
		// Storing frequency of characters for length of b
		for (int i = 0; i<b.length(); i++) {
			if (!countA.containsKey(a.charAt(i))) countA.put(a.charAt(i), 1);
			else countA.put(a.charAt(i), countA.get(a.charAt(i)) + 1);

			if (!countB.containsKey(b.charAt(i))) countB.put(b.charAt(i), 1);
			else countB.put(b.charAt(i), countB.get(b.charAt(i)) + 1);
		}
		// A specific case where we add the first index if matched
		if (countA.equals(countB)) {
			ans.add(0);
		}
		// We declare the sliding window pointer
		int slidingLeft, right;
		slidingLeft = 0;
		right = b.length();
		while (right<a.length()) {
			if (!countA.containsKey(a.charAt(right))) countA.put(a.charAt(right), 1);
			else countA.put(a.charAt(right), countA.get(a.charAt(right)) + 1);

			countA.put(a.charAt(slidingLeft), countA.get(a.charAt(slidingLeft)) - 1);
			if (countA.get(a.charAt(slidingLeft)) == 0) countA.remove(a.charAt(slidingLeft));
			slidingLeft++;
			right++;
			if (countA.equals(countB)) {
				// If all the characters from b with their respective frequency are found at this index, we append.
				ans.add(slidingLeft);
			}
		}
		return ans; 
    }
}