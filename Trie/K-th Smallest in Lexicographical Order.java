//Solution

class Solution {
    public int findKthNumber(int n, int k) {
        int currentPrefix = 1;
        k--;  
        
        while (k > 0) {
            int count = countNumbersWithPrefix(currentPrefix, n);
            if (k >= count) {
                currentPrefix++;  
                k -= count;
            } else {
                currentPrefix *= 10; 
                k--;
            }
        }
        
        return currentPrefix;
    }

    private int countNumbersWithPrefix(int prefix, int n) {
        long firstNumber = prefix, nextNumber = prefix + 1;
        int totalCount = 0;

        while (firstNumber <= n) {
            totalCount += Math.min(n + 1, nextNumber) - firstNumber;
            firstNumber *= 10;
            nextNumber *= 10;
        }

        return totalCount;
    }
}

/*

Example 1:
Input: n = 13, k = 2
Output: 10
Explanation: The lexicographical order is [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9], so the second smallest number is 10.

Example 2:
Input: n = 1, k = 1
Output: 1

*/
