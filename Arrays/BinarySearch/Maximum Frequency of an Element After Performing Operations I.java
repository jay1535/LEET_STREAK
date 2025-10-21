//Solution

class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
       int max = 0, min = Integer.MAX_VALUE;

        for (int i : nums) {
            max = Math.max(max, i);
            min = Math.min(min, i);
        }

        int[] freq = new int[max + 1];
        int[] prefix = new int[max + 1];
        for (int i : nums) {
            freq[i]++;
        }
        for (int i = min; i <= max; i++) {
            prefix[i] = prefix[i - 1] + freq[i];
        }
        int ans = 0;
        for (int i = min; i <= max; i++) {
            int low = 0;
            if (i - k - 1 > 0) {
                low = prefix[i - k - 1];
            }
            int high = 0;
            if (i + k <= max) {
                high = prefix[i + k];
            } else {
                high = prefix[max];
            }
            int toChange = high - low - freq[i];
            ans = Math.max(ans, freq[i] + (toChange >= numOperations ? numOperations : toChange));
        }
        return ans;
    }
}

/*

Example 1:

Input: nums = [1,4,5], k = 1, numOperations = 2

Output: 2

Explanation:

We can achieve a maximum frequency of two by:

Adding 0 to nums[1]. nums becomes [1, 4, 5].
Adding -1 to nums[2]. nums becomes [1, 4, 4].
Example 2:

Input: nums = [5,11,20,20], k = 5, numOperations = 1

Output: 2

Explanation:

We can achieve a maximum frequency of two by:

Adding 0 to nums[1].

*/
