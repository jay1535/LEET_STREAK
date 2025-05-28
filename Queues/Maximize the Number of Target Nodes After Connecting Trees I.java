//Solution

class Solution {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        int n = edges1.length + 1;
        int m = edges2.length + 1;
        List<Integer>[] g1 = buildGraph(edges1, n);
        List<Integer>[] g2 = buildGraph(edges2, m);
        if (k == 0) {
            int[] ans = new int[n];
            Arrays.fill(ans, 1);
            return ans;
        }
        int[] cnt1 = bfsCount(g1, k);
        int[] cnt2 = bfsCount(g2, k - 1);
        int best2 = 0;
        for (int x : cnt2) best2 = Math.max(best2, x);
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = cnt1[i] + best2;
        }
        return ans;
    }

    private List<Integer>[] buildGraph(int[][] edges, int sz) {
        @SuppressWarnings("unchecked")
        List<Integer>[] g = new List[sz];
        for (int i = 0; i < sz; i++) g[i] = new ArrayList<>();
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            g[u].add(v);
            g[v].add(u);
        }
        return g;
    }

    private int[] bfsCount(List<Integer>[] g, int K) {
        int N = g.length;
        int[] result = new int[N], visited = new int[N];
        int stamp = 1;
        Deque<Integer> queue = new ArrayDeque<>();
        for (int start = 0; start < N; start++, stamp++) {
            if (K < 0) {
                result[start] = 1;
                continue;
            }
            queue.clear();
            queue.add(start);
            visited[start] = stamp;
            int level = 0, count = 1;
            while (!queue.isEmpty() && level < K) {
                int sz = queue.size();
                for (int i = 0; i < sz; i++) {
                    int u = queue.poll();
                    for (int v : g[u]) {
                        if (visited[v] != stamp) {
                            visited[v] = stamp;
                            queue.add(v);
                            count++;
                        }
                    }
                }
                level++;
            }
            result[start] = count;
        }
        return result;
    }
}

/*

Example 1:

Input: edges1 = [[0,1],[0,2],[2,3],[2,4]], edges2 = [[0,1],[0,2],[0,3],[2,7],[1,4],[4,5],[4,6]], k = 2

Output: [9,7,9,8,8]

Explanation:

For i = 0, connect node 0 from the first tree to node 0 from the second tree.
For i = 1, connect node 1 from the first tree to node 0 from the second tree.
For i = 2, connect node 2 from the first tree to node 4 from the second tree.
For i = 3, connect node 3 from the first tree to node 4 from the second tree.
For i = 4, connect node 4 from the first tree to node 4 from the second tree.

Example 2:

Input: edges1 = [[0,1],[0,2],[0,3],[0,4]], edges2 = [[0,1],[1,2],[2,3]], k = 1

Output: [6,3,3,3,3]

Explanation:

For every i, connect node i of the first tree with any node of the second tree.



*/
