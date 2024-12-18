//Solution

class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] freq = new int[26];

        for (char c : s.toCharArray())
            freq[c - 'a']++;

        int pendingLetterIndex = -1;
        StringBuilder sb = new StringBuilder();

        for (int i = 25; i >= 0; i--) {
            if (freq[i] == 0)
                continue;

            if (pendingLetterIndex > 0) {
                sb.append((char) ('a' + i));
                freq[i]--;
                i = pendingLetterIndex;
                pendingLetterIndex = -1;

            } else {
                for (int j = 0; j < repeatLimit && freq[i] > 0; j++, freq[i]--)
                    sb.append((char) ('a' + i));

                if (freq[i] > 0)
                    pendingLetterIndex = i + 1;
            }
        }
        
        return sb.toString();
    }
}

/*

Example 1:
Input: s = "cczazcc", repeatLimit = 3
Output: "zzcccac"
Explanation: We use all of the characters from s to construct the repeatLimitedString "zzcccac".
The letter 'a' appears at most 1 time in a row.
The letter 'c' appears at most 3 times in a row.
The letter 'z' appears at most 2 times in a row.
Hence, no letter appears more than repeatLimit times in a row and the string is a valid repeatLimitedString.
The string is the lexicographically largest repeatLimitedString possible so we return "zzcccac".
Note that the string "zzcccca" is lexicographically larger but the letter 'c' appears more than 3 times in a row, so it is not a valid repeatLimitedString.

Example 2:
Input: s = "aababab", repeatLimit = 2
Output: "bbabaa"
Explanation: We use only some of the characters from s to construct the repeatLimitedString "bbabaa". 
The letter 'a' appears at most 2 times in a row.
The letter 'b' appears at most 2 times in a row.
Hence, no letter appears more than repeatLimit times in a row and the string is a valid repeatLimitedString.
The string is the lexicographically largest repeatLimitedString possible so we return "bbabaa".
Note that the string "bbabaaa" is lexicographically larger but the letter 'a' appears more than 2 times in a row, so it is not a valid repeatLimitedString.
 
*/
