class Solution {
    public int calculate(String s) {
        if(s == null || s.isEmpty())
            return 0;
        char operation = '+';
        int res = 0, cur = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0 ; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c))
                cur = (cur * 10) + (c -'0');
            if(!Character.isDigit(c) && !Character.isWhitespace(c) || i == s.length() - 1){
                if(operation == '+')
                    stack.push(cur);
                else if(operation == '-')
                    stack.push(-cur);
                else if(operation == '*')
                    stack.push(stack.pop() * cur);
                else if(operation == '/') 
                    stack.push(stack.pop() / cur);
                operation = c;
                cur = 0;
            } 
        }
        while(!stack.isEmpty())
            res += stack.pop();
        return res;
    }
}