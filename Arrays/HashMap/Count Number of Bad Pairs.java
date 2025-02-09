//Solution

import java.util.HashMap;

class Solution {
    public long countBadPairs(int[] nums) {
        HashMap<Integer, Integer> mp = new HashMap<>(); 
        long ans = 0; 
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int r = nums[i] - (i + 1);
            mp.put(r, mp.getOrDefault(r, 0) + 1);
            ans += (n - i - mp.get(r));
        }

        return ans;
    }
}

/*

Example 1:
Input: nums = [4,1,3,3]
Output: 5
Explanation: The pair (0, 1) is a bad pair since 1 - 0 != 1 - 4.
The pair (0, 2) is a bad pair since 2 - 0 != 3 - 4, 2 != -1.
The pair (0, 3) is a bad pair since 3 - 0 != 3 - 4, 3 != -1.
The pair (1, 2) is a bad pair since 2 - 1 != 3 - 1, 1 != 2.
The pair (2, 3) is a bad pair since 3 - 2 != 3 - 3, 1 != 0.
There are a total of 5 bad pairs, so we return 5.

Example 2:
Input: nums = [1,2,3,4,5]
Output: 0
Explanation: There are no bad pairs.
 
*/
