//Solution


class Solution {
    public int numRabbits(int[] answers) {
        Arrays.sort(answers);
        int res = 0, count = 0;

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == 0) {
                res++;  
            } else if (i == 0 || answers[i] != answers[i - 1] || count == 0) {
                res += answers[i] + 1;  
                count = answers[i];
            } else {
                count--;  
            }
        }
        return res;
    }
}

/*

Example 1:
Input: answers = [1,1,2]
Output: 5
Explanation:
The two rabbits that answered "1" could both be the same color, say red.
The rabbit that answered "2" can't be red or the answers would be inconsistent.
Say the rabbit that answered "2" was blue.
Then there should be 2 other blue rabbits in the forest that didn't answer into the array.
The smallest possible number of rabbits in the forest is therefore 5: 3 that answered plus 2 that didn't.

Example 2:
Input: answers = [10,10,10]
Output: 11

*/
