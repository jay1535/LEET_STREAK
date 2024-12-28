//Solution

class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] windowSums = new int[n - k + 1];
        int[] left = new int[n - k + 1];
        int[] right = new int[n - k + 1];
        int[] result = new int[3];

        // Step 1: Compute sliding window sums
        int windowSum = 0;
        for (int i = 0; i < nums.length; i++) {
            windowSum += nums[i];
            if (i >= k) {
                windowSum -= nums[i - k];
            }
            if (i >= k - 1) {
                windowSums[i - k + 1] = windowSum;
            }
        }

        // Step 2: Populate left array
        int maxIndex = 0;
        for (int i = 0; i < windowSums.length; i++) {
            if (windowSums[i] > windowSums[maxIndex]) {
                maxIndex = i;
            }
            left[i] = maxIndex;
        }

        // Step 3: Populate right array
        maxIndex = windowSums.length - 1;
        for (int i = windowSums.length - 1; i >= 0; i--) {
            if (windowSums[i] >= windowSums[maxIndex]) {
                maxIndex = i;
            }
            right[i] = maxIndex;
        }

        // Step 4: Iterate over middle subarrays
        int maxSum = 0;
        for (int mid = k; mid < windowSums.length - k; mid++) {
            int leftIndex = left[mid - k];
            int rightIndex = right[mid + k];
            int totalSum = windowSums[leftIndex] + windowSums[mid] +  windowSums[rightIndex];
            if (totalSum > maxSum) {
                maxSum = totalSum;
                result[0] = leftIndex;
                result[1] = mid;
                result[2] = rightIndex;
            }
        }

        return result;
    }
}

/*

Example 1:
Input: nums = [1,2,1,2,6,7,5,1], k = 2
Output: [0,3,5]
Explanation: Subarrays [1, 2], [2, 6], [7, 5] correspond to the starting indices [0, 3, 5].
We could have also taken [2, 1], but an answer of [1, 3, 5] would be lexicographically larger.

Example 2:
Input: nums = [1,2,1,2,1,2,1,2,1], k = 2
Output: [0,2,4]
 
*/
