class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0 ; i < s.length() ; i++){
            char c = s.charAt(i);
            if(Character.isAlphabetic(c))
                continue;
            if(c == '(')
                stack.push(i);
            else{
                if(!stack.isEmpty() && s.charAt(stack.peek()) == '(' && s.charAt(i) == ')')
                    stack.pop();
                else
                    stack.push(i); 
            }
        }
        List<Integer> seen = new ArrayList<>(stack);
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < s.length() ; i++){
            if(!seen.contains(i))
                sb.append(s.charAt(i));
        }
        return sb.toString();  
    }
}