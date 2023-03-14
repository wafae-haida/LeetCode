class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums2){
            while(!stack.isEmpty() && stack.peek()<num)
                map.put(stack.pop(),num);
            stack.push(num);
        }
        int[] ans = new int[nums1.length];
        
        for(int i = 0 ; i < ans.length; i++){
            if(!map.containsKey(nums1[i]))
                ans[i] = -1;
            else
                ans[i] = map.get(nums1[i]);
        }
            
        return ans;
    }
}