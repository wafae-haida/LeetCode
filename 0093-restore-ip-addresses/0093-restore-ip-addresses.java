public class Solution {

    public List<String> restoreIpAddresses(String s) {
        List<String> ls = new ArrayList<String>();
        helper(s,ls,4,"");
        return ls;
    }
	
    private void helper(String s,List<String> ls,int dep,String res){
        int len = s.length();
        if(len>dep*3 || len<dep){
            return; //String too large or too small
        } 
        
        if(dep==1){
            if(isValid(s)){
               res += "." + s;
               ls.add(res);
            }
            return;
        }
        
        for(int i=0;i<len-(dep-1);i++){
            String sub = s.substring(0,i+1);
            if(isValid(sub)){
                if(dep!=4){
                    helper(s.substring(i+1),ls,dep-1,res+"."+sub);
                } else {
                    helper(s.substring(i+1),ls,dep-1,sub);
                }
            }
        }
    }
    
    private boolean isValid(String num){
        int val = Integer.valueOf(num);
        if(val >=0 && val <=255){
            return String.valueOf(val).length() == num.length(); // Additionally verify if there are no leading zeros
        }
        return false;  
    }
}