
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> dic= new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int diff=target-nums[i];
            if(dic.containsKey(diff))return new int[]{dic.get(diff),i};
            dic.put(nums[i],i);
        }
        return new int[2];
    }
}