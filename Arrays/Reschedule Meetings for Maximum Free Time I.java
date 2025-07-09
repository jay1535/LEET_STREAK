//Solution

class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int ay[] = new int[startTime.length +1];
        ay[0] = startTime[0]-0;
        int n = ay.length, mx=0, rst=0;
        for(int i =1; i< ay.length-1; i++){
            ay[i] = startTime[i] - endTime[i-1];
            
        }
        ay[n-1] = eventTime - endTime[n-2];
        for(int i = 0; i<= k && k< n ; i++) {
            mx += ay[i];
        }
        rst = Math.max(rst, mx);
       for(int i = 1; i<n-k; i++){
           mx -= ay[i-1];
           mx += ay[i+k];
           rst = Math.max(mx, rst);
       }
          return rst;
        
    }
   
}

/*

Example 1:
Input: eventTime = 5, k = 1, startTime = [1,3], endTime = [2,5]
Output: 2
Explanation:
Reschedule the meeting at [1, 2] to [2, 3], leaving no meetings during the time [0, 2].

Example 2:
Input: eventTime = 10, k = 1, startTime = [0,2,9], endTime = [1,4,10]
Output: 6
Explanation:
Reschedule the meeting at [2, 4] to [1, 3], leaving no meetings during the time [3, 9].

Example 3:
Input: eventTime = 5, k = 2, startTime = [0,1,2,3,4], endTime = [1,2,3,4,5]
Output: 0
Explanation:
There is no time during the event not occupied by meetings.

*/
