// Solution

class Solution {
    public int maximumLength(String s) {
        int[][] freq = new int[26][51];
        int n = s.length(), res = -1;
        for (int i = 0; i < n; ){
            int j = i, count = 0;
            char ch = s.charAt(i);
            while (j < n && s.charAt(j) == ch){
                count++; j++;
            }
            int c = ch - 'a';
            if (++freq[c][count] == 3)
                res = Math.max(res, count);
            else{
                if (count > 1){
                    int m = count - 1;
                    freq[c][m] += 2;
                    if (freq[c][m] >= 3 && m > res)
                        res = m;
                }
                if (count > 2){
                    int m = count - 2;
                    freq[c][m] += 3;
                    res = Math.max(res, m);
                }
            }
            i = j;
        }
        return res;
    }
}


/*

Example 1:
Input: s = "aaaa"
Output: 2
Explanation: The longest special substring which occurs thrice is "aa": substrings "aaaa", "aaaa", and "aaaa".
It can be shown that the maximum length achievable is 2.

Example 2:
Input: s = "abcdef"
Output: -1
Explanation: There exists no special substring which occurs at least thrice. Hence return -1.

Example 3:
Input: s = "abcaba"
Output: 1
Explanation: The longest special substring which occurs thrice is "a": substrings "abcaba", "abcaba", and "abcaba".
It can be shown that the maximum length achievable is 1.
 

*/
