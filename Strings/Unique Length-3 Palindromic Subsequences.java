//SOlution

class Solution {
    public int countPalindromicSubsequence(String s) {
        int[] R = new int[26];
        for (char u : s.toCharArray()) {
            R[u - 'a']++;
        }
        int[] L = new int[26];
        HashSet<Integer> S = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            int t = s.charAt(i) - 'a';
            R[t]--;
            for (int j = 0; j < 26; j++) {
                if (L[j] > 0 && R[j] > 0) {
                    S.add(26 * t + j);
                }
            }
            L[t]++;
        }

        return S.size();
    }
}

/*

Example 1:
Input: s = "aabca"
Output: 3
Explanation: The 3 palindromic subsequences of length 3 are:
- "aba" (subsequence of "aabca")
- "aaa" (subsequence of "aabca")
- "aca" (subsequence of "aabca")

Example 2:
Input: s = "adc"
Output: 0
Explanation: There are no palindromic subsequences of length 3 in "adc".

Example 3:
Input: s = "bbcbaba"
Output: 4
Explanation: The 4 palindromic subsequences of length 3 are:
- "bbb" (subsequence of "bbcbaba")
- "bcb" (subsequence of "bbcbaba")
- "bab" (subsequence of "bbcbaba")
- "aba" (subsequence of "bbcbaba")
 

*/
