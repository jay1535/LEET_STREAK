//Solution

class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int res = Integer.MAX_VALUE;
        for (int val = 1; val <= 6; val++) {
            int topSwaps = 0, bottomSwaps = 0;
            boolean valid = true;
            for (int i = 0; i < tops.length; i++) {
                if (tops[i] != val && bottoms[i] != val) {
                    valid = false;
                    break;
                }
                if (tops[i] != val) topSwaps++;
                if (bottoms[i] != val) bottomSwaps++;
            }
            if (valid)
                res = Math.min(res, Math.min(topSwaps, bottomSwaps));
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}

/*

Example 1:
Input: tops = [2,1,2,4,2,2], bottoms = [5,2,6,2,3,2]
Output: 2
Explanation: 
The first figure represents the dominoes as given by tops and bottoms: before we do any rotations.
If we rotate the second and fourth dominoes, we can make every value in the top row equal to 2, as indicated by the second figure.

Example 2:
Input: tops = [3,5,1,2,3], bottoms = [3,6,3,3,4]
Output: -1
Explanation: 
In this case, it is not possible to rotate the dominoes to make one row of values equal.

*/
