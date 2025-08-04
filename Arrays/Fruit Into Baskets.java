//Solution

public class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        int lastFruit = -1, secondLastFruit = -1;
        int lastCount = 0, currMax = 0, max = 0;

        for (int i = 0; i < n; i++) {
            int fruit = fruits[i];

            if (fruit == lastFruit || fruit == secondLastFruit) {
                currMax++;
            } else {
                currMax = lastCount + 1;
            }

            if (fruit == lastFruit) {
                lastCount++;
            } else {
                lastCount = 1;
                secondLastFruit = lastFruit;
                lastFruit = fruit;
            }

            max = Math.max(max, currMax);
        }

        return max;
    }
}

/*

Example 1:

Input: fruits = [1,2,1]
Output: 3
Explanation: We can pick from all 3 trees.
Example 2:

Input: fruits = [0,1,2,2]
Output: 3
Explanation: We can pick from trees [1,2,2].
If we had started at the first tree, we would only pick from trees [0,1].
Example 3:

Input: fruits = [1,2,3,2,2]
Output: 4
Explanation: We can pick from trees [2,3,2,2].
If we had started at the first tree, we would only pick from trees [1,2].

*/
