class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        String[] arr = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for(String s : arr){
            String tmp = helper(s,dictionary);
            if(sb.isEmpty()){
                 if(tmp == "")
                    sb.append(s);
                else
                    sb.append(tmp);
            }else{
                sb.append(" ");
                 if(tmp == "")
                    sb.append(s);
                else
                    sb.append(tmp);
            }
        }
        return sb.toString();
    }
    
    public String helper(String s, List<String> dictionary){
        String res = "";
        for(String root : dictionary){
            int len = s.length();
            if(root.length() < s.length())
                len = root.length();
            String tmp = s.substring(0,len);
            if(root.equals(tmp)){
                if(res.length() == 0)
                    res = root;
                else{
                    if(root.length() < res.length())
                        res = root;
                }
            }
        }
        return res;
    }
}