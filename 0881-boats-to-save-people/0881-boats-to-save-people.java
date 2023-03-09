class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int res = 0;
        int left = 0;
        int right = people.length - 1;
        while(left <= right){
            if(people[right] + people[left] <= limit){
                res++;
                right--;
                left++;
            }else{
                res++;
                right--;
            }    
        }
        return res;
    }
}