//Solution

class Solution {
    public boolean isVowel(char ch){
        return ch == 'a' || ch == 'e' ||  ch == 'i' || ch == 'o' || ch == 'u';
    }
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length, len = queries.length;
        int vowelCount[] = new int[n];
        int res[] = new int[len];
        int count = 0;
        for(int i=0; i<n; i++){
            if(isVowel(words[i].charAt(0)) && isVowel(words[i].charAt(words[i].length()-1))) count++;
            vowelCount[i] = count;
        }
        for(int i=0; i<len; i++){
            int countInRange = vowelCount[queries[i][1]];
            if(queries[i][0]-1>=0) countInRange -= vowelCount[queries[i][0]-1];
            if(countInRange>0) res[i] = countInRange;
        }
        return res;
    }
}

/*

Example 1:
Input: words = ["aba","bcb","ece","aa","e"], queries = [[0,2],[1,4],[1,1]]
Output: [2,3,0]
Explanation: The strings starting and ending with a vowel are "aba", "ece", "aa" and "e".
The answer to the query [0,2] is 2 (strings "aba" and "ece").
to query [1,4] is 3 (strings "ece", "aa", "e").
to query [1,1] is 0.
We return [2,3,0].

Example 2:
Input: words = ["a","e","i"], queries = [[0,2],[0,1],[2,2]]
Output: [3,2,1]
Explanation: Every string satisfies the conditions, so we return [3,2,1].

*/
