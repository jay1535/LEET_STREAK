//Solution

class Solution {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        int len = nums.length;
        for (int i = 0; i<len; i++){
            freq.put(nums[i],  freq.getOrDefault(nums[i],0)+1);
        }
        int maxLen = 0;
        for(int num:freq.keySet()){
            if(freq.containsKey(num+1)){
                int curLen = freq.get(num)+freq.get(num+1);
                maxLen = Math.max(maxLen, curLen);
            }
        }
        return maxLen;
    }
}

/*

Example 1:
Input: nums = [1,3,2,2,5,2,3,7]
Output: 5
Explanation:
The longest harmonious subsequence is [3,2,2,2,3].

Example 2:
Input: nums = [1,2,3,4]
Output: 2
Explanation:
The longest harmonious subsequences are [1,2], [2,3], and [3,4], all of which have a length of 2.

Example 3:
Input: nums = [1,1,1,1]
Output: 0
Explanation:
No harmonic subsequence exists.

*/
