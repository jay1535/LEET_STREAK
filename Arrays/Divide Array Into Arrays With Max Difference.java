//Solution

class Solution {
    public int[][] divideArray(int[] a, int k) {
        int m = Integer.MIN_VALUE;

        for (int i = 0; i < a.length; i++) {
            m = Math.max(m, a[i]);
        }

        int[] c = new int[m + 1];

        for (int i = 0; i < a.length; i++) {
            c[a[i]]++;
        }

        int[][] r = new int[a.length / 3][3];
        int i = 0, j = 0;

        for (int x = 0; x <= m; x++) {
            while (c[x] > 0) {
                r[i][j++] = x;
                if (j == 3) {
                    if (Math.abs(r[i][0] - r[i][2]) > k) {
                        return new int[0][0];
                    }
                    i++;
                    j = 0;
                }
                c[x]--;
            }
        }
        return r;
    }
}

/*

Example 1:

Input: nums = [1,3,4,8,7,9,3,5,1], k = 2

Output: [[1,1,3],[3,4,5],[7,8,9]]

Explanation:

The difference between any two elements in each array is less than or equal to 2.

Example 2:

Input: nums = [2,4,2,2,5,2], k = 2

Output: []

Explanation:

Different ways to divide nums into 2 arrays of size 3 are:

[[2,2,2],[2,4,5]] (and its permutations)
[[2,2,4],[2,2,5]] (and its permutations)
Because there are four 2s there will be an array with the elements 2 and 5 no matter how we divide it. since 5 - 2 = 3 > k, the condition is not satisfied and so there is no valid division.

Example 3:

Input: nums = [4,2,9,8,2,12,7,12,10,5,8,5,5,7,9,2,5,11], k = 14

Output: [[2,2,12],[4,8,5],[5,9,7],[7,8,5],[5,9,10],[11,12,2]]

Explanation:

The difference between any two elements in each array is less than or equal to 14.

*/
