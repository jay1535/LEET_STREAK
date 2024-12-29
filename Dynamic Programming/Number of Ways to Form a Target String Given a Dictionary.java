//Solution

class Solution {
    public int numWays(String[] words, String target) {
        int mod = 1000000007;
        int n = words[0].length();
        int[][] freq = new int[n][26]; 
        
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < n; j++) {
                freq[j][words[i].charAt(j) - 'a']++;
            }
        }
        
        int[][] dp = new int[n+1][target.length()+1]; 
        
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target.length(); j++) {
                int charCount = freq[i-1][target.charAt(j-1) - 'a'];
                dp[i][j] = (dp[i-1][j] + (int)((long)charCount * dp[i-1][j-1] % mod)) % mod;
            }
        }
        
        return dp[n][target.length()];
    }
}

/*

Example 1:
Input: words = ["acca","bbbb","caca"], target = "aba"
Output: 6
Explanation: There are 6 ways to form target.
"aba" -> index 0 ("acca"), index 1 ("bbbb"), index 3 ("caca")
"aba" -> index 0 ("acca"), index 2 ("bbbb"), index 3 ("caca")
"aba" -> index 0 ("acca"), index 1 ("bbbb"), index 3 ("acca")
"aba" -> index 0 ("acca"), index 2 ("bbbb"), index 3 ("acca")
"aba" -> index 1 ("caca"), index 2 ("bbbb"), index 3 ("acca")
"aba" -> index 1 ("caca"), index 2 ("bbbb"), index 3 ("caca")

Example 2:
Input: words = ["abba","baab"], target = "bab"
Output: 4
Explanation: There are 4 ways to form target.
"bab" -> index 0 ("baab"), index 1 ("baab"), index 2 ("abba")
"bab" -> index 0 ("baab"), index 1 ("baab"), index 3 ("baab")
"bab" -> index 0 ("baab"), index 2 ("baab"), index 3 ("baab")
"bab" -> index 1 ("abba"), index 2 ("baab"), index 3 ("baab")
 
*/
