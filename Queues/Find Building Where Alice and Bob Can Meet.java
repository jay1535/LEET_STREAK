//Solution

    class Solution{
        public int[] leftmostBuildingQueries(int[] A, int[][] queries) {
        int n = A.length, qn = queries.length;
        List<int[]>[] que = new ArrayList[n];
        for (int i = 0; i < n; i++)
            que[i] = new ArrayList();
        PriorityQueue<int[]> h = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int[] res = new int[qn];
        Arrays.fill(res, -1);
        // Step 1
        for (int qi = 0; qi < qn; qi++) {
            int i = queries[qi][0], j = queries[qi][1];
            if (i < j && A[i] < A[j]) {
                res[qi] = j;
            } else if (i > j && A[i] > A[j]) {
                res[qi] = i;
            } else if (i == j) {
                res[qi] = i;
            } else { // Step 2
                que[Math.max(i, j)].add(new int[]{Math.max(A[i], A[j]), qi});
            }
        }
        // Step 3
        for (int i = 0; i < n; i++) {
            while (!h.isEmpty() && h.peek()[0] < A[i]) {
                res[h.poll()[1]] = i;
            }
            for (int[] q : que[i]) {
                h.add(q);
            }
        }

        return res;
    }
    }


/*

Example 1:
Input: heights = [6,4,8,5,2,7], queries = [[0,1],[0,3],[2,4],[3,4],[2,2]]
Output: [2,5,-1,5,2]
Explanation: In the first query, Alice and Bob can move to building 2 since heights[0] < heights[2] and heights[1] < heights[2]. 
In the second query, Alice and Bob can move to building 5 since heights[0] < heights[5] and heights[3] < heights[5]. 
In the third query, Alice cannot meet Bob since Alice cannot move to any other building.
In the fourth query, Alice and Bob can move to building 5 since heights[3] < heights[5] and heights[4] < heights[5].
In the fifth query, Alice and Bob are already in the same building.  
For ans[i] != -1, It can be shown that ans[i] is the leftmost building where Alice and Bob can meet.
For ans[i] == -1, It can be shown that there is no building where Alice and Bob can meet.

Example 2:
Input: heights = [5,3,8,2,6,1,4,6], queries = [[0,7],[3,5],[5,2],[3,0],[1,6]]
Output: [7,6,-1,4,6]
Explanation: In the first query, Alice can directly move to Bob's building since heights[0] < heights[7].
In the second query, Alice and Bob can move to building 6 since heights[3] < heights[6] and heights[5] < heights[6].
In the third query, Alice cannot meet Bob since Bob cannot move to any other building.
In the fourth query, Alice and Bob can move to building 4 since heights[3] < heights[4] and heights[0] < heights[4].
In the fifth query, Alice can directly move to Bob's building since heights[1] < heights[6].
For ans[i] != -1, It can be shown that ans[i] is the leftmost building where Alice and Bob can meet.
For ans[i] == -1, It can be shown that there is no building where Alice and Bob can meet.

*/
