//Solution

class Solution {
    private int mod = (int) 1e9 + 7;

    public int countGoodStrings(int low, int high, int zero, int one) {
        if (zero > one) 
            return countGoodStrings(low, high, one, zero);

        int dp[] = new int[high + 1], res = 0;
        dp[0] = 1;

        for (int i = 1; i <= high; i++) {
            if (i >= zero)
                dp[i] = (dp[i] + dp[i - zero]) % mod;
            if (i >= one)
                dp[i] = (dp[i] + dp[i - one]) % mod;
            if (i >= low)
                res = (res + dp[i]) % mod;
        }

        return res;
    }
}

/*

Example 1:
Input: low = 3, high = 3, zero = 1, one = 1
Output: 8
Explanation: 
One possible valid good string is "011". 
It can be constructed as follows: "" -> "0" -> "01" -> "011". 
All binary strings from "000" to "111" are good strings in this example.

Example 2:
Input: low = 2, high = 3, zero = 1, one = 2
Output: 5
Explanation: The good strings are "00", "11", "000", "110", and "011".

*/
