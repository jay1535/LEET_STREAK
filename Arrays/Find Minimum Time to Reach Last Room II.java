//Solution

import java.util.PriorityQueue;
import java.util.Arrays;
class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length;
        int m = moveTime[0].length;

        int [][][]  d = new int[n][m][2];
        
             for(int[][] row : d){
                 for( int[] col : row){
                      Arrays.fill(col, Integer.MAX_VALUE);
                 }
             }
        d[0][0][0] = 0;
        PriorityQueue<int[]> pq  = new PriorityQueue<> ((a,b)-> Integer.compare(a[0],b[0]));
        pq.offer(new int[] {0,0,0,0});
        int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};

        while (!pq.isEmpty()){
            int[] current = pq.poll();
            int t = current[0];
            int i = current[1];
            int j = current[2];
            int p = current[3];
            if( t> d[i][j][p]) continue;
            for(int[] dir : directions){
                int ni = i + dir[0];
                int nj = j + dir[1];

                 if(ni >= 0 && ni < n && nj >= 0 && nj < m){
                      int nt = Math.max(t, moveTime[ni][nj])+ (p==0 ? 1: 2);
                     if( nt < d[ni][nj][1-p]){
                         d[ni][nj][1-p] = nt;
                         pq.offer(new int[] { nt, ni, nj, 1-p});
                     }
                 }
            }
            
        }
        return Math.min(d[n-1][m-1][0], d[n-1][m-1][1]);
        
    }
}

/*

Example 1:
Input: moveTime = [[0,4],[4,4]]
Output: 7
Explanation:
The minimum time required is 7 seconds.
At time t == 4, move from room (0, 0) to room (1, 0) in one second.
At time t == 5, move from room (1, 0) to room (1, 1) in two seconds.

Example 2:
Input: moveTime = [[0,0,0,0],[0,0,0,0]]
Output: 6
Explanation:
The minimum time required is 6 seconds.
At time t == 0, move from room (0, 0) to room (1, 0) in one second.
At time t == 1, move from room (1, 0) to room (1, 1) in two seconds.
At time t == 3, move from room (1, 1) to room (1, 2) in one second.
At time t == 4, move from room (1, 2) to room (1, 3) in two seconds.

Example 3:
Input: moveTime = [[0,1],[1,2]]
Output: 4

*/
