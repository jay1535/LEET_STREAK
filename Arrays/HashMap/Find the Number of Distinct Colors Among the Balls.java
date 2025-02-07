//Solution

import java.util.*;
class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        Map<Integer,Integer> ball = new HashMap<>(), color = new HashMap<>();
        int n = queries.length, distinct = 0;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++){
            int pos = queries[i][0], c = queries[i][1];
            if(ball.containsKey(pos)){
                int cnt = color.get(ball.get(pos)) - 1;
                if(cnt == 0){ color.remove(ball.get(pos)); distinct--; }
                else color.put(ball.get(pos), cnt);
            }
            ball.put(pos, c);
            int cnt = color.getOrDefault(c, 0) + 1;
            color.put(c, cnt);
            if(cnt == 1) distinct++;
            ans[i] = distinct;
        }
        return ans;
    }
}


/*

Example 1:
Input: limit = 4, queries = [[1,4],[2,5],[1,3],[3,4]]
Output: [1,2,2,3]
Explanation:
After query 0, ball 1 has color 4.
After query 1, ball 1 has color 4, and ball 2 has color 5.
After query 2, ball 1 has color 3, and ball 2 has color 5.
After query 3, ball 1 has color 3, ball 2 has color 5, and ball 3 has color 4.

Example 2:
Input: limit = 4, queries = [[0,1],[1,2],[2,2],[3,4],[4,5]]
Output: [1,2,2,3,4]
Explanation:
After query 0, ball 0 has color 1.
After query 1, ball 0 has color 1, and ball 1 has color 2.
After query 2, ball 0 has color 1, and balls 1 and 2 have color 2.
After query 3, ball 0 has color 1, balls 1 and 2 have color 2, and ball 3 has color 4.
After query 4, ball 0 has color 1, balls 1 and 2 have color 2, ball 3 has color 4, and ball 4 has color 5.

*/
