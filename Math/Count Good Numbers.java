//Solution

class Solution {
    int M = 1_000_000_007;

    public int countGoodNumbers(long n) {
        long even = (n + 1) / 2;

        long odd = n / 2;

        long result = (pow(5, even) * pow(4, odd)) % M;

        return (int) result;
    }
 private long pow(long a, long b) {
        
        if (b == 0) return 1;

        if (b % 2 == 0) {
          
            return pow((a * a) % M, b / 2) % M;
        } else {
            
            return (a * pow(a, b - 1)) % M;
        }
    }
}

/*

Example 1:
Input: n = 1
Output: 5
Explanation: The good numbers of length 1 are "0", "2", "4", "6", "8".

Example 2:
Input: n = 4
Output: 400

Example 3:
Input: n = 50
Output: 564908303

*/
