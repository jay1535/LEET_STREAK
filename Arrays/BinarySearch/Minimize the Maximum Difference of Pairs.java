//Solution

class Solution {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        return binarySearch(nums, p);
    }

    private boolean canFormPairs(int[] nums, int d, int p) {
        int c = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] - nums[i] <= d) {
                c++;
                i++;
            }
            if (c >= p) return true;
        }
        return false;
    }

    private int binarySearch(int[] nums, int p) {
        int L = 0, H = nums[nums.length - 1] - nums[0];
        while (L < H) {
            int M = L + ((H - L) >> 1);
            if (canFormPairs(nums, M, p)) {
                H = M;
            } else {
                L = M + 1;
            }
        }
        return L;
    }   
}

/*

Example 1:
Input: nums = [10,1,2,7,1,3], p = 2
Output: 1
Explanation: The first pair is formed from the indices 1 and 4, and the second pair is formed from the indices 2 and 5. 
The maximum difference is max(|nums[1] - nums[4]|, |nums[2] - nums[5]|) = max(0, 1) = 1. Therefore, we return 1.

Example 2:
Input: nums = [4,2,1,2], p = 1
Output: 0
Explanation: Let the indices 1 and 3 form a pair. The difference of that pair is |2 - 2| = 0, which is the minimum we can attain.

*/
