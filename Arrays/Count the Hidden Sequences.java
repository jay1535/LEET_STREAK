//Solution

class Solution {
public int numberOfArrays(int[] diff, int lower, int upper) {
    long a = 0, maxima = 0, minima = 0;
    for (int i = 0; i < diff.length; i++) {
        a += diff[i];
        maxima = Math.max(maxima, a);
        minima = Math.min(minima, a);
    }
    return (int) Math.max(0, (upper - lower) - (maxima - minima) + 1);
}
}

/*

Example 1:

Input: differences = [1,-3,4], lower = 1, upper = 6
Output: 2
Explanation: The possible hidden sequences are:
- [3, 4, 1, 5]
- [4, 5, 2, 6]
Thus, we return 2.
Example 2:

Input: differences = [3,-4,5,1,-2], lower = -4, upper = 5
Output: 4
Explanation: The possible hidden sequences are:
- [-3, 0, -4, 1, 2, 0]
- [-2, 1, -3, 2, 3, 1]
- [-1, 2, -2, 3, 4, 2]
- [0, 3, -1, 4, 5, 3]
Thus, we return 4.
Example 3:

Input: differences = [4,-7,2], lower = 3, upper = 6
Output: 0
Explanation: There are no possible hidden sequences. Thus, we return 0.

*/
