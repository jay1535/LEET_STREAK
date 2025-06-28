//Solution



class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
       
        int[][] valueWithIndex = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            valueWithIndex[i] = new int[]{nums[i], i}; 
        }
        
        
        Arrays.sort(valueWithIndex, (a, b) -> b[0] - a[0]);
        
        Arrays.sort(valueWithIndex, 0, k, (a, b) -> a[1] - b[1]);
       
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = valueWithIndex[i][0]; 
        }
        
        return result;
    }
}

/*
Example 1:

Input: nums = [2,1,3,3], k = 2
Output: [3,3]
Explanation:
The subsequence has the largest sum of 3 + 3 = 6.
Example 2:

Input: nums = [-1,-2,3,4], k = 3
Output: [-1,3,4]
Explanation: 
The subsequence has the largest sum of -1 + 3 + 4 = 6.
Example 3:

Input: nums = [3,4,3,3], k = 2
Output: [3,4]
Explanation:
The subsequence has the largest sum of 3 + 4 = 7. 
Another possible subsequence is [4, 3].
*/
