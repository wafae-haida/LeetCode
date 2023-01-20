
class Solution{
     String ans="";
    public String findDifferentBinaryString(String[] nums) {
        HashSet<String> dict=new HashSet<>();
        for(String s:nums)
            dict.add(s);
        solve(0,nums.length,dict,"");
        return ans;
    }
    
    public  boolean solve(int ci,int ti, HashSet<String> dict,String asf){
        if(ci==ti){
            if(!dict.contains(asf)){
                ans=asf;
                return true; 
            }
            return false;
        }
        if(solve(ci+1,ti,dict,asf+1))return true;
        if(solve(ci+1,ti,dict,asf+0))return true;
        return false;
    }
}  
