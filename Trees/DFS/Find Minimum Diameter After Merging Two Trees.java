//Solution

class Solution {
    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        int d1 = getDiameter(edges1);
        int d2 = getDiameter(edges2);
        return Math.max(Math.max(d1 - 1, d2 - 1), d1 / 2 + d2 / 2 + 1);
    }

    private int getDiameter(int[][] edges) {
        List<List<Integer>> map = new ArrayList<>();
        for (int i = 0; i < edges.length + 1; i++) {
            map.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int i = edge[0];
            int j = edge[1];
            map.get(i).add(j);
            map.get(j).add(i);
        }

        int[] res = { 0 };

        dfs(0, -1, map, res);

        return res[0];
    }

    private int dfs(int node, int parent, List<List<Integer>> map, int[] res) {
        int maxDepth = 1;
        for (int neighbor : map.get(node)) {
            if (neighbor == parent)
                continue;
            int depth = dfs(neighbor, node, map, res);
            res[0] = Math.max(res[0], maxDepth + depth);
            maxDepth = Math.max(maxDepth, 1 + depth);
        }
        return maxDepth;
    }
}

/*

Example 1:
Input: edges1 = [[0,1],[0,2],[0,3]], edges2 = [[0,1]]
Output: 3
Explanation:
We can obtain a tree of diameter 3 by connecting node 0 from the first tree with any node from the second tree.

Example 2:
Input: edges1 = [[0,1],[0,2],[0,3],[2,4],[2,5],[3,6],[2,7]], edges2 = [[0,1],[0,2],[0,3],[2,4],[2,5],[3,6],[2,7]]
Output: 5
Explanation:
We can obtain a tree of diameter 5 by connecting node 0 from the first tree with node 0 from the second tree.

 

*/
