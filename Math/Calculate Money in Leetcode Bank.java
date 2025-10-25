//Solution

class Solution {
    public int totalMoney(int n) {
        int monday = 0, count = 0, sum = 0;

        for(int i = 1; i <= n; i++) {
            if(count == 7) {
                monday = i / 7 + 1;
                count = 0;
            } else {
                monday++;
            }
            sum += monday;
            count++;
        }
        return sum;
    }
}

/*
Example 1:

Input: n = 4
Output: 10
Explanation: After the 4th day, the total is 1 + 2 + 3 + 4 = 10.
Example 2:

Input: n = 10
Output: 37
Explanation: After the 10th day, the total is (1 + 2 + 3 + 4 + 5 + 6 + 7) + (2 + 3 + 4) = 37. Notice that on the 2nd Monday, Hercy only puts in $2.
Example 3:

Input: n = 20
Output: 96
Explanation: After the 20th day, the total is (1 + 2 + 3 + 4 + 5 + 6 + 7) + (2 + 3 + 4 + 5 + 6 + 7 + 8) + (3 + 4 + 5 + 6 + 7 + 8) = 96.

*/
