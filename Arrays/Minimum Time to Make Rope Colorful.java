//Solution

class Solution {
    public int minCost(String colors, int[] needed_time) {
        int n_time = 0;
        int n = colors.length();
        int curr_max = 0;
        
        for (int i = 0; i < n; i++) {
            if (i == 0 || colors.charAt(i) != colors.charAt(i - 1)) {
                curr_max = needed_time[i];
            } else {
                if (needed_time[i] > curr_max) {
                    n_time += curr_max; 
                    curr_max = needed_time[i]; 
                } else {
                    n_time += needed_time[i]; 
                }
            }
        }
        
        return n_time;
    }
}


/*
Example 1:


Input: colors = "abaac", neededTime = [1,2,3,4,5]
Output: 3
Explanation: In the above image, 'a' is blue, 'b' is red, and 'c' is green.
Bob can remove the blue balloon at index 2. This takes 3 seconds.
There are no longer two consecutive balloons of the same color. Total time = 3.
Example 2:


Input: colors = "abc", neededTime = [1,2,3]
Output: 0
Explanation: The rope is already colorful. Bob does not need to remove any balloons from the rope.
Example 3:


Input: colors = "aabaa", neededTime = [1,2,3,4,1]
Output: 2
Explanation: Bob will remove the balloons at indices 0 and 4. Each balloons takes 1 second to remove.
There are no longer two consecutive balloons of the same color. Total time = 1 + 1 = 2.

*/
