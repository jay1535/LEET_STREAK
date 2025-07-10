//Solution

class Solution {
    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        int n = startTime.length;
        if (n == 0) return eventTime;

        int[] gaps = new int[n + 1];
        gaps[0] = startTime[0];

        for (int i = 1; i < n; i++) {
            gaps[i] = startTime[i] - endTime[i - 1];
        }
        gaps[n] = eventTime - endTime[n - 1];

        int[] largestRight = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            largestRight[i] = Math.max(largestRight[i + 1], gaps[i + 1]);
        }

        int maxFree = 0, largestLeft = 0;
        for (int i = 1; i <= n; i++) {
            int duration = endTime[i - 1] - startTime[i - 1];
            boolean canFitLeft = largestLeft >= duration;
            boolean canFitRight = largestRight[i] >= duration;

            if (canFitLeft || canFitRight) {
                int merged = gaps[i - 1] + gaps[i] + duration;
                maxFree = Math.max(maxFree, merged);
            }

            maxFree = Math.max(maxFree, gaps[i - 1] + gaps[i]);
            largestLeft = Math.max(largestLeft, gaps[i - 1]);
        }

        return maxFree;
    }
}

/*
Example 1:

Input: eventTime = 5, startTime = [1,3], endTime = [2,5]

Output: 2

Explanation:



Reschedule the meeting at [1, 2] to [2, 3], leaving no meetings during the time [0, 2].

Example 2:

Input: eventTime = 10, startTime = [0,7,9], endTime = [1,8,10]

Output: 7

Explanation:



Reschedule the meeting at [0, 1] to [8, 9], leaving no meetings during the time [0, 7].

Example 3:

Input: eventTime = 10, startTime = [0,3,7,9], endTime = [1,4,8,10]

Output: 6

Explanation:



Reschedule the meeting at [3, 4] to [8, 9], leaving no meetings during the time [1, 7].

Example 4:

Input: eventTime = 5, startTime = [0,1,2,3,4], endTime = [1,2,3,4,5]

Output: 0

Explanation:

There is no time during the event not occupied by meetings.

*/
