/*
Understanding the problem:
    s="example",length=m;t="exmaple",length=n
    s="eXamPle";t="example"
    min s="a";t="b"
        Questions:
            What are the ranges of m and n?
            Do s and t contains lowercase english letters or Uppercase or both? Both
                If it contains both do e.g:'A'=='a'? I'll asume that 'A'!='a' 
            Is there any digits or symboles? No
Target:
    find a minsubstring from s that contains all the characters of t including duplicates.
    return a string.
Solution:
    Loop over t and check if its caracters are included in s then chrink the left side and check again and again until one of the t characters is missing the go to chrink from the right side until one of the t characters is missing then return the result.
        Problem how i can check all caracters of t without increasing the time complexity?
        
*/
class Solution {
    public String minWindow(String s, String t) { 
        Map<Character,Integer> dic=new HashMap<>();
        int have=0;
        String rs="";
        int start=0;
        int len=s.length()+1;
        int substart=0;
        for(char c:t.toCharArray())
            dic.put(c,dic.getOrDefault(c,0)+1);
        for(int i=0;i<s.length();i++){
            char cur=s.charAt(i);
            if(dic.containsKey(cur)){
                dic.put(cur,dic.get(cur)-1);
                if(dic.get(cur) == 0) 
                    have++;
            }
            while(have==dic.size()){
                if(len>i-start+1){
                    len=i-start+1;
                    substart=start;
                }
                char deleted=s.charAt(start++);
                if(dic.containsKey(deleted)){
                    if(dic.get(deleted)==0)
                        have--;
                    dic.put(deleted,dic.get(deleted)+1);
                }
            }   
        }
        return len>s.length()?"":s.substring(substart,substart+len);
    } 
}