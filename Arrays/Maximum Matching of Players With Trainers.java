//Solution

class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int i =0, j = 0, count = 0;
        while(i<players.length && j < trainers.length){
            if(players[i] <= trainers[j]){
                i++;
                count++;
            }
            j++;
        }
        return count;
    }
}

/*
Example 1:

Input: players = [4,7,9], trainers = [8,2,5,8]
Output: 2
Explanation:
One of the ways we can form two matchings is as follows:
- players[0] can be matched with trainers[0] since 4 <= 8.
- players[1] can be matched with trainers[3] since 7 <= 8.
It can be proven that 2 is the maximum number of matchings that can be formed.
Example 2:

Input: players = [1,1,1], trainers = [10]
Output: 1
Explanation:
The trainer can be matched with any of the 3 players.
Each player can only be matched with one trainer, so the maximum answer is 1.

*/
