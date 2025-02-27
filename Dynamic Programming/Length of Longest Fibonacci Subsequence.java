//Solution

class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        if (n < 3) return 0;
        
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(arr[i], i);
        }
        
        int[][] dp = new int[n][n];
        int maxLength = 0;
        
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < j; i++) {
                int next = arr[i] + arr[j];
                
                if (indexMap.containsKey(next)) {
                    int k = indexMap.get(next);
                    if (k > j) {                        
                        if (dp[i][j] > 0) {
                            dp[j][k] = dp[i][j] + 1;
                        } else {
                            dp[j][k] = 3;
                        }
                        maxLength = Math.max(maxLength, dp[j][k]);
                    }
                }
            }
        }
        
        return maxLength;
    }
}

/*

Example 1:
Input: arr = [1,2,3,4,5,6,7,8]
Output: 5
Explanation: The longest subsequence that is fibonacci-like: [1,2,3,5,8].

Example 2:
Input: arr = [1,3,7,11,12,14,18]
Output: 3
Explanation: The longest subsequence that is fibonacci-like: [1,11,12], [3,11,14] or [7,11,18].

*/
