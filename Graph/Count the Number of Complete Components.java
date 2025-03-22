//Solution

class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int []edge : edges){
            int a = edge[0];
            int b= edge[1];
            adj.get(a).add(b);
            adj.get(b).add(a); 
        }
        int []vis= new int[n];
        int count=0;
        for(int i=0;i<n;i++){
            if(vis[i]==0){
                List<Integer> ls = new ArrayList<>();
                int edgecount = dfs(i,vis,adj,ls);
                int nodecount = ls.size();
                if(nodecount*(nodecount-1) ==  edgecount)count++;
            }
        }
        return count;
    }
    public int  dfs(int node,int []vis,ArrayList<ArrayList<Integer>> adj,List<Integer> ls){
        vis[node]=1;
        ls.add(node);
        int ct=0;
        for(int i :adj.get(node)){
            if(vis[i]==0){
                ct+=dfs(i,vis,adj,ls);
            }
            ct++;
        }
        return ct;
    }
}

/*

Example 1:
Input: n = 6, edges = [[0,1],[0,2],[1,2],[3,4]]
Output: 3
Explanation: From the picture above, one can see that all of the components of this graph are complete.

Example 2:
Input: n = 6, edges = [[0,1],[0,2],[1,2],[3,4],[3,5]]
Output: 1
Explanation: The component containing vertices 0, 1, and 2 is complete since there is an edge between every pair of two vertices. On the other hand, the component containing vertices 3, 4, and 5 is not complete 
since there is no edge between vertices 4 and 5. Thus, the number of complete components in this graph is 1.

*/
