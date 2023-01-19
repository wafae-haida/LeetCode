class Solution {
    public boolean splitString(String s) {
        if (s == null || s.length()<=1) return false;
        return backtrack(0, s, new ArrayList<Long>());
    }
    
    public boolean backtrack(int pos, String s, ArrayList<Long> list) {
		// Base case where we reach till end of string and we have atleast 2 parts
        if (pos >= s.length()) return list.size() >= 2; 

        long num = 0;
        for (int i=pos; i<s.length(); i++) {
            num = num*10 + (s.charAt(i)-'0'); // "070" i = 1 -> 0.. i = 2 -> 7.. i =3 -> 70 
            if (list.size()==0 || list.get(list.size()-1) - num == 1) { // if it is first digit or difference is +1 valid
                
                list.add(num);  // add the number and continue to next index
                if (backtrack(i+1, s, list)) return true;
                list.remove(list.size()-1); // backtrack, done with that itteration coun't find it
                
            }
        }
        return false;
    }
}