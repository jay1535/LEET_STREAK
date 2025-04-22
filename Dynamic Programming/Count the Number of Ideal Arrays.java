//Solution

class Solution {
    int MOD = 1000000007;
    int[][] cnt = new int[10001][14];
    int[][] comb = new int[10001][14];

    public Solution() {
        for (int s = 0; s < 10001; s++) {
            for (int r = 0; r <= Math.min(s, 13); r++) {
                comb[s][r] = (r == 0 || r == s) ? 1 : (comb[s - 1][r - 1] + comb[s - 1][r]) % MOD;
            }
        }

        for (int div = 1; div < 10001; div++) {
            cnt[div][0]++;
            for (int i = div * 2; i < 10001; i += div) {
                for (int bars = 0; bars < 13; bars++) {
                    if (cnt[div][bars] > 0)
                        cnt[i][bars + 1] += cnt[div][bars];
                }
            }
        }
    }

    public int idealArrays(int n, int maxValue) {
        int res = 0;
        for (int i = 1; i <= maxValue; i++) {
            for (int bars = 0; bars < Math.min(14, n); bars++) {
                res = (int)((res + 1L * cnt[i][bars] * comb[n - 1][bars]) % MOD);
            }
        }
        return res;
    }
}

/*

Example 1:

Input: n = 2, maxValue = 5
Output: 10
Explanation: The following are the possible ideal arrays:
- Arrays starting with the value 1 (5 arrays): [1,1], [1,2], [1,3], [1,4], [1,5]
- Arrays starting with the value 2 (2 arrays): [2,2], [2,4]
- Arrays starting with the value 3 (1 array): [3,3]
- Arrays starting with the value 4 (1 array): [4,4]
- Arrays starting with the value 5 (1 array): [5,5]
There are a total of 5 + 2 + 1 + 1 + 1 = 10 distinct ideal arrays.
Example 2:

Input: n = 5, maxValue = 3
Output: 11
Explanation: The following are the possible ideal arrays:
- Arrays starting with the value 1 (9 arrays): 
   - With no other distinct values (1 array): [1,1,1,1,1] 
   - With 2nd distinct value 2 (4 arrays): [1,1,1,1,2], [1,1,1,2,2], [1,1,2,2,2], [1,2,2,2,2]
   - With 2nd distinct value 3 (4 arrays): [1,1,1,1,3], [1,1,1,3,3], [1,1,3,3,3], [1,3,3,3,3]
- Arrays starting with the value 2 (1 array): [2,2,2,2,2]
- Arrays starting with the value 3 (1 array): [3,3,3,3,3]
There are a total of 9 + 1 + 1 = 11 distinct ideal arrays.

*/
