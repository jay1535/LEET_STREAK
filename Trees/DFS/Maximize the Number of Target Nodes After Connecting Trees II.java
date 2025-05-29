//Solution

class Solution {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
        int n1 = edges1.length + 1;
        int n2 = edges2.length + 1;

        ArrayList<Integer>[] adj1 = getAdjacency(edges1);
        ArrayList<Integer>[] adj2 = getAdjacency(edges2);

        int[] depth1 = new int[n1];
        int[] depth2 = new int[n2];

        // Fill depths using DFS
        fillDepths(0, -1, 0, adj1, depth1);
        fillDepths(0, -1, 0, adj2, depth2);

        // Count how many nodes in each tree are at even and odd depths
        int[] count1 = new int[2]; // [even, odd]
        int[] count2 = new int[2];
        for (int i = 0; i < n1; i++) count1[depth1[i] % 2]++;
        for (int i = 0; i < n2; i++) count2[depth2[i] % 2]++;

        int[] ans = new int[n1];
        for (int i = 0; i < n1; i++) {
            int parity = depth1[i] % 2;
            ans[i] = count1[parity] + Math.max(count2[0], count2[1]); // target = same parity in tree1 + opposite in tree2
        }

        return ans;
    }

    void fillDepths(int node, int parent, int depth, ArrayList<Integer>[] adj, int[] depths) {
        depths[node] = depth;
        for (int neighbor : adj[node]) {
            if (neighbor != parent) {
                fillDepths(neighbor, node, depth + 1, adj, depths);
            }
        }
    }

    ArrayList<Integer>[] getAdjacency(int[][] edges) {
        int n = edges.length + 1;
        ArrayList<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++)
            adj[i] = new ArrayList<>();
        for (int[] d : edges) {
            adj[d[0]].add(d[1]);
            adj[d[1]].add(d[0]);
        }
        return adj;
    }
}


/*

Example 1:
Input: edges1 = [[0,1],[0,2],[2,3],[2,4]], edges2 = [[0,1],[0,2],[0,3],[2,7],[1,4],[4,5],[4,6]]
Output: [8,7,7,8,8]
Explanation:
For i = 0, connect node 0 from the first tree to node 0 from the second tree.
For i = 1, connect node 1 from the first tree to node 4 from the second tree.
For i = 2, connect node 2 from the first tree to node 7 from the second tree.
For i = 3, connect node 3 from the first tree to node 0 from the second tree.
For i = 4, connect node 4 from the first tree to node 4 from the second tree.

Example 2:
Input: edges1 = [[0,1],[0,2],[0,3],[0,4]], edges2 = [[0,1],[1,2],[2,3]]
Output: [3,6,6,6,6]
Explanation:
For every i, connect node i of the first tree with any node of the second tree.

*/
