class Solution {
    public List<Integer> findAnagrams(String a, String dic) {
       	List<Integer> ans = new ArrayList<Integer> ();
		// If len of b is more than len of a, then there could be no anagram of b in a
		if (dic.length() > a.length()) 
            return ans;
        HashMap<Character, Integer> countDic = new HashMap<>();
		HashMap<Character, Integer> countA = new HashMap<>();
		// Storing frequency of characters for length of dic
		for (int i = 0; i < dic.length() ; i++) {
	        countA.put(a.charAt(i), countA.getOrDefault(a.charAt(i), 0) + 1);
			countDic.put(dic.charAt(i), countDic.getOrDefault(dic.charAt(i), 0) + 1);
		}
		// A specific case where we add the first index if matched
		if (countA.equals(countDic))
			ans.add(0);
		int Left = 0, right = dic.length();
		while (right < a.length()) {
			countA.put(a.charAt(right), countA.getOrDefault(a.charAt(right), 0) + 1);
			countA.put(a.charAt(Left), countA.get(a.charAt(Left)) - 1);
			if (countA.get(a.charAt(Left)) == 0)
                countA.remove(a.charAt(Left));
			Left++;
			right++;
			if (countA.equals(countDic)) {
				ans.add(Left);
			}
		}
		return ans; 
    }
}