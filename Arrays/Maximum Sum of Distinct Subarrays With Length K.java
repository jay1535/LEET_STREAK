// Solution

class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long[] prefixSum = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = nums[i - 1] + prefixSum[i - 1];
        }
        int[] index = new int[100001];
        long maxSum = 0;
        for (int e = 1, s = 0; e <= nums.length; e++) {
            s = Math.max(s, Math.max(e - k, index[nums[e - 1]]));
            if (e - s == k) {
                maxSum = Math.max(maxSum, prefixSum[e] - prefixSum[s]);
            }
            index[nums[e - 1]] = e;
        }
        return maxSum;
    }
}

/*

Example 1:
Input: nums = [1,5,4,2,9,9,9], k = 3
Output: 15
Explanation: The subarrays of nums with length 3 are:
- [1,5,4] which meets the requirements and has a sum of 10.
- [5,4,2] which meets the requirements and has a sum of 11.
- [4,2,9] which meets the requirements and has a sum of 15.
- [2,9,9] which does not meet the requirements because the element 9 is repeated.
- [9,9,9] which does not meet the requirements because the element 9 is repeated.
We return 15 because it is the maximum subarray sum of all the subarrays that meet the conditions

Example 2:
Input: nums = [4,4,4], k = 3
Output: 0
Explanation: The subarrays of nums with length 3 are:
- [4,4,4] which does not meet the requirements because the element 4 is repeated.
We return 0 because no subarrays meet the conditions.
 
*/
