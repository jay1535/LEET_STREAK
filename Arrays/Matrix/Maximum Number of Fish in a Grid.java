//SOlution

class Solution {
    int[][] directions={ {0,1},{0,-1}, {1,0},{-1,0} };
    boolean[][] visited;
    
    public int findMaxFish(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int maxFish=0;       

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==0) continue;
                
                visited=new boolean[m][n];
                               
                maxFish=Math.max(maxFish, dfs(grid, i, j, m, n));
            }
        }

        return maxFish;
    }

    int dfs(int[][] grid, int i, int j, int m, int n){
        visited[i][j]=true;
        int fish=0;
        
        if(grid[i][j]==0) return fish;

        fish+=grid[i][j];
        for(int[] dir:directions){
            int nr=i+dir[0];
            int nc=j+dir[1];
            if(nr>=0 && nr<m && nc>=0 && nc<n){
                if(!visited[nr][nc]){                           
                    fish+=dfs(grid, nr, nc, m, n);
                }
            }
        } 

        return fish;
    }

}

/*

Example 1:
Input: grid = [[0,2,1,0],[4,0,0,3],[1,0,0,4],[0,3,2,0]]
Output: 7
Explanation: The fisher can start at cell (1,3) and collect 3 fish, then move to cell (2,3) and collect 4 fish.

Example 2:
Input: grid = [[1,0,0,0],[0,0,0,0],[0,0,0,0],[0,0,0,1]]
Output: 1
Explanation: The fisher can start at cells (0,0) or (3,3) and collect a single fish. 
 
*/
