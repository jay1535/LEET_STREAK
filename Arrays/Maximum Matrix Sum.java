// Solution


class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int min = Integer.MAX_VALUE;
        long sum = 0;
        int negCount = 0;
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] < 0)
                    negCount++;
                int ab = Math.abs(matrix[i][j]);
                min = Math.min(min, ab);
                sum += ab;
            }
        if (negCount % 2 == 0)
            return sum;
        return sum - 2 * min;
    }
}

/*

Example 1:
Input: matrix = [[1,-1],[-1,1]]
Output: 4
Explanation: We can follow the following steps to reach sum equals 4:
- Multiply the 2 elements in the first row by -1.
- Multiply the 2 elements in the first column by -1.


Example 2:
Input: matrix = [[1,2,3],[-1,-2,-3],[1,2,3]]
Output: 16
Explanation: We can follow the following step to reach sum equals 16:
- Multiply the 2 last elements in the second row by -1.

*/
