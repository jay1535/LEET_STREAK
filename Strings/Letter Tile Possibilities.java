//Solution

class Solution {
    int ans;  

    public int numTilePossibilities(String tiles) {
        int[] hash = new int[26];  
        
        for (char ch : tiles.toCharArray()) 
            hash[ch - 'A']++;

        ans = 0; 
        sol(hash); 
        return ans;
    }

    private void sol(int[] hash) {
        for (int i = 0; i < 26; i++) {
            if (hash[i] == 0) continue;

            ans++; 

            hash[i]--; 
            sol(hash); 
            hash[i]++; 
        }
    }
}

/*

Example 1:
Input: tiles = "AAB"
Output: 8
Explanation: The possible sequences are "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA".

Example 2:
Input: tiles = "AAABBC"
Output: 188

Example 3:
Input: tiles = "V"
Output: 1

*/
