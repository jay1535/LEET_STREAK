//Solution

class Solution {
    int count=0;
    public void bfs(int[][] grid, int val, int x,int y, PriorityQueue<int[]> pq){
        if(x<0 || y<0 || x==grid.length || y==grid[0].length){
            return;
        }
        if(grid[x][y]>0){
            if(grid[x][y]<val){
                count++;
                grid[x][y]=-1; // visited
                bfs(grid,val,x+1,y,pq);
                bfs(grid,val,x-1,y,pq);
                bfs(grid,val,x,y+1,pq);
                bfs(grid,val,x,y-1,pq);
            }else{
                pq.add(new int[]{x,y, grid[x][y]});
                grid[x][y]=0;
            }
        }
        while(!pq.isEmpty()){
            int[] top = pq.peek();
            if(top[2]<val){
                pq.remove();
                grid[top[0]][top[1]]=top[2];
                bfs(grid,val,top[0],top[1],pq);
            }else{
                break;
            }
        }
    }
    public int[] maxPoints(int[][] grid, int[] queries) {
        int[] ans = new int[queries.length];
        List<int[]> queryIndex = new ArrayList<>();
        for(int i=0;i<queries.length;i++){
            queryIndex.add(new int[]{i,queries[i]});
        }
        Collections.sort(queryIndex,(a,b)->a[1]-b[1]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[2]-b[2]);
        for(int[] q:queryIndex){
            bfs(grid,q[1],0,0,pq);
            ans[q[0]]=count;
        }
        return ans;
    }
}

/*

Example 1:
Input: grid = [[1,2,3],[2,5,7],[3,5,1]], queries = [5,6,2]
Output: [5,8,1]
Explanation: The diagrams above show which cells we visit to get points for each query.

Example 2:
Input: grid = [[5,2,1],[1,1,2]], queries = [3]
Output: [0]
Explanation: We can not get any points because the value of the top left cell is already greater than or equal to 3.

*/
