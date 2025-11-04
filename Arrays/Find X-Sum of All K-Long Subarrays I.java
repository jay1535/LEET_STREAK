//Solution

class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] result = new int[n - k + 1];

        for (int i = 0; i < result.length; i++) {
            result[i] = calculateXSumForSubarray(nums, i, i + k - 1, x);
        }

        return result;
    }

    private int calculateXSumForSubarray(int[] nums, int start, int end, int x) {
        final int MAX_VALUE = 50;
        int[] frequency = new int[MAX_VALUE + 1];
        int distinctCount = 0;

        int totalSum = 0;
        for (int i = start; i <= end; i++) {
            int num = nums[i];
            totalSum += num;
            if (frequency[num] == 0) {
                distinctCount++;
            }
            frequency[num]++;
        }

        if (distinctCount < x) {
            return totalSum;
        }

        int resultSum = 0;
        for (int selection = 0; selection < x; selection++) {
            int bestNumber = -1;
            int bestFrequency = -1;

            for (int number = MAX_VALUE; number >= 1; number--) {
                if (frequency[number] > bestFrequency) {
                    bestFrequency = frequency[number];
                    bestNumber = number;
                }
            }

            if (bestNumber != -1) {
                resultSum += bestNumber * bestFrequency;
                frequency[bestNumber] = 0; 
            }
        }
        
        return resultSum;
    }
}


/*
Example 1:

Input: nums = [1,1,2,2,3,4,2,3], k = 6, x = 2

Output: [6,10,12]

Explanation:

For subarray [1, 1, 2, 2, 3, 4], only elements 1 and 2 will be kept in the resulting array. Hence, answer[0] = 1 + 1 + 2 + 2.
For subarray [1, 2, 2, 3, 4, 2], only elements 2 and 4 will be kept in the resulting array. Hence, answer[1] = 2 + 2 + 2 + 4. Note that 4 is kept in the array since it is bigger than 3 and 1 which occur the same number of times.
For subarray [2, 2, 3, 4, 2, 3], only elements 2 and 3 are kept in the resulting array. Hence, answer[2] = 2 + 2 + 2 + 3 + 3.
Example 2:

Input: nums = [3,8,7,8,7,5], k = 2, x = 2

Output: [11,15,15,15,12]

Explanation:

Since k == x, answer[i] is equal to the sum of the subarray nums[i..i + k - 1].
*/
