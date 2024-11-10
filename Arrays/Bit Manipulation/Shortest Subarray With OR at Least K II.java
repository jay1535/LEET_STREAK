// Solution

class Solution {

    private int val(int[] cnt) {
        int temp = 0;
        for (int i = 0; i < 30; i++) {
            if (cnt[i] != 0) {
                temp ^= 1 << i;
            }
        }
        return temp;
    }

    public int minimumSubarrayLength(int[] nums, int k) {
        int[] cnt = new int[30];
        int p = 0;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < 30; j++) {
                cnt[j] += (nums[i] >> j) & 1;
            }
            while (p <= i && val(cnt) >= k) {
                res = Math.min(res, i - p + 1);
                for (int j = 0; j < 30; j++) {
                    cnt[j] -= (nums[p] >> j) & 1;
                }
                p++;
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}

/* 

Example 1:
Input: nums = [1,2,3], k = 2
Output: 1
Explanation:
The subarray [3] has OR value of 3. Hence, we return 1.

Example 2:
Input: nums = [2,1,8], k = 10
Output: 3
Explanation:
The subarray [2,1,8] has OR value of 11. Hence, we return 3.

Example 3:
Input: nums = [1,2], k = 0
Output: 1
Explanation:
The subarray [1] has OR value of 1. Hence, we return 1.

*/
