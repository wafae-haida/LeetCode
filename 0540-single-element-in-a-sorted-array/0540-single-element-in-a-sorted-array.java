class Solution {
    public int singleNonDuplicate(int[] nums) {
              int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            // Calculating mid point
            int mid = l + (r - l) / 2;
            if (mid % 2 == 1) mid--;
            // If the element at mid and mid + 1 are the same then
            // the single element must be after the mid point
            if (nums[mid] == nums[mid + 1]) {
                l = mid + 2;
            } else {
                // Otherwise we must search before the mid point
                r = mid;
            }
        }
        return nums[l];
    }
}