//ascending order, distinct 
//nums[mid]<nums[mid+1] && nums[mid]>nums[mid-1] => [0,1,2]4[5,6,7]
//                                               => [7,6,0]2[3,4,5]
//                                                                 =>mid--


//nums[mid]<nums[mid+1] && nums[mid]<nums[mid-1] => not possible
//nums[mid]>nums[mid+1] && nums[mid]>nums[mid-1] => [4,5,6]7[0,1,2] Or [0,1,2,4,5,6,7] 
//                                                                  ->Ok
//nums[mid]>nums[mid+1] && nums[mid]<nums[mid-1] => not possible

//search target int rotated nums => O(log n) 

class Solution {
    public int search(int[] A, int target) {
        int start = 0;
        int end = A.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (A[mid] == target) return mid;
        
            if (A[start] <= A[mid]) {
                if (target >= A[start] && target < A[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target > A[mid] && target <= A[end]) {
                    start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
    }
    return A[end] == target ? start : -1;
    }
}
