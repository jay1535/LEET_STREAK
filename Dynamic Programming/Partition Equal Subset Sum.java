//SOlution

class Solution {
    public boolean canPartition(int[] nums) {
        int total = 0;
        for (int num : nums) total += num;
        
     
        if (total % 2 != 0) return false;
        
        int target = total / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true; 

        for (int num : nums) {
            for (int i = target; i >= num; i--) {
                dp[i] = dp[i] || dp[i - num];
            }
        }

        return dp[target];
    }
}

/*

Example 1:
Input: nums = [1,5,11,5]
Output: true
Explanation: The array can be partitioned as [1, 5, 5] and [11].

Example 2:
Input: nums = [1,2,3,5]
Output: false
Explanation: The array cannot be partitioned into equal sum subsets.

*/
