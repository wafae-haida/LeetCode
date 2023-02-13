class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character,Character> sourceToDes=new HashMap<>();
        Map<Character,Character> desToSource=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char source=s.charAt(i),dest=t.charAt(i);
            char sourceResult=sourceToDes.getOrDefault(source,dest);
            if(sourceResult!=dest) return false;
            sourceToDes.put(source,sourceResult);
            char destReturn=desToSource.getOrDefault(dest,source);
            if(destReturn!=source) return false;
            desToSource.put(dest,destReturn);
        }
        return true;
    }
}