//Solution

class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        long nums1Zeroes = 0, nums2Zeroes = 0,sum1 = 0, sum2 = 0;
        for(int i : nums1){
            if(i == 0) nums1Zeroes++;
            sum1 += i;
        }

        for(int i : nums2){
            if(i == 0) nums2Zeroes++;
            sum2 += i;
        }

        long min1 = sum1 + nums1Zeroes;
        long min2 = sum2 + nums2Zeroes;

        if(nums1Zeroes == 0 && nums2Zeroes == 0){
            return sum1 == sum2 ? sum1 : -1;
        }else if(nums1Zeroes == 0){
            return sum2 + nums2Zeroes <=sum1 ?sum1 : -1;
        }else if (nums2Zeroes == 0){
            return sum1 + nums1Zeroes <= sum2 ? sum2 : -1;
        }
        return Math.max(min1, min2);
    }
}

/*

Example 1:
Input: nums1 = [3,2,0,1,0], nums2 = [6,5,0]
Output: 12
Explanation: We can replace 0's in the following way:
- Replace the two 0's in nums1 with the values 2 and 4. The resulting array is nums1 = [3,2,2,1,4].
- Replace the 0 in nums2 with the value 1. The resulting array is nums2 = [6,5,1].
Both arrays have an equal sum of 12. It can be shown that it is the minimum sum we can obtain.

Example 2:
Input: nums1 = [2,0,2,0], nums2 = [1,4]
Output: -1
Explanation: It is impossible to make the sum of both arrays equal.

*/
