class Solution {
    public boolean find132pattern(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int second_max = Integer.MIN_VALUE;
        for(int i = nums.length - 1 ; i >= 0; i--){
            if(nums[i] < second_max)
                return true;
            while(!stack.isEmpty() && nums[i] > stack.peek()){
                second_max = Math.max(second_max, stack.pop());
            }   
           stack.push(nums[i]);
        }
        return false;
    }
}