class Solution {
    public int largestInteger(int[] nums, int k) {

        // Stores the largest valid integer
        int ans = -1;

        // Check every number
        for (int x : nums) {

            // Counts how many subarrays contain x
            int count = 0;

            // Check every subarray of size k
            for (int i = 0; i <= nums.length - k; i++) {

                // Check every element in the current subarray
                for (int j = i; j < i + k; j++) {

                    // If x is found in the subarray
                    if (nums[j] == x) {

                        // Count this subarray
                        count++;

                        // No need to check x again
                        // in the same subarray
                        break;
                    }
                }
            }

            // x appears in exactly one subarray
            if (count == 1) {

                // Keep the largest valid number
                ans = Math.max(ans, x);
            }
        }

        return ans;
    }
}