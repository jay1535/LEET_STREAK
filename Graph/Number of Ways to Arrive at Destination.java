//Solution

import java.util.*;

class Solution {
    public int countPaths(int n, int[][] roads) {
        int mod = 1_000_000_007;
        List<int[]>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();

        for (int[] r : roads) {
            adj[r[0]].add(new int[]{r[1], r[2]});
            adj[r[1]].add(new int[]{r[0], r[2]});
        }

        long[] shortesttime = new long[n];
        int[] cnt = new int[n];
        Arrays.fill(shortesttime, Long.MAX_VALUE);

        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        shortesttime[0] = 0;
        cnt[0] = 1;
        pq.offer(new long[]{0, 0});

        while (!pq.isEmpty()) {
            long[] top = pq.poll();
            long time = top[0];
            int node = (int) top[1];

            if (time > shortesttime[node]) continue;

            for (int[] edge : adj[node]) {
                int nbr = edge[0], rtime = edge[1];

                if (time + rtime < shortesttime[nbr]) {
                    shortesttime[nbr] = time + rtime;
                    cnt[nbr] = cnt[node];
                    pq.offer(new long[]{shortesttime[nbr], nbr});
                } else if (time + rtime == shortesttime[nbr]) {
                    cnt[nbr] = (cnt[nbr] + cnt[node]) % mod;
                }
            }
        }

        return cnt[n - 1];
    }
}

/*

Example 1:
Input: n = 7, roads = [[0,6,7],[0,1,2],[1,2,3],[1,3,3],[6,3,3],[3,5,1],[6,5,1],[2,5,1],[0,4,5],[4,6,2]]
Output: 4
Explanation: The shortest amount of time it takes to go from intersection 0 to intersection 6 is 7 minutes.
The four ways to get there in 7 minutes are:
- 0 ➝ 6
- 0 ➝ 4 ➝ 6
- 0 ➝ 1 ➝ 2 ➝ 5 ➝ 6
- 0 ➝ 1 ➝ 3 ➝ 5 ➝ 6

Example 2:
Input: n = 2, roads = [[1,0,10]]
Output: 1
Explanation: There is only one way to go from intersection 0 to intersection 1, and it takes 10 minutes.

*/
