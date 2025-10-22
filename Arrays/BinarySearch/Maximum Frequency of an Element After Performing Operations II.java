//Solution

class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        if (nums.length == 1) return 1;
        Arrays.sort(nums);
        int right = Math.min(numOperations, prepareMaxNums(nums, k));
        int index = 0, left = 0, freq = 0;

        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];

            freq = (i > 0 && nums[i] == nums[i - 1]) ? freq + 1 : 1;

            int min = n - k, max = n + k;

            while (true) {
                if (index < nums.length && nums[index] < min) {
                    index++;
                } else if (left < nums.length && nums[left] <= max) {
                    left++;
                } else {
                    break;
                }
            }
            
            right = Math.max(right, Math.min(freq + numOperations, left - index));
        }
        return right;
    }

    public int prepareMaxNums(int[] nums, int k) {
        int left = 0;
        int right = 0;
        
        for (int i = 0; i < nums.length; i++) {
            int target = nums[i] + 2 * k;

            while (left < nums.length && nums[left] <= target) {
                left++;
            }

            right = Math.max(right, left - i);
        }

        return right;
    }
}


/*
Example 1:

Input: nums = [1,4,5], k = 1, numOperations = 2

Output: 2

Explanation:

We can achieve a maximum frequency of two by:

Adding 0 to nums[1], after which nums becomes [1, 4, 5].
Adding -1 to nums[2], after which nums becomes [1, 4, 4].
Example 2:

Input: nums = [5,11,20,20], k = 5, numOperations = 1

Output: 2

Explanation:

We can achieve a maximum frequency of two by:

Adding 0 to nums[1].
*/
