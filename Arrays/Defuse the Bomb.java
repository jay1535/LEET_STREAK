// Solution

class Solution {
    public int[] decrypt(int[] code, int k) {
    int n = code.length;     
    int ans[] = new int[n];
    int start = 0, end =0; 
    if(k==0)
    return ans; 

    if(k>0)
    {
        start = 1;
        end = k ; 
    }
    else
    {
        start = n-Math.abs(k);
        end = n-1;
    }
    int sum = 0; 
    for(int i=start; i<=end; i++)
    sum += code[i];

    for(int i=0; i<n; i++)
    {
       ans[i] = sum ; 
       sum = sum - code[(start)%n];
       sum = sum + code[(end+1)%n]; 
       start++; 
       end++;  
    }
     return ans;   
    }
}

/*

Example 1:
Input: code = [5,7,1,4], k = 3
Output: [12,10,16,13]
Explanation: Each number is replaced by the sum of the next 3 numbers. The decrypted code is [7+1+4, 1+4+5, 4+5+7, 5+7+1]. Notice that the numbers wrap around.

Example 2:
Input: code = [1,2,3,4], k = 0
Output: [0,0,0,0]
Explanation: When k is zero, the numbers are replaced by 0. 

Example 3:
Input: code = [2,4,9,3], k = -2
Output: [12,5,6,13]
Explanation: The decrypted code is [3+9, 2+3, 4+2, 9+4]. Notice that the numbers wrap around again. If k is negative, the sum is of the previous numbers.
 

*/
