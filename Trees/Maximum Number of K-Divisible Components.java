//Solution

import java.util.*;

class Solution {
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }

        int[] componentCount = new int[1]; 
        boolean[] visited = new boolean[n];

        dfs(0, tree, values, k, visited, componentCount);

        return componentCount[0];
    }

    private int dfs(int node, List<List<Integer>> tree, int[] values, int k, boolean[] visited, int[] componentCount) {
        visited[node] = true;

        int subtreeMod = values[node] % k;

        for (int neighbor : tree.get(node)) {
            if (!visited[neighbor]) {
                subtreeMod += dfs(neighbor, tree, values, k, visited, componentCount);
                subtreeMod %= k; 
            }
        }

        if (subtreeMod == 0) {
            componentCount[0]++;
            return 0;
        }

        return subtreeMod;
    }
}

/*

Example 1:
Input: n = 5, edges = [[0,2],[1,2],[1,3],[2,4]], values = [1,8,1,4,4], k = 6
Output: 2
Explanation: We remove the edge connecting node 1 with 2. The resulting split is valid because:
- The value of the component containing nodes 1 and 3 is values[1] + values[3] = 12.
- The value of the component containing nodes 0, 2, and 4 is values[0] + values[2] + values[4] = 6.
It can be shown that no other valid split has more than 2 connected components.

Example 2:
Input: n = 7, edges = [[0,1],[0,2],[1,3],[1,4],[2,5],[2,6]], values = [3,0,6,1,5,2,1], k = 3
Output: 3
Explanation: We remove the edge connecting node 0 with 2, and the edge connecting node 0 with 1. The resulting split is valid because:
- The value of the component containing node 0 is values[0] = 3.
- The value of the component containing nodes 2, 5, and 6 is values[2] + values[5] + values[6] = 9.
- The value of the component containing nodes 1, 3, and 4 is values[1] + values[3] + values[4] = 6.
It can be shown that no other valid split has more than 3 connected components.
 
*/
