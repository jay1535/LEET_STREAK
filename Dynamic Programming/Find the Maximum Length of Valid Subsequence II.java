//Solution

class Solution {

    public int maximumLength(int[] nums, int k) {
        int[][] dp = new int[k][k];
        int res = 0;
        for (int num : nums) {
            num %= k;
            for (int prev = 0; prev < k; prev++) {
                dp[prev][num] = dp[num][prev] + 1;
                res = Math.max(res, dp[prev][num]);
            }
        }
        return res;
    }
}

/*

Example 1:
Input: nums = [1,2,3,4,5], k = 2
Output: 5
Explanation:
The longest valid subsequence is [1, 2, 3, 4, 5].

Example 2:
Input: nums = [1,4,2,3,1,4], k = 3
Output: 4
Explanation:
The longest valid subsequence is [1, 4, 1, 4].

*/
