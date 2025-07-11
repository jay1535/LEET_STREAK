//SOlution

class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, Comparator.comparingInt(a->a[0]));
        PriorityQueue<Integer> free = new PriorityQueue<>();
        for(int i =0; i<n; ++i){
            free.offer(i);
        }
        PriorityQueue<long[]> busy = new PriorityQueue<>((a,b)->a[0]==b[0] ? Long.compare(a[1],b[1]): Long.compare(a[0],b[0]));
    
    int[] cnt = new int[n];
    for(int[] m : meetings){
        long start = m[0], end = m[1];
        while(!busy.isEmpty() && busy.peek()[0] <=start){
            free.offer((int) busy.poll()[1]);
        }
        int room;
        long newEnd;
        if(!free.isEmpty()){
            room = free.poll();
            newEnd = end;
        }
        else{
            long[] e = busy.poll();
            room = (int)e[1];
            newEnd = e[0] + (end-start);

        }
        busy.offer(new long[] {newEnd, room});
        cnt[room]++;
    }
    int best = 0;
    for(int i =1; i< n; ++i){
        if(cnt[i] > cnt[best]) best = i;

    }
    return best;
}
}

/*

Example 1:

Input: n = 2, meetings = [[0,10],[1,5],[2,7],[3,4]]
Output: 0
Explanation:
- At time 0, both rooms are not being used. The first meeting starts in room 0.
- At time 1, only room 1 is not being used. The second meeting starts in room 1.
- At time 2, both rooms are being used. The third meeting is delayed.
- At time 3, both rooms are being used. The fourth meeting is delayed.
- At time 5, the meeting in room 1 finishes. The third meeting starts in room 1 for the time period [5,10).
- At time 10, the meetings in both rooms finish. The fourth meeting starts in room 0 for the time period [10,11).
Both rooms 0 and 1 held 2 meetings, so we return 0. 
Example 2:

Input: n = 3, meetings = [[1,20],[2,10],[3,5],[4,9],[6,8]]
Output: 1
Explanation:
- At time 1, all three rooms are not being used. The first meeting starts in room 0.
- At time 2, rooms 1 and 2 are not being used. The second meeting starts in room 1.
- At time 3, only room 2 is not being used. The third meeting starts in room 2.
- At time 4, all three rooms are being used. The fourth meeting is delayed.
- At time 5, the meeting in room 2 finishes. The fourth meeting starts in room 2 for the time period [5,10).
- At time 6, all three rooms are being used. The fifth meeting is delayed.
- At time 10, the meetings in rooms 1 and 2 finish. The fifth meeting starts in room 1 for the time period [10,12).
Room 0 held 1 meeting while rooms 1 and 2 each held 2 meetings, so we return 1. 

*/
