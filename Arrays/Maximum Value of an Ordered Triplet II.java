//Solution

class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long max =  0;
        int a = nums[0];
        int b = Integer.MIN_VALUE;
        for(int i=1; i<n-1; i++) {
            b = Math.max(b, a-nums[i]);
            a = Math.max(a, nums[i]);
            max = Math.max(max, (long)b*nums[i+1]);
        }
        return max;
    }
}

/*

Example 1:
Input: nums = [12,6,1,2,7]
Output: 77
Explanation: The value of the triplet (0, 2, 4) is (nums[0] - nums[2]) * nums[4] = 77.
It can be shown that there are no ordered triplets of indices with a value greater than 77. 

Example 2:
Input: nums = [1,10,3,4,19]
Output: 133
Explanation: The value of the triplet (1, 2, 4) is (nums[1] - nums[2]) * nums[4] = 133.
It can be shown that there are no ordered triplets of indices with a value greater than 133.

Example 3:
Input: nums = [1,2,3]
Output: 0
Explanation: The only ordered triplet of indices (0, 1, 2) has a negative value of (nums[0] - nums[1]) * nums[2] = -3. Hence, the answer would be 0.

*/
