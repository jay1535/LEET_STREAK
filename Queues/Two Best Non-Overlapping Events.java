// Solution

class Solution {
    public int maxTwoEvents(int[][] events) 
    {
        Arrays.sort(events , (a,b)-> a[0]!=b[0]?a[0]-b[0]:a[1]-b[1]);
        PriorityQueue<int []> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        
        int max = 0 , ans = 0;
        pq.add(new int[]{events[0][1] , events[0][2]});
        
        for(int i=1 ; i<events.length ; i++)
        {
            while(!pq.isEmpty() && pq.peek()[0]<events[i][0])
            {
                int a[] = pq.poll();
                max = Math.max(max , a[1]);
            }
            ans = Math.max(ans , max + events[i][2]);
            pq.add(new int[]{events[i][1] , events[i][2]});
        }
        while(!pq.isEmpty())
        {
            ans = Math.max(ans , pq.poll()[1]);
        }
        
        return ans;
    }
}


/*

Example 1:
Input: events = [[1,3,2],[4,5,2],[2,4,3]]
Output: 4
Explanation: Choose the green events, 0 and 1 for a sum of 2 + 2 = 4.

Example 2:
Input: events = [[1,3,2],[4,5,2],[1,5,5]]
Output: 5
Explanation: Choose event 2 for a sum of 5.

Example 3:
Input: events = [[1,5,3],[1,5,1],[6,6,5]]
Output: 8
Explanation: Choose events 0 and 2 for a sum of 3 + 5 = 8.
 

*/
