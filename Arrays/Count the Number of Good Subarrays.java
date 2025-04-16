//Solution

class Solution {
    public long countGood(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        long count = 0, result = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            int val = nums[right];
            int currentFreq = freq.getOrDefault(val, 0);
            count += currentFreq;
            freq.put(val, currentFreq + 1);

            while (count >= k) {
                result += nums.length - right; 
                int leftVal = nums[left];
                int leftFreq = freq.get(leftVal);
                freq.put(leftVal, leftFreq - 1);
                count -= leftFreq - 1;
                left++;
            }
        }

        return result;
    }
}

/*
Example 1:

Input: nums = [1,1,1,1,1], k = 10
Output: 1
Explanation: The only good subarray is the array nums itself.
Example 2:

Input: nums = [3,1,4,3,2,2,4], k = 2
Output: 4
Explanation: There are 4 different good subarrays:
- [3,1,4,3,2,2] that has 2 pairs.
- [3,1,4,3,2,2,4] that has 3 pairs.
- [1,4,3,2,2,4] that has 2 pairs.
- [4,3,2,2,4] that has 2 pairs.


*/
