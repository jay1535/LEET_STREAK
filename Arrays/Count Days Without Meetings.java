//Solution

class Solution {
    public int countDays(int days, int[][] meetings) {
        int n=meetings.length;

        if(n==1){
            return days-(meetings[0][1]-meetings[0][0]+1);
        }

        Arrays.sort(meetings, (a,b)->a[0]-b[0]);

        for(int i=1; i<n; i++){
            if(meetings[i-1][1]>=meetings[i][0]){
                meetings[i][0]=meetings[i-1][0];                
                meetings[i][1]=Math.max(meetings[i-1][1], meetings[i][1]);
            }else{
                days-=meetings[i-1][1]-meetings[i-1][0]+1;
            }   
        }
 
        days-=meetings[n-1][1]-meetings[n-1][0]+1;

        return days;
    }
}
/*

Example 1:
Input: days = 10, meetings = [[5,7],[1,3],[9,10]]
Output: 2
Explanation:
There is no meeting scheduled on the 4th and 8th days.

Example 2:
Input: days = 5, meetings = [[2,4],[1,3]]
Output: 1
Explanation:
There is no meeting scheduled on the 5th day.

Example 3:
Input: days = 6, meetings = [[1,6]]
Output: 0
Explanation:
Meetings are scheduled for all working days.

*/
