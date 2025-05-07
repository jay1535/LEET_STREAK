//Solution


import java.util.PriorityQueue;
import java.util.Arrays;
class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length;
        int m = moveTime[0].length;

        int[][]  dist = new int[n][m];
             for(int i =0;i < n;i++){
              
                      Arrays.fill(dist[i], Integer.MAX_VALUE);
                 
             }
        PriorityQueue<int[]> pq  = new PriorityQueue<> ((a,b)-> a[0]-b[0]);
        pq.offer(new int[] {0,0,0});
          dist[0][0] = 0;
        int[][] directions = {{-1,0},{0,1},{1,0},{0,-1}};

        while (!pq.isEmpty()){
            int[] current = pq.poll();
            int t = current[0];
            int i = current[1];
            int j = current[2];
           
            if( t> dist[i][j]) continue;
            for(int[] dir : directions){
                int ni = i + dir[0];
                int nj = j + dir[1];

                 if(ni >= 0 && ni < n && nj >= 0 && nj < m){
                      int nt = Math.max(t, moveTime[ni][nj])+ 1;
                     if( nt < dist[ni][nj]){
                         dist[ni][nj] = nt;
                         pq.offer(new int[] { nt, ni, nj});
                     }
                 }
            }
            
        }
        return dist[n-1][m-1];
        
    }
}

/*
Example 1:

Input: moveTime = [[0,4],[4,4]]

Output: 6

Explanation:

The minimum time required is 6 seconds.

At time t == 4, move from room (0, 0) to room (1, 0) in one second.
At time t == 5, move from room (1, 0) to room (1, 1) in one second.
Example 2:

Input: moveTime = [[0,0,0],[0,0,0]]

Output: 3

Explanation:

The minimum time required is 3 seconds.

At time t == 0, move from room (0, 0) to room (1, 0) in one second.
At time t == 1, move from room (1, 0) to room (1, 1) in one second.
At time t == 2, move from room (1, 1) to room (1, 2) in one second.
Example 3:

Input: moveTime = [[0,1],[1,2]]

Output: 3

*/
