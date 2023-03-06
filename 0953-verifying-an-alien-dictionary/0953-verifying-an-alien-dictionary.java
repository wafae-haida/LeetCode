class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> dic = new HashMap<>();
        int idx = 0;
        for(char c : order.toCharArray())
            dic.put(c,idx++);
        for(int i = 0 ; i < words.length - 1 ; i++){
            String w1 = words[i];
            String w2 = words[i + 1];
            for(int j = 0 ; j < w1.length(); j++){
                if(j == w2.length())
                    return false;
                if(dic.get(w1.charAt(j)) > dic.get(w2.charAt(j)))
                   return false;
                if(dic.get(w1.charAt(j)) < dic.get(w2.charAt(j)))
                   break;
            }
        }
         return true;          
    }
}