//Solution
class Solution {
 public long minimumDifference(int[] nums) {
     int n = nums.length, k = n / 3;
     long[] leftMins = new long[n];   
     long[] rightMaxs = new long[n]; 
     long leftSum = 0, rightSum = 0, minDiff = Long.MAX_VALUE;

     PriorityQueue<Integer> maxLeftHeap = new PriorityQueue<>((a, b) -> b - a); 
     PriorityQueue<Integer> minRightHeap = new PriorityQueue<>();           

     for (int i = 0; i < k; i++) {
         maxLeftHeap.offer(nums[i]);
         leftSum += nums[i];
     }
     leftMins[k - 1] = leftSum;

     for (int i = k; i < n - k; i++) {
         int x = nums[i];
         if (x < maxLeftHeap.peek()) {
             leftSum += x - maxLeftHeap.poll();
             maxLeftHeap.offer(x);
         }
         leftMins[i] = leftSum;
     }

     for (int i = n - 1; i >= n - k; i--) {
         minRightHeap.offer(nums[i]);
         rightSum += nums[i];
     }
     rightMaxs[n - k] = rightSum;

     for (int i = n - k - 1; i >= k - 1; i--) {
         int x = nums[i];
         if (x > minRightHeap.peek()) {
             rightSum += x - minRightHeap.poll();
             minRightHeap.offer(x);
         }
         rightMaxs[i] = rightSum;
     }

     for (int i = k - 1; i < n - k; i++) {
         minDiff = Math.min(minDiff, leftMins[i] - rightMaxs[i + 1]);
     }

     return minDiff;
 }
}

/*

Example 1:
Input: nums = [3,1,2]
Output: -1
Explanation: Here, nums has 3 elements, so n = 1. 
Thus we have to remove 1 element from nums and divide the array into two equal parts.
- If we remove nums[0] = 3, the array will be [1,2]. The difference in sums of the two parts will be 1 - 2 = -1.
- If we remove nums[1] = 1, the array will be [3,2]. The difference in sums of the two parts will be 3 - 2 = 1.
- If we remove nums[2] = 2, the array will be [3,1]. The difference in sums of the two parts will be 3 - 1 = 2.
The minimum difference between sums of the two parts is min(-1,1,2) = -1. 

Example 2:
Input: nums = [7,9,5,8,1,3]
Output: 1
Explanation: Here n = 2. So we must remove 2 elements and divide the remaining array into two parts containing two elements each.
If we remove nums[2] = 5 and nums[3] = 8, the resultant array will be [7,9,1,3]. The difference in sums will be (7+9) - (1+3) = 12.
To obtain the minimum difference, we should remove nums[1] = 9 and nums[4] = 1. The resultant array becomes [7,5,8,3]. The difference in sums of the two parts is (7+5) - (8+3) = 1.
It can be shown that it is not possible to obtain a difference smaller than 1.

*/
