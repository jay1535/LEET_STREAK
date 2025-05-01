//Solution


import java.util.*;

class Solution {
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        Arrays.sort(tasks);
        Arrays.sort(workers);
        int low = 0, high = Math.min(tasks.length, workers.length);

        while (low < high) {
            int mid = (low + high + 1) / 2;
            if (canAssign(tasks, workers, pills, strength, mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }

    private boolean canAssign(int[] tasks, int[] workers, int pills, int strength, int taskCount) {
        Deque<Integer> boosted = new ArrayDeque<>();
        int w = workers.length - 1;
        int freePills = pills;

        for (int t = taskCount - 1; t >= 0; t--) {
            int task = tasks[t];

            if (!boosted.isEmpty() && boosted.peekFirst() >= task) {
                boosted.pollFirst();
            } else if (w >= 0 && workers[w] >= task) {
                w--;
            } else {
                while (w >= 0 && workers[w] + strength >= task) {
                    boosted.addLast(workers[w--]);
                }
                if (boosted.isEmpty() || freePills == 0) {
                    return false;
                }
                boosted.pollLast();
                freePills--;
            }
        }

        return true;
    }
}

/*

Example 1:
Input: tasks = [3,2,1], workers = [0,3,3], pills = 1, strength = 1
Output: 3
Explanation:
We can assign the magical pill and tasks as follows:
- Give the magical pill to worker 0.
- Assign worker 0 to task 2 (0 + 1 >= 1)
- Assign worker 1 to task 1 (3 >= 2)
- Assign worker 2 to task 0 (3 >= 3)

Example 2:
Input: tasks = [5,4], workers = [0,0,0], pills = 1, strength = 5
Output: 1
Explanation:
We can assign the magical pill and tasks as follows:
- Give the magical pill to worker 0.
- Assign worker 0 to task 0 (0 + 5 >= 5)

Example 3:
Input: tasks = [10,15,30], workers = [0,10,10,10,10], pills = 3, strength = 10
Output: 2
Explanation:
We can assign the magical pills and tasks as follows:
- Give the magical pill to worker 0 and worker 1.
- Assign worker 0 to task 0 (0 + 10 >= 10)
- Assign worker 1 to task 1 (10 + 10 >= 15)
The last pill is not given because it will not make any worker strong enough for the last task.

*/
