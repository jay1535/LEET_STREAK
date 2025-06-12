//Solution

class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int n = nums.length;
        int md = 0;
        for(int i =0; i< n; ++i){
            int des = Math.abs(nums[i] - nums[(i+1)%n]);
            md = Math.max(md, des);
        }
        return md;
    }
}

/*

Example 1:

Input: nums = [1,2,4]

Output: 3

Explanation:

Because nums is circular, nums[0] and nums[2] are adjacent. They have the maximum absolute difference of |4 - 1| = 3.

Example 2:

Input: nums = [-5,-10,-5]

Output: 5

Explanation:

The adjacent elements nums[0] and nums[1] have the maximum absolute difference of |-5 - (-10)| = 5.

*/
