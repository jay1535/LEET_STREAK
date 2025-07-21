//Solution

class Solution {
    public String makeFancyString(String s) {
        StringBuilder result = new StringBuilder();
        for (char c : s.toCharArray()) {
            int n = result.length();
            if (n < 2 || !(result.charAt(n - 1) == c && result.charAt(n - 2) == c)) {
                result.append(c);
            }
        }
        return result.toString();
    }
}

/*

Example 1:
Input: s = "leeetcode"
Output: "leetcode"
Explanation:
Remove an 'e' from the first group of 'e's to create "leetcode".
No three consecutive characters are equal, so return "leetcode".

Example 2:
Input: s = "aaabaaaa"
Output: "aabaa"
Explanation:
Remove an 'a' from the first group of 'a's to create "aabaaaa".
Remove two 'a's from the second group of 'a's to create "aabaa".
No three consecutive characters are equal, so return "aabaa".

Example 3:
Input: s = "aab"
Output: "aab"
Explanation: No three consecutive characters are equal, so return "aab".

*/
