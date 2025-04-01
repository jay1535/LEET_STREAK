//Solution

class Solution {
    public long mostPoints(int[][] questions) {
        int n  =questions.length;
        long[] res = new long[n];
        res[n-1] = questions[n-1][0];
        for(int i = n-2;i>=0;i--){
            if(questions[i][1]+i+1>=n){
                res[i] = Math.max(questions[i][0],res[i+1]);
            }else{
                res[i] = Math.max(res[i+1],questions[i][0]+res[i+1+questions[i][1]]);
            }
        }
        return res[0];
    }
}

/*

Example 1:
Input: questions = [[3,2],[4,3],[4,4],[2,5]]
Output: 5
Explanation: The maximum points can be earned by solving questions 0 and 3.
- Solve question 0: Earn 3 points, will be unable to solve the next 2 questions
- Unable to solve questions 1 and 2
- Solve question 3: Earn 2 points
Total points earned: 3 + 2 = 5. There is no other way to earn 5 or more points.

Example 2:
Input: questions = [[1,1],[2,2],[3,3],[4,4],[5,5]]
Output: 7
Explanation: The maximum points can be earned by solving questions 1 and 4.
- Skip question 0
- Solve question 1: Earn 2 points, will be unable to solve the next 2 questions
- Unable to solve questions 2 and 3
- Solve question 4: Earn 5 points
Total points earned: 2 + 5 = 7. There is no other way to earn 7 or more points.
 
*/
