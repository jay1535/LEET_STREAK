//Solution



class Solution {
    public int minOperations(int[] nums, int k) {
        
        for (int chakra : nums) {
            if (chakra < k) return -1; 
        }

        
        Set<Integer> aboveK = new HashSet<>();
        for (int chakra : nums) {
            if (chakra > k) aboveK.add(chakra);
        }

        
        return aboveK.size();
    }
}


/*

Example 1:
Input: nums = [5,2,5,4,5], k = 2
Output: 2
Explanation:
The operations can be performed in order using valid integers 4 and then 2.

Example 2:
Input: nums = [2,1,2], k = 2
Output: -1
Explanation:
It is impossible to make all the values equal to 2.

Example 3:
Input: nums = [9,7,5,3], k = 1
Output: 4
Explanation:
The operations can be performed using valid integers in the order 7, 5, 3, and 1.

*/
