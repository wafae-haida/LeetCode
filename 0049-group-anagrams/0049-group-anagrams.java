class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res =new ArrayList<>();
        Map<String,List<String>> dic=new HashMap<>();
        for(String str:strs){
            int[] hash=new int[26];
            for(char c:str.toCharArray()){
                hash[c-'a']++;
            }
            String key= new String(Arrays.toString(hash));
            dic.computeIfAbsent(key,k->new ArrayList());
            dic.get(key).add(str);
        }
        res.addAll(dic.values());
        return res;
    }
}