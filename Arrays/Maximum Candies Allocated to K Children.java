//Solution

class Solution {
    public int maximumCandies(int[] candies, long k) {
        int left = 1, right = 10_000_000;
        int result = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            long childrenCount = 0;

            for (int candy : candies) {
                childrenCount += candy / mid;
            }

            if (childrenCount >= k) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }
}

/*

Example 1:
Input: candies = [5,8,6], k = 3
Output: 5
Explanation: We can divide candies[1] into 2 piles of size 5 and 3, and candies[2] 
into 2 piles of size 5 and 1. We now have five piles of candies of sizes 5, 5, 3, 5, and 1.
We can allocate the 3 piles of size 5 to 3 children. It can be proven that each child cannot receive more than 5 candies.

Example 2:
Input: candies = [2,5], k = 11
Output: 0
Explanation: There are 11 children but only 7 candies in total, so it is impossible to ensure each
child receives at least one candy. Thus, each child gets no candy and the answer is 0.

*/
