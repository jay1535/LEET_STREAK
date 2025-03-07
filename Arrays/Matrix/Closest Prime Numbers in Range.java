//Solution


class Solution {
    public int[] closestPrimes(int left, int right) {
        if (right < 2)
            return new int[] { -1, -1 };
        if (left == 1) {
            left = 2;
        }

        boolean[] map = new boolean[right + 1];

        int index;
        for (index = 2; index * index <= right; index++) {
            if (!map[index]) {
                for (int j = index * index; j <= right; j += index) {
                    map[j] = true;
                }
            }
        }

        int prevPrime = -1, num1 = -1, num2 = -1;
        int minGap = Integer.MAX_VALUE;

        for (int i = left; i <= right; i++) {
            if (!map[i]) {
                if (prevPrime != -1 && (i - prevPrime < minGap)) {
                    num1 = prevPrime;
                    num2 = i;
                    minGap = i - prevPrime;
                }
                prevPrime = i;
            }
        }
        return (num1 == -1) ? new int[] { -1, -1 } : new int[] { num1, num2 };
    }
}

/*

Example 1:
Input: left = 10, right = 19
Output: [11,13]
Explanation: The prime numbers between 10 and 19 are 11, 13, 17, and 19.
The closest gap between any pair is 2, which can be achieved by [11,13] or [17,19].
Since 11 is smaller than 17, we return the first pair.

Example 2:
Input: left = 4, right = 6
Output: [-1,-1]
Explanation: There exists only one prime number in the given range, so the conditions cannot be satisfied.

*/
