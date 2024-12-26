//Solution

class Solution {
  public int findTargetSumWays(int[] nums, int target) {
    final int sum = Arrays.stream(nums).sum();
    if (sum < Math.abs(target) || (sum + target) % 2 == 1)
      return 0;
    return knapsack(nums, (sum + target) / 2);
  }

  private int knapsack(int[] nums, int target) {
    final int n = nums.length;
    int[][] dp = new int[n + 1][target + 1];
    dp[0][0] = 1;

    for (int i = 1; i <= n; ++i) {
      final int num = nums[i - 1];
      for (int j = 0; j <= target; ++j)
        if (j < num)
          dp[i][j] = dp[i - 1][j];
        else
          dp[i][j] = dp[i - 1][j] + dp[i - 1][j - num];
    }

    return dp[n][target];
  }
}

/*

Example 1:
Input: nums = [1,1,1,1,1], target = 3
Output: 5
Explanation: There are 5 ways to assign symbols to make the sum of nums be target 3.
-1 + 1 + 1 + 1 + 1 = 3
+1 - 1 + 1 + 1 + 1 = 3
+1 + 1 - 1 + 1 + 1 = 3
+1 + 1 + 1 - 1 + 1 = 3
+1 + 1 + 1 + 1 - 1 = 3

Example 2:
Input: nums = [1], target = 1
Output: 1

*/
