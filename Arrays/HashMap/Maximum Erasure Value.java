//Solution

class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        Set<Integer> map = new HashSet<>();
        int left =0;
        int curr = 0;
        int max = 0;

        for (int right = 0; right < nums.length; right++){
            while(map.contains(nums[right])){
                curr-=nums[left];
                map.remove(nums[left]);
                left++;
            }
            map.add(nums[right]);
            curr+= nums[right];
            max = Math.max(max, curr);
        }
        return max;
    }
}

/*

Example 1:
Input: nums = [4,2,4,5,6]
Output: 17
Explanation: The optimal subarray here is [2,4,5,6].

Example 2:
Input: nums = [5,2,1,2,5,2,1,2,5]
Output: 8
Explanation: The optimal subarray here is [5,2,1] or [1,2,5].

*/
