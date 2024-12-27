//Solution

class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int ans = 0;
        int n = values.length;
        int val = values[0];
        for (int i = 1; i < n; i++) { 
            ans = Math.max(ans , values[i] + val-1);
            val = Math.max(values[i] , val-1);
        }
        return ans;
    }
}

/*

Example 1:
Input: values = [8,1,5,2,6]
Output: 11
Explanation: i = 0, j = 2, values[i] + values[j] + i - j = 8 + 5 + 0 - 2 = 11

Example 2:
Input: values = [1,2]
Output: 2
 
*/
