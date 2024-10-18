// Solution

class Solution {
    public void backtrack(int[] nums, int index, int currentOR, int maxOR, int[] count) {
        if (currentOR == maxOR) {
            count[0]++;
        }
        for (int i = index; i < nums.length; i++) {
            backtrack(nums, i + 1, currentOR | nums[i], maxOR, count);
        }
    }
    public int countMaxOrSubsets(int[] nums) {
        int maxOR = 0;   
        for (int num : nums) {
            maxOR |= num;
        }
        int[] count = new int[1];  
        backtrack(nums, 0, 0, maxOR, count);
        return count[0];
    }
}



/* 


Example 1:
Input: nums = [3,1]
Output: 2
Explanation: The maximum possible bitwise OR of a subset is 3. There are 2 subsets with a bitwise OR of 3:
- [3]
- [3,1]


Example 2:
Input: nums = [2,2,2]
Output: 7
Explanation: All non-empty subsets of [2,2,2] have a bitwise OR of 2. There are 23 - 1 = 7 total subsets.


*/
