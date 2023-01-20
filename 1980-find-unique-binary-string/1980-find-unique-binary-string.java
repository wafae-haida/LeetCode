class Solution {
    String ans;
    public String findDifferentBinaryString(String[] nums) {
        if(nums==null || nums.length==0) return "";
        Set<String> set = new HashSet<>();
        for(String s:nums)set.add(s);
        dfs(set,0,"",nums.length);
        return ans;
    }
    
    boolean dfs(Set<String> set,int pos, String curr, int length){
        if(pos==length){
            if(set.contains(curr))return false;
            else{ans=curr;
                return true;}
        }
        if(dfs(set,pos+1,curr+0,length))return true;
        if(dfs(set,pos+1,curr+1,length))return true;
        return false;
    }
}

