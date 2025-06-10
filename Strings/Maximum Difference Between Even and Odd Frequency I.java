//Solution

class Solution {
    public int maxDifference(String s) {
        int []arr = new int[26];
        for(char ch:s.toCharArray())arr[ch-'a']++;
        int oddmax=0, evenmax=s.length();

        for(int i:arr)if(i%2==1)oddmax=Math.max(i, oddmax);
        else evenmax=Math.min(i==0?s.length():i, evenmax);

        return oddmax-evenmax;
    }
}

/*

Example 1:
Input: s = "aaaaabbc"
Output: 3
Explanation:
The character 'a' has an odd frequency of 5, and 'b' has an even frequency of 2.
The maximum difference is 5 - 2 = 3.

Example 2:
Input: s = "abcabcab"
Output: 1
Explanation:
The character 'a' has an odd frequency of 3, and 'c' has an even frequency of 2.
The maximum difference is 3 - 2 = 1.

*/
