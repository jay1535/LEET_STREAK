// Solution


class Solution {
    public long findScore(int[] nums) {
        long score = 0;
        int n = nums.length;
        Deque<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (!q.isEmpty() && nums[i] >= q.peekLast()) {
                boolean skip = false;
                while (!q.isEmpty()) {
                    int add = q.pollLast();
                    if (!skip) {
                        score += add;
                    }
                    skip = !skip;
                }
                continue;
            }

            q.addLast(nums[i]);
        }
      
        boolean skip = false;
        while (!q.isEmpty()) {
            int add = q.pollLast();
            if (!skip) {
                score += add;
            }
            skip = !skip;
        }

        return score;
    }
}


/*

Example 1:
Input: nums = [2,1,3,4,5,2]
Output: 7
Explanation: We mark the elements as follows:
- 1 is the smallest unmarked element, so we mark it and its two adjacent elements: [2,1,3,4,5,2].
- 2 is the smallest unmarked element, so we mark it and its left adjacent element: [2,1,3,4,5,2].
- 4 is the only remaining unmarked element, so we mark it: [2,1,3,4,5,2].
Our score is 1 + 2 + 4 = 7.

Example 2:
Input: nums = [2,3,5,1,3,2]
Output: 5
Explanation: We mark the elements as follows:
- 1 is the smallest unmarked element, so we mark it and its two adjacent elements: [2,3,5,1,3,2].
- 2 is the smallest unmarked element, since there are two of them, we choose the left-most one, so we mark the one at index 0 and its right adjacent element: [2,3,5,1,3,2].
- 2 is the only remaining unmarked element, so we mark it: [2,3,5,1,3,2].
Our score is 1 + 2 + 2 = 5.
 

*/
