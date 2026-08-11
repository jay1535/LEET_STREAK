class Solution {
    int total;

    public int maxSubarraySumCircular(int[] nums) {
        int max = kadanes(nums, true);
        int min = kadanes(nums, false);
                
        // If the maximum is greater than 0, return the maximum of max or total - min
        return max > 0 ? Math.max(max, total - min) : max;
    }

    private int kadanes(int[] nums, boolean isMax) {
        total = 0; 

        int current = 0; 
        int sum = nums[0]; 

        for (int num : nums) {
            total += num;

            if (isMax) {
                // Calculate maximum subarray sum
                current = Math.max(current + num, num);
                sum = Math.max(sum, current);
            } else {
                // Calculate minimum subarray sum
                current = Math.min(current + num, num);
                sum = Math.min(sum, current);
            }
        }
        return sum; 
    }
}


// class Solution {
//     public int maxSubarraySumCircular(int[] nums) {
//         final int n = nums.length;
//         final int[] rightMax = new int[n];
//         rightMax[n - 1] = nums[n - 1];
//         int suffixSum = nums[n - 1];

//         for (int i = n - 2; i >= 0; --i) {
//             suffixSum += nums[i];
//             rightMax[i] = Math.max(rightMax[i + 1], suffixSum);
//         }

//         int maxSum = nums[0];
//         int specialSum = nums[0];
//         int curMax = 0;
//         for (int i = 0, prefixSum = 0; i < n; ++i) {
//             // This is Kadane's algorithm.
//             curMax = Math.max(curMax, 0) + nums[i];
//             maxSum = Math.max(maxSum, curMax);

//             prefixSum += nums[i];
//             if (i + 1 < n) {
//                 specialSum = Math.max(specialSum, prefixSum + rightMax[i + 1]);
//             }
//         }

//         return Math.max(maxSum, specialSum);  
//     }
// }