// Solution

class Solution {
    public double maxAverageRatio(int[][] cls, int extra) {
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));

        for (int[] c : cls) {
            int p = c[0], t = c[1];
            pq.offer(new double[]{gain(p, t), p, t});
        }
        while (extra-- > 0) {
            double[] top = pq.poll();
            double g = top[0];
            int p = (int) top[1], t = (int) top[2];
            pq.offer(new double[]{gain(p + 1, t + 1), p + 1, t + 1});
        }
        double sum = 0;
        for (double[] c : pq) {
            sum += c[1] / c[2];
        }
        return sum / cls.length;
    }
    private double gain(int p, int t) {
        return (double) (p + 1) / (t + 1) - (double) p / t;
    }
}

/*

Example 1:
Input: classes = [[1,2],[3,5],[2,2]], extraStudents = 2
Output: 0.78333
Explanation: You can assign the two extra students to the first class. The average pass ratio will be equal to (3/4 + 3/5 + 2/2) / 3 = 0.78333.

Example 2:
Input: classes = [[2,4],[3,9],[4,5],[2,10]], extraStudents = 4
Output: 0.53485

*/
