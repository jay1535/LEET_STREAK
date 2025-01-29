//Solution
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int nodeCount = 1001;
        int[] parent = new int[nodeCount];
        for(int i = 0; i < nodeCount; i++) parent[i] = i;
        for(int[] edge: edges) {
            int u = edge[0], v = edge[1];
            while(parent[u] != u) u = parent[u];
            while(parent[v] != v) v = parent[v];
            if(u == v) {
                return edge;
            }
            else {
                parent[v] = u;
            }
        }
        return new int[]{-1,-1};
    }
}

/*

Example 1:
Input: edges = [[1,2],[1,3],[2,3]]
Output: [2,3]

Example 2:
Input: edges = [[1,2],[2,3],[3,4],[1,4],[1,5]]
Output: [1,4]
 
*/
