//Solution

class Solution {
    public int countServers(int[][] grid) {

        int m = grid.length, n = grid[0].length;

        int row[] = new int[m];
        int col[] = new int[n];

        int tot = 0;

        for(int i = 0; i < m; i++) {
            int count = 0;
            for(int j = 0; j < n; j++)   {
                if(grid[i][j] == 1) {

                    row[i]++;
                    col[j]++;
                    tot++;
                }
            }
        }

        int temp = 0;

        for(int i = 0; i < m; i++)  {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1 && row[i] == 1 && col[j] == 1){
                    temp++;
                }
            }
        }
        return tot - temp;
    }
}


/*

Example 1:
Input: grid = [[1,0],[0,1]]
Output: 0
Explanation: No servers can communicate with others.

Example 2:
Input: grid = [[1,0],[1,1]]
Output: 3
Explanation: All three servers can communicate with at least one other server.

Example 3:
Input: grid = [[1,1,0,0],[0,0,1,0],[0,0,1,0],[0,0,0,1]]
Output: 4
Explanation: The two servers in the first row can communicate with each other.
The two servers in the third column can communicate with each other.
The server at right bottom corner can't communicate with any other server.

*/
