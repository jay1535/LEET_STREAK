// Solution

class Solution {
    
    private int bellmanFordHelper(List<List<Integer>> list) {
        int n = list.size();
        
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = 0;
 
         Queue<Integer> queue = new LinkedList<>();
        queue.add(0);

        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int v : list.get(u)) {
                if (distance[u] + 1 < distance[v]) {
                    distance[v] = distance[u] + 1;
                    queue.add(v);
                }
            }
        }

        return distance[n - 1];
    }
    
    
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            list.get(i).add(i + 1);
        }
        
        int[] res = new int[queries.length];
        int i=0;
        for (int[] query:queries) {
            list.get(query[0]).add(query[1]);
            res[i++] = bellmanFordHelper(list);
        }

        return res;
    }
}

/*

Example 1:
Input: n = 5, queries = [[2,4],[0,2],[0,4]]
Output: [3,2,1]
Explanation:
After the addition of the road from 2 to 4, the length of the shortest path from 0 to 4 is 3.
After the addition of the road from 0 to 2, the length of the shortest path from 0 to 4 is 2.
After the addition of the road from 0 to 4, the length of the shortest path from 0 to 4 is 1.

Example 2:
Input: n = 4, queries = [[0,3],[0,2]]
Output: [1,1]
Explanation:
After the addition of the road from 0 to 3, the length of the shortest path from 0 to 3 is 1.
After the addition of the road from 0 to 2, the length of the shortest path remains 1.

*/
