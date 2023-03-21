class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(stack.isEmpty() || stack.peek() != c)
                stack.push(c);
            else
                stack.pop();                      
        }
        char[] arr = new char[stack.size()];
        for(int i = stack.size() - 1; i >= 0; i--)
            arr[i] = stack.pop();
        return new String(arr);
    }
}