class Solution{
	public static boolean circularArrayLoop(int[] nums) {
		for (int i = 0; i<nums.length; i++) {
			if(nums[i] % nums.length == 0)
			    continue;
			boolean currentDirection = nums[i] >=0;
			int slowPtr = i;
			int fastPtr = i;

			while (slowPtr != fastPtr || slowPtr != -1 || fastPtr != -1) {
				slowPtr = nextStep(nums, slowPtr, currentDirection);
				if(slowPtr == -1)
				    break;
				fastPtr = nextStep(nums, fastPtr, currentDirection);
				if (fastPtr != -1) {
					fastPtr = nextStep(nums, fastPtr, currentDirection);
				}
				if (fastPtr == -1 || slowPtr == fastPtr) {
					break;
				}
			}
			if (slowPtr == fastPtr && slowPtr != -1) 
			    return true;
		}
		return false;
	}

	public static int nextStep(int[] nums, int currentIndex, boolean currentDirection) {
		boolean nextDirection = nums[currentIndex] >= 0;
		int findStep;
		if (nextDirection != currentDirection || nums[currentIndex] % nums.length == 0) {
			return -1;
		}
		findStep = currentIndex + nums[currentIndex];
		findStep = findStep % nums.length;
		if(findStep < 0)
            findStep = findStep + nums.length;
		return findStep;
	}
}