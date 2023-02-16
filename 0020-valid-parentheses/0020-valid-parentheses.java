/*
Understanding:
    "((}}[{)}]))"
    ({)}->false
    {}
    []
Target:
    return true or false
Solution:
    dic:Key(->value-> )
        Key{->value-> }
        Key[->value-> ]
    check->left then ->right ...store->left then ->right
*/
class Solution {
    public boolean isValid(String s) {
        Map<Character,Character> dic=new HashMap<>();
        Stack<Character> stack=new Stack<>();
        dic.put(')','(');
        dic.put(']','[');
        dic.put('}','{');
        for(char c:s.toCharArray()){
            if(dic.containsKey(c)){
                if(!stack.isEmpty() && dic.get(c)==stack.peek()){
                    stack.pop();
                }else
                    return false;
            }else
                stack.push(c);
        }
        if(stack.isEmpty())
            return true;
        return false;
    }
}