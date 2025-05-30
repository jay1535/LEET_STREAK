//Solution


public class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int[] dist1 = getDistances(edges, node1);
        int[] dist2 = getDistances(edges, node2);

        int result = -1;
        int minDistance = Integer.MAX_VALUE;

        for (int i = 0; i < edges.length; i++) {
            if (dist1[i] != -1 && dist2[i] != -1) {
                int maxDist = Math.max(dist1[i], dist2[i]);
                if (maxDist < minDistance) {
                    minDistance = maxDist;
                    result = i;
                }
            }
        }
        return result;
    }

    private int[] getDistances(int[] edges, int start) {
        int n = edges.length;
        int[] dist = new int[n];
        java.util.Arrays.fill(dist, -1);
        int d = 0;
        while (start != -1 && dist[start] == -1) {
            dist[start] = d++;
            start = edges[start];
        }
        return dist;
    }
}


/*

Example 1:


Input: edges = [2,2,3,-1], node1 = 0, node2 = 1
Output: 2
Explanation: The distance from node 0 to node 2 is 1, and the distance from node 1 to node 2 is 1.
The maximum of those two distances is 1. It can be proven that we cannot get a node with a smaller maximum distance than 1, so we return node 2.
Example 2:


Input: edges = [1,2,-1], node1 = 0, node2 = 2
Output: 2
Explanation: The distance from node 0 to node 2 is 2, and the distance from node 2 to itself is 0.
The maximum of those two distances is 2. It can be proven that we cannot get a node with a smaller maximum distance than 2, so we return node 2.

*/
