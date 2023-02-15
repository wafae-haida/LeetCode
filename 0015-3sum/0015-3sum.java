class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans= new ArrayList<>();
        
        for(int i=0;i<nums.length-2;i++){
            if(i==0 || (i>0 && nums[i]!=nums[i-1])){
                int left=i+1;
                int right=nums.length-1;
                while(left<right){
                    if(nums[i]+nums[left]+nums[right]==0){
                        List<Integer> preAns= new ArrayList<>(Arrays.asList(nums[i],nums[left],nums[right]));
                        ans.add(preAns);
                        while(left<right && nums[left]==nums[left+1])left++;
                        while(left<right && nums[right]==nums[right-1])right--;
                        right--;
                        left++;
                    }else if(nums[i]+nums[left]+nums[right]>0)
                        right--;
                    else
                        left++;
                    
                    
                }
            }
        }
        return ans;
    }
}