// Solution

class Solution {
    public int minimumTime(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[2]-b[2]);  
        boolean[][] visited=new boolean[m][n];
        

        if (grid[0][1] > 1 && grid[1][0] > 1){           
            return -1;
        }

        int[][] moves={ {0,-1},{0,1},{-1,0},{1,0}};

        pq.add(new int[]{0,0,0});
        while(!pq.isEmpty()){
            int[] arr=pq.poll();
            int row=arr[0];
            int col=arr[1];
            int time=arr[2];
            
            if(row==m-1 && col==n-1){
                return time;
            } 

            if(visited[row][col]) continue;
            visited[row][col]=true;


            for(int[] move:moves){
                int nrow=row+move[0];
                int ncol=col+move[1];

                if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && !visited[nrow][ncol]){
                    int newtime=0; 
                    int diff=grid[nrow][ncol]-time;                    
                    if(diff<=1) newtime=time+1;                
                    else newtime=time+1+(diff/2)*2;

                    pq.add(new int[]{nrow,ncol,newtime});
                    
                }
            }
        }
        return -1;
    }
}


/*

Example 1:
Input: grid = [[0,1,3,2],[5,1,2,5],[4,3,8,6]]
Output: 7
Explanation: One of the paths that we can take is the following:
- at t = 0, we are on the cell (0,0).
- at t = 1, we move to the cell (0,1). It is possible because grid[0][1] <= 1.
- at t = 2, we move to the cell (1,1). It is possible because grid[1][1] <= 2.
- at t = 3, we move to the cell (1,2). It is possible because grid[1][2] <= 3.
- at t = 4, we move to the cell (1,1). It is possible because grid[1][1] <= 4.
- at t = 5, we move to the cell (1,2). It is possible because grid[1][2] <= 5.
- at t = 6, we move to the cell (1,3). It is possible because grid[1][3] <= 6.
- at t = 7, we move to the cell (2,3). It is possible because grid[2][3] <= 7.
The final time is 7. It can be shown that it is the minimum time possible.



Example 2:
Input: grid = [[0,2,4],[3,2,1],[1,0,4]]
Output: -1
Explanation: There is no path from the top left to the bottom-right cell.
 

*/
