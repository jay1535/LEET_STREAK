// Solution

class Solution {
    public char findKthBit(int n, int k) {
        
        if (n == 1) return '0';
          
        int length = (1 << n) - 1;
         
        int mid = length / 2 + 1;
     
        if (k == mid) return '1';
        
        if (k < mid) return findKthBit(n - 1, k);       

        return findKthBit(n - 1, length - k + 1) == '0' ? '1' : '0';
    }
}


/* 

Example 1:
Input: n = 3, k = 1
Output: "0"
Explanation: S3 is "0111001".
The 1st bit is "0".

Example 2:
Input: n = 4, k = 11
Output: "1"
Explanation: S4 is "011100110110001".
The 11th bit is "1".
 
*/
