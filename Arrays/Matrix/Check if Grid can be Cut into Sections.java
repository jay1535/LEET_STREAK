//Solution

class Solution {
    public boolean checkValidCuts(int n, int[][] rectangles) {
        int[][] xIntervals = new int[rectangles.length][2];
        int[][] yIntervals = new int[rectangles.length][2];

        for (int i = 0; i < rectangles.length; i++) {
            xIntervals[i][0] = rectangles[i][0];
            xIntervals[i][1] = rectangles[i][2];
            yIntervals[i][0] = rectangles[i][1];
            yIntervals[i][1] = rectangles[i][3];
        }

        return check(xIntervals) || check(yIntervals);
    }

    private boolean check(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        int sections = 0;
        int maxEnd = intervals[0][1];

        for (int[] interval : intervals) {
            if (maxEnd <= interval[0]) {
                sections++;
            }
            maxEnd = Math.max(maxEnd, interval[1]);
        }

        return sections >= 2;
    }
}

/*

Example 1:
Input: n = 5, rectangles = [[1,0,5,2],[0,2,2,4],[3,2,5,3],[0,4,4,5]]
Output: true
Explanation:
The grid is shown in the diagram. We can make horizontal cuts at y = 2 and y = 4. Hence, output is true.

Example 2:
Input: n = 4, rectangles = [[0,0,1,1],[2,0,3,4],[0,2,2,3],[3,0,4,3]]
Output: true
Explanation:
We can make vertical cuts at x = 2 and x = 3. Hence, output is true.

Example 3:
Input: n = 4, rectangles = [[0,2,2,4],[1,0,3,2],[2,2,3,4],[3,0,4,2],[3,2,4,4]]
Output: false
Explanation:
We cannot make two horizontal or two vertical cuts that satisfy the conditions. Hence, output is false.

*/
