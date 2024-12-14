// Solution

class Solution {
    public long continuousSubarrays(int[] nums) {
        int l = 0;
        long res = 0;
        Deque<Integer> minD = new LinkedList<>(), maxD = new LinkedList<>();

        for (int r = 0; r < nums.length; r++) {
      
            while (!minD.isEmpty() && nums[minD.peekLast()] >= nums[r]) {
                minD.pollLast();
            }
  
            while (!maxD.isEmpty() && nums[maxD.peekLast()] <= nums[r]) {
                maxD.pollLast();
            }
            minD.offerLast(r);
            maxD.offerLast(r);
            while (nums[maxD.peekFirst()] - nums[minD.peekFirst()] > 2) {
                l++;
                if (minD.peekFirst() < l) minD.pollFirst();
                if (maxD.peekFirst() < l) maxD.pollFirst();
            }
            res += r - l + 1;
        }

        return res;
    }
}

/*

Example 1:
Input: nums = [5,4,2,4]
Output: 8
Explanation: 
Continuous subarray of size 1: [5], [4], [2], [4].
Continuous subarray of size 2: [5,4], [4,2], [2,4].
Continuous subarray of size 3: [4,2,4].
Thereare no subarrys of size 4.
Total continuous subarrays = 4 + 3 + 1 = 8.
It can be shown that there are no more continuous subarrays.
 

Example 2:
Input: nums = [1,2,3]
Output: 6
Explanation: 
Continuous subarray of size 1: [1], [2], [3].
Continuous subarray of size 2: [1,2], [2,3].
Continuous subarray of size 3: [1,2,3].
Total continuous subarrays = 3 + 2 + 1 = 6.

*/
