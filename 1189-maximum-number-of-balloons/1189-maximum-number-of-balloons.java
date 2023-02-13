/*
    "text"
    use the string letters to form balloon as much as i can
    every letter must used once 
    
    return number of balloon i ve created

*/
class Solution {
    public int maxNumberOfBalloons(String text) {
        Map<Character,Integer> dicText=new HashMap<>();
        String Target="balloon";
        int ans=0;
        for(char c:text.toCharArray())
            dicText.put(c,dicText.getOrDefault(c,0)+1);
        boolean cont=true;
        while(cont){
            for(char c:Target.toCharArray()){
                if(dicText.containsKey(c) && dicText.get(c)>0)
                    dicText.put(c,dicText.get(c)-1);
                else{
                    cont=false;
                    return ans;
                }
            }
            ++ans;
        }
        return ans;
    }
}